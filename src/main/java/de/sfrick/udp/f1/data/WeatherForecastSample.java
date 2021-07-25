package de.sfrick.udp.f1.data;


import de.sfrick.udp.f1.packets.Packet;
import de.sfrick.udp.f1.packets.Header;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class WeatherForecastSample implements Packet {

   private Header header;

   private SessionType sessionType;
   private int timeOffset;
   private Weather weather;
   private int trackTemperature;
   private int trackTemperatureChange;
   private int airTemperature;
   private int airTemperatureChange;
   private int rainPercentage;
}
