package de.sfrick.udp.f1.packets;


import de.sfrick.udp.f1.data.CarStatusData;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PacketCarStatusData implements Packet {

   private Header header;
   private List<CarStatusData> carStatusData;

}
