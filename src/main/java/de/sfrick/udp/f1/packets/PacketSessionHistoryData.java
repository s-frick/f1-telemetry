package de.sfrick.udp.f1.packets;

import de.sfrick.udp.f1.data.LapHistoryData;
import de.sfrick.udp.f1.data.TyreStintHistoryData;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PacketSessionHistoryData implements Packet {

//   TODO
/*
   struct PacketSessionHistoryData
   {
      PacketHeader  m_header;                   // Header

      uint8         m_carIdx;                   // Index of the car this lap data relates to
      uint8         m_numLaps;                  // Num laps in the data (including current partial lap)
      uint8         m_numTyreStints;            // Number of tyre stints in the data

      uint8         m_bestLapTimeLapNum;        // Lap the best lap time was achieved on
      uint8         m_bestSector1LapNum;        // Lap the best Sector 1 time was achieved on
      uint8         m_bestSector2LapNum;        // Lap the best Sector 2 time was achieved on
      uint8         m_bestSector3LapNum;        // Lap the best Sector 3 time was achieved on

      LapHistoryData          m_lapHistoryData[100];	// 100 laps of data max
      TyreStintHistoryData    m_tyreStintsHistoryData[8];
   };
*/


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
