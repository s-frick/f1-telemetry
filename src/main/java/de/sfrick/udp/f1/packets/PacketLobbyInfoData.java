package de.sfrick.udp.f1.packets;

import de.sfrick.udp.f1.data.LobbyInfoData;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PacketLobbyInfoData implements Packet {

//   TODO
/*
   struct PacketLobbyInfoData
   {
      PacketHeader    m_header;                       // Header

      // Packet specific data
      uint8               m_numPlayers;               // Number of players in the lobby data
      LobbyInfoData       m_lobbyPlayers[22];
   };
*/

   private Header header;
   private int numPlayers;
   private List<LobbyInfoData> lobbyPlayers;

}
