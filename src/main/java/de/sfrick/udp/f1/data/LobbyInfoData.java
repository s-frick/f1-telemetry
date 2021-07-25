package de.sfrick.udp.f1.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LobbyInfoData {

   private int aiControlled;
   private int teamID;
   private int nationality;
   private String name;
   private int carNumber;
   private int readyStatus;

}
