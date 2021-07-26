package de.sfrick.udp.f1.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LapData {

   private long lastLapTimeMs;
   private long currentLapTimeMs;
   private long sector1TimeMs;
   private long sector2TimeMs;
   private float lapDistance;
   private float totalDistance;
   private float safetyCarDelta;
   private int carPosition;
   private int currentLapNumber;
   private PitStatus pitStatus;
   private int numPitStopsTaken;
   private int sector;
   private int currentLapInvalid;
   private int penalties;
   private int warnings;
   private int numUnservedDriveThroughPenalties;
   private int numUnservedStopAndGoPenalties;
   private int gridPosition;
   private DriverStatus driverStatus;
   private ResultStatus resultStatus;
   private int pitLaneTimerActive;
   private long pitLaneTimeInLaneMs;
   private long pitStopTimerMs;
   private int pitStopShouldServePenalty;

}
