package de.sfrick.udp.f1.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarSetupData {

   private int frontWing;
   private int rearWing;
   private int onThrottle;
   private int offThrottle;
   private float frontCamber;
   private float rearCamber;
   private float frontToe;
   private float rearToe;
   private int frontSuspension;
   private int rearSuspension;
   private int frontAntiRollBar;
   private int rearAntiRollBar;
   private int frontSuspensionHeight;
   private int rearSuspensionHeight;
   private int brakePressure;
   private int brakeBias;
   private float rearLeftTyrePressure;
   private float rearRightTyrePressure;
   private float frontLeftTyrePressure;
   private float frontRightTyrePressure;
   private int ballast;
   private float fuelLoad;

}
