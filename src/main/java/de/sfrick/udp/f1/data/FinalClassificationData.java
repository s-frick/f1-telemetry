package de.sfrick.udp.f1.data;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FinalClassificationData {

//   TODO
/*
   struct FinalClassificationData
   {
      uint8     m_position;              // Finishing position
      uint8     m_numLaps;               // Number of laps completed
      uint8     m_gridPosition;          // Grid position of the car
      uint8     m_points;                // Number of points scored
      uint8     m_numPitStops;           // Number of pit stops made
      uint8     m_resultStatus;          // Result status - 0 = invalid, 1 = inactive, 2 = active
      // 3 = finished, 4 = didnotfinish, 5 = disqualified
      // 6 = not classified, 7 = retired
      uint32    m_bestLapTimeInMS;       // Best lap time of the session in milliseconds
      double    m_totalRaceTime;         // Total race time in seconds without penalties
      uint8     m_penaltiesTime;         // Total penalties accumulated in seconds
      uint8     m_numPenalties;          // Number of penalties applied to this driver
      uint8     m_numTyreStints;         // Number of tyres stints up to maximum
      uint8     m_tyreStintsActual[8];   // Actual tyres used by this driver
      uint8     m_tyreStintsVisual[8];   // Visual tyres used by this driver
   };
*/

   private int position;
   private int numLaps;
   private int gridPosition;
   private int points;
   private int numPitStops;
   private int resultStatus;
   private long bestLaptTimeInMs;
   private double totalRaceTime;
   private int penaltiesTime;
   private int numPenalties;
   private int numTyreStints;
   private List<Integer> tyreStintsActual;
   private List<Integer> tyreStintsVisual;

}
