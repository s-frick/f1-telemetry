package de.sfrick.udp;

import de.sfrick.udp.f1.packets.Packet;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message {

   private Packet data;

}
