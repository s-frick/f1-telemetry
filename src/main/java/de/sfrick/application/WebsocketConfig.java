package de.sfrick.application;

import de.sfrick.udp.WebSocketService;
import de.sfrick.udp.f1.packets.PacketType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistration;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import java.util.Arrays;
import java.util.List;

import static de.sfrick.udp.f1.packets.PacketType.values;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebsocketConfig implements WebSocketConfigurer {

   private final List<Channel> channels;
   private final WebSocketService webSocketService;

   @Override
   public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
      WebSocketHandlerRegistration webSocketHandlerRegistration = null;
      for (PacketType type: PacketType.values()) {
         Channel channel = Channel.of(type);
         channels.add(channel);
         webSocketHandlerRegistration = webSocketHandlerRegistry
               .addHandler(new TelemetryWebsocketHandler(webSocketService), "/" + type.name().toLowerCase());
      }
      assert webSocketHandlerRegistration != null;
      webSocketHandlerRegistration.setAllowedOrigins("*");
   }
}
