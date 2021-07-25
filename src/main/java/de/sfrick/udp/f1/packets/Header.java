package de.sfrick.udp.f1.packets;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
//@NoArgsConstructor
@Builder
public class Header {


   private int packetFormat;
   private int gameMajorVersion;
   private int gameMinorVersion;
   private int packetVersion;
   private int packetId;
   private BigInteger sessionUID;
   private float sessionTime;
   private long frameIdentifier;
   private int playerCarIndex;
   private int secondaryPlayerCarIndex; // 255 if no second player
}
