package de.sfrick.udp.f1.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EventDetails {

   private FastestLap fastestLap;
   private Retirement retirement;
   private TeamMateInPits teamMateInPits;
   private RaceWinner raceWinner;
   private Penalty penalty;
   private SpeedTrap speedTrap;
   private StartLights startLights;
   private DriveThroughPenaltyServed driveThroughPenaltyServed;
   private StopGoPenaltyServed stopGoPenaltyServed;
   private Flashback flashback;
   private Buttons buttons;

}
