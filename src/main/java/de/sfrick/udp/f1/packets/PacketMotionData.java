package de.sfrick.udp.f1.packets;


import de.sfrick.udp.f1.data.CarMotionData;
import de.sfrick.udp.f1.data.WheelData;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PacketMotionData implements Packet {

   //   TODO
   /*
   * struct PacketMotionData
      {
          PacketHeader    m_header;               	// Header

          CarMotionData   m_carMotionData[22];    	// Data for all cars on track

          // Extra player car ONLY data
          float         m_suspensionPosition[4];       // Note: All wheel arrays have the following order:
          float         m_suspensionVelocity[4];       // RL, RR, FL, FR
          float         m_suspensionAcceleration[4];	// RL, RR, FL, FR
          float         m_wheelSpeed[4];           	// Speed of each wheel
          float         m_wheelSlip[4];                // Slip ratio for each wheel
          float         m_localVelocityX;         	// Velocity in local space
          float         m_localVelocityY;         	// Velocity in local space
          float         m_localVelocityZ;         	// Velocity in local space
          float         m_angularVelocityX;		// Angular velocity x-component
          float         m_angularVelocityY;            // Angular velocity y-component
          float         m_angularVelocityZ;            // Angular velocity z-component
          float         m_angularAccelerationX;        // Angular velocity x-component
          float         m_angularAccelerationY;	// Angular velocity y-component
          float         m_angularAccelerationZ;        // Angular velocity z-component
          float         m_frontWheelsAngle;            // Current front wheels angle in radians
      };
   * */


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
