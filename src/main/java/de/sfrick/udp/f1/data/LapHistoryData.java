package de.sfrick.udp.f1.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LapHistoryData {

//   TODO
/*
   struct LapHistoryData
   {
      uint32    m_lapTimeInMS;           // Lap time in milliseconds
      uint16    m_sector1TimeInMS;       // Sector 1 time in milliseconds
      uint16    m_sector2TimeInMS;       // Sector 2 time in milliseconds
      uint16    m_sector3TimeInMS;       // Sector 3 time in milliseconds
      uint8     m_lapValidBitFlags;      // 0x01 bit set-lap valid,      0x02 bit set-sector 1 valid
      // 0x04 bit set-sector 2 valid, 0x08 bit set-sector 3 valid
   };
*/

   private long lapTimeInMs;
   private long sector1TimeInMs;
   private long sector2TimeInMs;
   private long sector3TimeInMs;
   private int lapValidBitFlags;

}
