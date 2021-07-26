package de.sfrick.udp.f1.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EventDetails {

/*
   Event	            Code	Description
   Session Started	    “SSTA”	Sent when the session starts
   Session Ended	    “SEND”	Sent when the session ends
   Fastest Lap	        “FTLP”	When a driver achieves the fastest lap
   Retirement	        “RTMT”	When a driver retires
   DRS enabled	        “DRSE”	Race control have enabled DRS
   DRS disabled	        “DRSD”	Race control have disabled DRS
   Team mate in pits    “TMPT”	Your team mate has entered the pits
   Chequered flag	    “CHQF”	The chequered flag has been waved
   Race Winner	        “RCWN”	The race winner is announced
   Penalty Issued	    “PENA”	A penalty has been issued – details in event
   Speed Trap Triggered	“SPTP”	Speed trap has been triggered by fastest speed
   Start lights	        “STLG”	Start lights – number shown
   Lights out	        “LGOT”	Lights out
   Drive through served	“DTSV”	Drive through penalty served
   Stop go served	    “SGSV”	Stop go penalty served
   Flashback	        “FLBK”	Flashback activated
   Button status	    “BUTN”	Button status changed
*/


//   TODO
/*
   // The event details packet is different for each type of event.
   // Make sure only the correct type is interpreted.
   union EventDataDetails
   {
      struct
      {
         uint8	vehicleIdx; // Vehicle index of car achieving fastest lap
         float	lapTime;    // Lap time is in seconds
      } FastestLap;

      struct
      {
         uint8   vehicleIdx; // Vehicle index of car retiring
      } Retirement;

      struct
      {
         uint8   vehicleIdx; // Vehicle index of team mate
      } TeamMateInPits;

      struct
      {
         uint8   vehicleIdx; // Vehicle index of the race winner
      } RaceWinner;

      struct
      {
         uint8 penaltyType;		// Penalty type – see Appendices
         uint8 infringementType;		// Infringement type – see Appendices
         uint8 vehicleIdx;         	// Vehicle index of the car the penalty is applied to
         uint8 otherVehicleIdx;    	// Vehicle index of the other car involved
         uint8 time;               	// Time gained, or time spent doing action in seconds
         uint8 lapNum;             	// Lap the penalty occurred on
         uint8 placesGained;       	// Number of places gained by this
      } Penalty;

      struct
      {
         uint8 vehicleIdx;		// Vehicle index of the vehicle triggering speed trap
         float speed;      		// Top speed achieved in kilometres per hour
         uint8 overallFastestInSession;   // Overall fastest speed in session = 1, otherwise 0
         uint8 driverFastestInSession;    // Fastest speed for driver in session = 1, otherwise 0
      } SpeedTrap;

      struct
      {
         uint8 numLights;		// Number of lights showing
      } StartLIghts;

      struct
      {
         uint8 vehicleIdx;                 // Vehicle index of the vehicle serving drive through
      } DriveThroughPenaltyServed;

      struct
      {
         uint8 vehicleIdx;                 // Vehicle index of the vehicle serving stop go
      } StopGoPenaltyServed;

      struct
      {
         uint32 flashbackFrameIdentifier;  // Frame identifier flashed back to
         float flashbackSessionTime;       // Session time flashed back to
      } Flashback;

      struct
      {
         uint32         m_buttonStatus;    // Bit flags specifying which buttons are being pressed
         // currently - see appendices
      } Buttons;
   };

*/



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
