package de.sfrick.udp.f1.data;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FinalClassificationData {

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
