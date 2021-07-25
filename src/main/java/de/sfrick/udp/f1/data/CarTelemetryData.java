package de.sfrick.udp.f1.data;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CarTelemetryData {

   private long speed;
   private float throttle;
   private float steer;
   private float brake;
   private int clutch;
   private int gear;
   private long engineRPM;
   private int drs;
   private int revLightsPercent;
   private long revLightsBitValue;
   private List<Integer> brakesTemperature;
   private List<Integer> tyresSurfaceTemperature;
   private List<Integer> tyresInnerTemperature;
   private int engineTemperature;
   private List<Float> tyrePressure;
   private List<Integer> surfaceType;

}
