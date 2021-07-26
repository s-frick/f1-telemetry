package de.sfrick.udp.f1.packets;

import de.sfrick.udp.f1.data.LapData;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PacketLapData implements Packet {

//   TODO
/*
   struct PacketLapData
   {
      PacketHeader    m_header;              // Header

      LapData         m_lapData[22];         // Lap data for all cars on track
   };
*/


   private Header header;
   private List<LapData> lapData;

}
