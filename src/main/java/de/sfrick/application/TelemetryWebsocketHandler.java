package de.sfrick.application;

import de.sfrick.udp.WebSocketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;


public class TelemetryWebsocketHandler extends TextWebSocketHandler {

   private static final Logger LOGGER = LoggerFactory.getLogger(TelemetryWebsocketHandler.class);

   @Override
   protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
      super.handleTextMessage(session, message);
   }


   @Override
   public void afterConnectionEstablished(WebSocketSession session) throws Exception {
      super.afterConnectionEstablished(session);
      Channel channel = WebSocketService.addSubscriber(session);
      if (channel != null) {
         session.sendMessage(new TextMessage(channel.getChannelName().toString()));
      }
   }

   @Override
   public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
      super.afterConnectionClosed(session, status);
   }
}
