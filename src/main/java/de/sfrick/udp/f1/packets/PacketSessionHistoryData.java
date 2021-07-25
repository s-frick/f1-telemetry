package de.sfrick.udp.f1.packets;

import de.sfrick.udp.f1.data.LapHistoryData;
import de.sfrick.udp.f1.data.TyreStintHistoryData;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PacketSessionHistoryData implements Packet {

   private Header header;
   private int carIdx;
   private int numLaps;
   private int numTyreStints;
   private int bestLapTimeLapNum;
   private int bestSector1LapNum;
   private int bestSector2LapNum;
   private int bestSector3LapNum;
   private List<LapHistoryData> lapHistoryData;
   private List<TyreStintHistoryData> tyreStintsHistoryData;

}
