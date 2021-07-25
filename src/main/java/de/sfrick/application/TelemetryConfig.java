package de.sfrick.application;

import de.sfrick.udp.TelemetryDataClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.SocketException;

@Configuration
public class TelemetryConfig {

   @Value("${udp.port}") private String port;
//   @SneakyThrows
   @Bean
   public TelemetryDataClient echoServer() {
      TelemetryDataClient telemetryDataClient = null;
      try {
         telemetryDataClient = new TelemetryDataClient(Integer.parseInt(port));
      } catch (SocketException e) {
         e.printStackTrace();
      }
      if (telemetryDataClient != null) {
//         echoServer.run();
      }
      return telemetryDataClient;
   }
}
