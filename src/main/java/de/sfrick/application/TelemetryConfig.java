package de.sfrick.application;

import de.sfrick.udp.TelemetryDataClient;
import io.vavr.control.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.SocketException;

@Configuration
public class TelemetryConfig {

   private static final Logger LOGGER = LoggerFactory.getLogger(TelemetryWebsocketHandler.class);
   @Value("${udp.port}")
   private String port;

   @Bean
   public TelemetryDataClient echoServer() {
      return Try.of(() -> new TelemetryDataClient(Integer.parseInt(port)))
            .onFailure(throwable -> LOGGER.error("Failed starting UDP client", throwable))
            .get();
   }
}
