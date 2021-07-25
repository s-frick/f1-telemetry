package de.sfrick.udp.f1.packets;


import de.sfrick.udp.f1.data.ParticipantData;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PacketParticipantsData implements Packet {

   private Header header;
   private int numActiveCars;
   private List<ParticipantData> participantsData;
}
