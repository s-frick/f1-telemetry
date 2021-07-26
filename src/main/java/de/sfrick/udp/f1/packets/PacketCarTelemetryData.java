package de.sfrick.udp.f1.packets;

import de.sfrick.udp.f1.data.CarTelemetryData;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PacketCarTelemetryData implements Packet {

//   TODO
/*
   struct PacketCarTelemetryData
   {
      PacketHeader    	m_header;	      // Header

      CarTelemetryData    m_carTelemetryData[22];

      uint8               m_mfdPanelIndex;       // Index of MFD panel open - 255 = MFD closed
      // Single player, race – 0 = Car setup, 1 = Pits
      // 2 = Damage, 3 =  Engine, 4 = Temperatures
      // May vary depending on game mode
      uint8               m_mfdPanelIndexSecondaryPlayer;   // See above
      int8                m_suggestedGear;       // Suggested gear for the player (1-8)
      // 0 if no gear suggested
   };
*/


   private Header header;
   private List<CarTelemetryData> carTelemetryData;
   private int mfdPanelIdx;
   private int mfdPanelIdxSecondaryPlayer;
   private int suggestedGear;

}
