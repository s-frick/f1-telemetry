package de.sfrick.udp.f1.data;

public enum SessionType {
//   0 = unknown, 1 = P1, 2 = P2, 3 = P3, 4 = Short P, 5 = Q1
//        # 6 = Q2, 7 = Q3, 8 = Short Q, 9 = OSQ, 10 = R, 11 = R2
   UNKNOWN(0),
   P1(1),
   P2(2),
   P3(3),
   ShortP(4),
   Q1(5),
   Q2(6),
   Q3(7),
   ShortQ(8),
   OSQ(9),
   R(10),
   R2(11);





   public final int value;

   private SessionType(int value) {
      this.value = value;
   }


   public static SessionType valueOfInt(int value) {
      for (SessionType s : values()) {
         if (s.value == value) {
            return s;
         }
      }
      return UNKNOWN;
   }
}
