package de.sfrick.application;

import de.sfrick.udp.TelemetryDataClient;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;


@Component
@RequiredArgsConstructor
public class TelemetryWebsocketHandler extends TextWebSocketHandler {

   private static final Logger LOGGER = LoggerFactory.getLogger(TelemetryWebsocketHandler.class);
   private final List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();
   private final Map<String, List<WebSocketSession>> subscribers = new HashMap<>();
   private final TelemetryDataClient telemetryDataClient;


   @Override
   public void afterConnectionEstablished(WebSocketSession session) throws Exception {
      sessions.add(session);
      super.afterConnectionEstablished(session);
   }

   @Override
   public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
      sessions.remove(session);
      super.afterConnectionClosed(session, status);
   }

   @Override
   protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
      super.handleTextMessage(session, message);
      var payload = message.getPayload();
      session.sendMessage(message);
      if (subscribers.containsKey(payload)) {
         subscribers.get(payload).add(session);
      } else {
         var list = new ArrayList<WebSocketSession>();
         list.add(session);
         subscribers.put(payload, list);
      }
      telemetryDataClient.setWebsocket(this);
      telemetryDataClient.run();
   }


   public void broadcast(Message message) {
      if (subscribers.containsKey(message.getKey())) {
         subscribers.get(message.getKey()).forEach(subscriber -> {
            Try.run(() -> subscriber.sendMessage(message.getTextMessage()))
                  .onFailure(throwable -> LOGGER.error("Failure occured while broadcasting message", throwable));
         });
      }

   }
}
