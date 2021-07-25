package de.sfrick.udp.f1.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FastestLap {

   private int vehicleIdx;
   private float lapTime;

}
