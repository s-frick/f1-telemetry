package de.sfrick.udp.f1.packets;

import de.sfrick.udp.f1.data.CarTelemetryData;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PacketCarTelemetryData implements Packet {

   private Header header;
   private List<CarTelemetryData> carTelemetryData;
   private int mfdPanelIdx;
   private int mfdPanelIdxSecondaryPlayer;
   private int suggestedGear;

}
