package de.sfrick.udp.f1.packets;


import de.sfrick.udp.f1.data.CarStatusData;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PacketCarStatusData implements Packet {

//   TODO
/*
   struct PacketCarStatusData
   {
      PacketHeader    	m_header;	   // Header

      CarStatusData	m_carStatusData[22];
   };
*/

   private Header header;
   private List<CarStatusData> carStatusData;

}
