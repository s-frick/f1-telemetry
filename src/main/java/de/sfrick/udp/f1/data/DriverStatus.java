package de.sfrick.udp.f1.data;

public enum DriverStatus {


   IN_GARAGE(0),
   FLYING_LAP(1),
   IN_LAP(2),
   OUT_LAP(3),
   ON_TRACK(4);

   public final int value;

   private DriverStatus(int value) {
      this.value = value;
   }


   public static DriverStatus valueOfInt(int value) {
      for (DriverStatus w : values()) {
         if (w.value == value) {
            return w;
         }
      }
      return null;
   }
}
