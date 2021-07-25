package de.sfrick.udp.f1.packets;

import de.sfrick.udp.f1.data.LapData;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PacketLapData implements Packet {

   private Header header;
   private List<LapData> lapData;

}
