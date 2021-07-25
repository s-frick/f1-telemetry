package de.sfrick.udp.f1.data;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DriveThroughPenaltyServed {
   private int vehicleIdx;
}
