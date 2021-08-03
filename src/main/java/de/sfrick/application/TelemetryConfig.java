package de.sfrick.application;

import de.sfrick.udp.TelemetryDataClient;
import de.sfrick.udp.WebSocketService;
import de.sfrick.udp.f1.packets.PacketType;
import io.vavr.control.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class TelemetryConfig {

   private static final Logger LOGGER = LoggerFactory.getLogger(TelemetryConfig.class);
   @Value("${udp.port}")
   private String port;

   @Bean
   public TelemetryDataClient telemetryDataClient(List<Channel> messageQueue) {
      return Try.of(() -> new TelemetryDataClient(Integer.parseInt(port), messageQueue))
            .andThen(Thread::start)
            .onFailure(throwable -> LOGGER.error("Failed starting UDP client", throwable))
            .get();
   }

   @Bean
   public WebSocketService webSocketService(List<Channel> messageQueue) {
      WebSocketService webSocketService = new WebSocketService(messageQueue);
      webSocketService.start();
      return webSocketService;
   }

   @Bean
   public List<Channel> messageQueue() {
      return Arrays.stream(PacketType.values())
            .map(Channel::of)
            .collect(Collectors.toList());
   }
}
