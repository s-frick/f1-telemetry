package de.sfrick.udp.f1.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LapHistoryData {

   private long lapTimeInMs;
   private long sector1TimeInMs;
   private long sector2TimeInMs;
   private long sector3TimeInMs;
   private int lapValidBitFlags;

}
