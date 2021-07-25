package de.sfrick.udp.f1.packets;


import de.sfrick.udp.f1.data.FinalClassificationData;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PacketFinalClassificationData implements Packet {

   private Header header;
   private int numCars;
   private List<FinalClassificationData> classificationData;

}
