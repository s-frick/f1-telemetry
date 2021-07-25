package de.sfrick.udp.f1.packets;

public enum PacketType {

   MOTION(0),
   SESSION(1),
   LAP(2),
   EVENT(3),
   PARTICIPANTS(4),
   CAR_SETUP(5),
   CAR_TELEMETRY(6),
   CAR_STATUS(7);


   public final int value;

   private PacketType(int value) {
      this.value = value;
   }


   public static PacketType valueOfInt(int value) {
      for (PacketType w : values()) {
         if (w.value == value) {
            return w;
         }
      }
      return null;
   }
}
