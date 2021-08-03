package de.sfrick.application;

import de.sfrick.udp.f1.packets.PacketType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistration;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import java.util.List;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebsocketConfig implements WebSocketConfigurer {

   private final List<Channel> channels;

   @Override
   public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
      WebSocketHandlerRegistration webSocketHandlerRegistration = null;
      for (PacketType type : PacketType.values()) {
         Channel channel = Channel.of(type);
         channels.add(channel);
         webSocketHandlerRegistration = webSocketHandlerRegistry
               .addHandler(new TelemetryWebsocketHandler(), "/" + type.name().toLowerCase());
      }
      assert webSocketHandlerRegistration != null;
      webSocketHandlerRegistration.setAllowedOrigins("*");
   }
}
