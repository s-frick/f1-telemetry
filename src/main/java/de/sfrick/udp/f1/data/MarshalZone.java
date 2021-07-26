package de.sfrick.udp.f1.data;

import de.sfrick.udp.f1.packets.Packet;
import de.sfrick.udp.f1.packets.Header;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class
MarshalZone {

   private float zoneStart; // Fraction (0..1) of way through the lap the marshal zone starts
   private ZoneFlag zoneFlag; // -1 = invalid/unknown, 0 = none, 1 = green, 2 = blue, 3 = yellow, 4 = red
}
