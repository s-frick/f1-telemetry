package de.sfrick.udp.f1.data;

public enum SafetyCarStatus {


   NO_SAFETY_CAR(0),
   SAFETY_CAR(1),
   VIRTUAL_SAFETY_CAR(2),
   FORMATION_LAP(3);

   public final int value;

   private SafetyCarStatus(int value) {
      this.value = value;
   }


   public static SafetyCarStatus valueOfInt(int value) {
      for (SafetyCarStatus w : values()) {
         if (w.value == value) {
            return w;
         }
      }
      return null;
   }
}
