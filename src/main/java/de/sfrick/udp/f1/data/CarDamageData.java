package de.sfrick.udp.f1.data;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CarDamageData {

   private List<Float> tyresWear;
   private List<Integer> tyresDamage;
   private List<Integer> brakesDamage;
   private int frontLeftWingDamage;
   private int frontRightWingDamage;
   private int rearWingDamage;
   private int floorDamage;
   private int diffuserDamage;
   private int sidepodDamage;
   private int drsFault;
   private int gearBoxDamage;
   private int engineDamage;
   private int engineMguhWear;
   private int engineEsWear;
   private int engineCeWear;
   private int engineIceWear;
   private int engineMgukWear;
   private int engineTcWear;

}
