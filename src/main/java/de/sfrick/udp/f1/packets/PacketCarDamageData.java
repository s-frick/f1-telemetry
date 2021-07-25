package de.sfrick.udp.f1.packets;

import de.sfrick.udp.f1.data.CarDamageData;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PacketCarDamageData implements Packet {

   private Header header;
   private List<CarDamageData> carDamageData;

}
