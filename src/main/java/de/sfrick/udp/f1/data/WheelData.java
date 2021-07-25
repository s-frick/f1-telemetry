package de.sfrick.udp.f1.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WheelData<T> {

   private T rearLeft;
   private T rearRight;
   private T frontLeft;
   private T frontRight;
}
