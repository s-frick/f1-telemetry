package de.sfrick.udp.f1.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Penalty {

   private int penaltyType;
   private int infringementType;
   private int vehicleIdx;
   private int otherVehicleIdx;
   private int time;
   private int lapNum;
   private int placesGained;

}
