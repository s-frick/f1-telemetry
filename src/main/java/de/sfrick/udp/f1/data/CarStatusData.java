package de.sfrick.udp.f1.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarStatusData {

   private int tractionControl;
   private int antiLockBrakes;
   private int fuelMix;
   private int frontBrakeBias;
   private int pitLimiterStatus;
   private float fuelInTank;
   private float fuelCapacity;
   private float fuelRemainingLaps;
   private long maxRPM;
   private long idleRPM;
   private int maxGears;
   private int drsAllowed;
   private int drsActivationDistance;
   private int actualTyreCompound;
   private int visualTyreCompound;
   private int tyresAgeLaps;
   private int vehicleFiaFlags;
   private float ersStoreEnergy;
   private int ersdeployMode;
   private float ersHarvestedThisLapMguk;
   private float ersHarvestedThisLapMguh;
   private float ersDeployedThisLap;
   private int networkPaused;

}
