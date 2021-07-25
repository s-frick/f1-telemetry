package de.sfrick.udp.f1.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParticipantData {

   private int aiControlled;
   private int driverId;
   private int networkId;
   private int teamId;
   private int myTeam;
   private int raceNumber;
   private int nationality;
   private String name;
   private int yourTelemetry;

}
