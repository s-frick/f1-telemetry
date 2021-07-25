package de.sfrick.udp.f1.packets;


import de.sfrick.udp.f1.data.CarMotionData;
import de.sfrick.udp.f1.data.WheelData;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PacketMotionData implements Packet {

   private Header header;

   private List<CarMotionData> carMotionDataList;
   private WheelData<Float> suspensionPosition;
   private WheelData<Float> suspensionVelocity;
   private WheelData<Float> suspensionAcceleration;
   private WheelData<Float> wheelSpeed;
   private WheelData<Float> wheelSlip;

   private float localVelocityX;
   private float localVelocityY;
   private float localVelocityZ;
   private float angularVelocityX;
   private float angularVelocityY;
   private float angularVelocityZ;
   private float angularAccelerationX;
   private float angularAccelerationY;
   private float angularAccelerationZ;
   private float frontWheelsAngle;

}
