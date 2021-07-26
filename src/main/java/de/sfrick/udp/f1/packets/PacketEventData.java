package de.sfrick.udp.f1.packets;

import de.sfrick.udp.f1.data.EventDetails;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PacketEventData implements Packet {

// TODO
/*   struct PacketEventData
   {
      PacketHeader    	m_header;               	// Header

      uint8           	m_eventStringCode[4];   	// Event string code, see below
      EventDataDetails	m_eventDetails;         	// Event details - should be interpreted differently
      // for each type
   };*/


   private Header header;

   private List<Integer> eventStringCode;
   private EventDetails eventDetails;
}
