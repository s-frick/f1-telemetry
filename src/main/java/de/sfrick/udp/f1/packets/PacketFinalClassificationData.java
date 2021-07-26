package de.sfrick.udp.f1.packets;


import de.sfrick.udp.f1.data.FinalClassificationData;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PacketFinalClassificationData implements Packet {

//   TODO
/*
   struct PacketFinalClassificationData
   {
      PacketHeader    m_header;                      // Header

      uint8                      m_numCars;          // Number of cars in the final classification
      FinalClassificationData    m_classificationData[22];
   };
*/

   private Header header;
   private int numCars;
   private List<FinalClassificationData> classificationData;

}
