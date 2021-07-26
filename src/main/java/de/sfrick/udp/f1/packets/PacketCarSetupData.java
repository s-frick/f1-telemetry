package de.sfrick.udp.f1.packets;

import de.sfrick.udp.f1.data.CarSetupData;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PacketCarSetupData implements Packet {

//   TODO
/*
   struct PacketCarSetupData
   {
      PacketHeader    m_header;            // Header

      CarSetupData    m_carSetups[22];
   };
*/

   private Header header;
   private List<CarSetupData> carSetups;

}
