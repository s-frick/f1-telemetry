package de.sfrick.udp.f1.data;

public enum ResultStatus {



   INVALID(0),
   INACTIVE(1),
   ACTIVE(2),
   FINISHED(3),
   DID_NOT_FINISH(4),
   DISQUALIFIED(5),
   NOT_CLASSIFIED(6),
   RETIRED(7);

   public final int value;

   private ResultStatus(int value) {
      this.value = value;
   }


   public static ResultStatus valueOfInt(int value) {
      for (ResultStatus w : values()) {
         if (w.value == value) {
            return w;
         }
      }
      return null;
   }
}
