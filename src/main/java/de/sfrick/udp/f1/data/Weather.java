package de.sfrick.udp.f1.data;

public enum Weather {

   CLEAR(0),
   LIGHT_CLOUD(1),
   OVERCAST(2),
   LIGHT_RAIN(3),
   HEAVY_RAIN(4),
   STORM(5);





   public final int value;

   private Weather(int value) {
      this.value = value;
   }


   public static Weather valueOfInt(int value) {
      for (Weather w : values()) {
         if (w.value == value) {
            return w;
         }
      }
      return null;
   }
}
