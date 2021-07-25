package de.sfrick.application;

import de.sfrick.udp.TelemetryDataClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebsocketConfig implements WebSocketConfigurer {

   private final TelemetryDataClient telemetryDataClient;

   @Override
   public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
      webSocketHandlerRegistry.addHandler(new TelemetryWebsocketHandler(telemetryDataClient), "/");
   }
}
