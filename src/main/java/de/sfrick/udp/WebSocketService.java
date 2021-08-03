package de.sfrick.udp;

import de.sfrick.application.Channel;
import de.sfrick.application.Message;
import io.vavr.control.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import static java.util.Objects.nonNull;

@Component
public class WebSocketService extends Thread {

   private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketService.class);
   private static final Map<Channel, List<WebSocketSession>> channelSubscribersMap = new ConcurrentHashMap<>();

   public WebSocketService(List<Channel> messageQueue) {
      messageQueue.forEach(channel -> {
         channelSubscribersMap.put(channel, new CopyOnWriteArrayList<>());
      });
   }

   @Override
   public void run() {
      while (currentThread().isAlive()) {
         channelSubscribersMap.entrySet()
               .parallelStream()
               .filter(channelListEntry -> nonNull(channelListEntry.getKey().peek()))
               .map(channelListEntry -> Map.entry(Objects.requireNonNull(channelListEntry.getKey().poll()), channelListEntry.getValue()))
//               .filter(messageListEntry -> nonNull(messageListEntry.getKey()))
               .forEach(messageListEntry -> {
                  LOGGER.info("try sending message {} to subscribers", messageListEntry.getKey(), String.join(", ", messageListEntry.getValue().toString()));
                  List<WebSocketSession> sessions = messageListEntry.getValue();
                  Message message = messageListEntry.getKey();
                  sessions.forEach(session -> {
                     Try.run(() -> session.sendMessage(message.getTextMessage()))
                           .onFailure(throwable -> LOGGER.error("Failure occured while broadcasting message", throwable));
                  });
               });
      }
   }


   public static Channel addSubscriber(WebSocketSession webSocketSession) {
      Optional<Map.Entry<Channel, List<WebSocketSession>>> channelFound =
            channelSubscribersMap.entrySet().stream().filter(entry -> "/".concat(entry.getKey().getChannelName().toString().toLowerCase()).equals(webSocketSession.getUri().getPath())).findFirst();
      if (channelFound.isPresent()) {
         channelSubscribersMap.get(channelFound.get().getKey()).add(webSocketSession);
      }
      return channelFound.get().getKey();
   }

   public static void unSubscribe(Channel channel, WebSocketSession session) {
      if (channelSubscribersMap.containsKey(channel)) {
         channelSubscribersMap.get(channel).remove(session);
      }
   }
}
