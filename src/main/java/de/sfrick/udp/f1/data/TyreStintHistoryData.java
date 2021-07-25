package de.sfrick.udp.f1.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TyreStintHistoryData {

   private int endLap;
   private int tyreActualCompound;
   private int tyreVisualCompound;

}
