package de.sfrick.udp.f1.packets;

import de.sfrick.udp.f1.data.CarDamageData;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PacketCarDamageData implements Packet {

//   TODO
/*
   struct PacketCarDamageData
   {
      PacketHeader    m_header;               // Header

      CarDamageData   m_carDamageData[22];
   };
*/

   private Header header;
   private List<CarDamageData> carDamageData;

}
