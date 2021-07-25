package de.sfrick.udp.f1.data;

public enum PitStatus {

   NONE(0),
   PITTING(1),
   IN_PIT_AREA(2);

   public final int value;

   private PitStatus(int value) {
      this.value = value;
   }


   public static PitStatus valueOfInt(int value) {
      for (PitStatus w : values()) {
         if (w.value == value) {
            return w;
         }
      }
      return null;
   }
}
