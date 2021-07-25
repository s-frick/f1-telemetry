package de.sfrick.udp.f1.data;

public enum ZoneFlag {
   // -1 = invalid/unknown, 0 = none, 1 = green, 2 = blue, 3 = yellow, 4 = red
   INVALID(-1),
   NONE(0),
   GREEN(1),
   BLUE(2),
   YELLOW(3),
   RED(4);

   public final int value;

   private ZoneFlag(int value) {
      this.value = value;
   }


   public static ZoneFlag valueOfInt(int value) {
      for (ZoneFlag z : values()) {
         if (z.value == value) {
            return z;
         }
      }
      return INVALID;
   }
}
