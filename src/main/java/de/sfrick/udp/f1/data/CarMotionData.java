package de.sfrick.udp.f1.data;

import de.sfrick.udp.f1.packets.Packet;
import de.sfrick.udp.f1.packets.Header;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarMotionData implements Packet {

   private Header header;

   private int carIndex;
   private boolean playersCar;


   private float worldPositionX;
   private float worldPositionY;
   private float worldPositionZ;
   private float worldVelocityX;
   private float worldVelocityY;
   private float worldVelocityZ;

   private int worldForwardDirX;
   private int worldForwardDirY;
   private int worldForwardDirZ;
   private int worldRightDirX;
   private int worldRightDirY;
   private int worldRightDirZ;
   private float gForceLateral;
   private float gForceLongitudinal;
   private float gForceVertical;
   private float yaw;
   private float pitch;
   private float roll;
}
