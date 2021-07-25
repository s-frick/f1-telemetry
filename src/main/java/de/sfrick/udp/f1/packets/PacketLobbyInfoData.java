package de.sfrick.udp.f1.packets;

import de.sfrick.udp.f1.data.LobbyInfoData;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PacketLobbyInfoData implements Packet {

   private Header header;
   private int numPlayers;
   private List<LobbyInfoData> lobbyPlayers;

}
