package de.sfrick.udp.f1.data;

public enum PenaltyType {
   INVALID(0),
   INACTIVE(1),
   ACTIVE(2),
   FINISHED(3),
   DID_NOT_FINISH(4),
   DISQUALIFIED(5),
   NOT_CLASSIFIED(6),
   RETIRED(7);

   public final int value;

   private PenaltyType(int value) {
      this.value = value;
   }


   public static PenaltyType valueOfInt(int value) {
      for (PenaltyType w : values()) {
         if (w.value == value) {
            return w;
         }
      }
      return null;
   }
}
