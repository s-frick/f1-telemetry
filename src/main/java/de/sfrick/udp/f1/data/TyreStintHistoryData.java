package de.sfrick.udp.f1.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TyreStintHistoryData {

//   TODO
/*
   struct TyreStintHistoryData
   {
      uint8     m_endLap;                // Lap the tyre usage ends on (255 of current tyre)
      uint8     m_tyreActualCompound;    // Actual tyres used by this driver
      uint8     m_tyreVisualCompound;    // Visual tyres used by this driver
   };
*/

   private int endLap;
   private int tyreActualCompound;
   private int tyreVisualCompound;

}
