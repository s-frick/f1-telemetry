package de.sfrick.udp.f1.packets;

import de.sfrick.udp.f1.data.EventDetails;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PacketEventData implements Packet {

   private Header header;

   private List<Integer> eventStringCode;
   private EventDetails eventDetails;
}
