package de.sfrick.udp.f1.packets;

import de.sfrick.udp.f1.data.MarshalZone;
import de.sfrick.udp.f1.data.SafetyCarStatus;
import de.sfrick.udp.f1.data.SessionType;
import de.sfrick.udp.f1.data.Weather;
import de.sfrick.udp.f1.data.WeatherForecastSample;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PacketSessionData implements Packet {

//   TODO
/*
   struct PacketSessionData
   {
      PacketHeader    m_header;               	// Header

      uint8           m_weather;              	// Weather - 0 = clear, 1 = light cloud, 2 = overcast
      // 3 = light rain, 4 = heavy rain, 5 = storm
      int8	            m_trackTemperature;    	// Track temp. in degrees celsius
      int8	            m_airTemperature;      	// Air temp. in degrees celsius
      uint8           m_totalLaps;           	// Total number of laps in this race
      uint16          m_trackLength;           	// Track length in metres
      uint8           m_sessionType;         	// 0 = unknown, 1 = P1, 2 = P2, 3 = P3, 4 = Short P
      // 5 = Q1, 6 = Q2, 7 = Q3, 8 = Short Q, 9 = OSQ
      // 10 = R, 11 = R2, 12 = R3, 13 = Time Trial
      int8            m_trackId;         		// -1 for unknown, 0-21 for tracks, see appendix
      uint8           m_formula;                  	// Formula, 0 = F1 Modern, 1 = F1 Classic, 2 = F2,
      // 3 = F1 Generic
      uint16          m_sessionTimeLeft;    	// Time left in session in seconds
      uint16          m_sessionDuration;     	// Session duration in seconds
      uint8           m_pitSpeedLimit;      	// Pit speed limit in kilometres per hour
      uint8           m_gamePaused;                // Whether the game is paused
      uint8           m_isSpectating;        	// Whether the player is spectating
      uint8           m_spectatorCarIndex;  	// Index of the car being spectated
      uint8           m_sliProNativeSupport;	// SLI Pro support, 0 = inactive, 1 = active
      uint8           m_numMarshalZones;         	// Number of marshal zones to follow
      MarshalZone     m_marshalZones[21];         	// List of marshal zones – max 21
      uint8           m_safetyCarStatus;           // 0 = no safety car, 1 = full
      // 2 = virtual, 3 = formation lap
      uint8           m_networkGame;               // 0 = offline, 1 = online
      uint8           m_numWeatherForecastSamples; // Number of weather samples to follow
      WeatherForecastSample m_weatherForecastSamples[56];   // Array of weather forecast samples
      uint8           m_forecastAccuracy;          // 0 = Perfect, 1 = Approximate
      uint8           m_aiDifficulty;              // AI Difficulty rating – 0-110
      uint32          m_seasonLinkIdentifier;      // Identifier for season - persists across saves
      uint32          m_weekendLinkIdentifier;     // Identifier for weekend - persists across saves
      uint32          m_sessionLinkIdentifier;     // Identifier for session - persists across saves
      uint8           m_pitStopWindowIdealLap;     // Ideal lap to pit on for current strategy (player)
      uint8           m_pitStopWindowLatestLap;    // Latest lap to pit on for current strategy (player)
      uint8           m_pitStopRejoinPosition;     // Predicted position to rejoin at (player)
      uint8           m_steeringAssist;            // 0 = off, 1 = on
      uint8           m_brakingAssist;             // 0 = off, 1 = low, 2 = medium, 3 = high
      uint8           m_gearboxAssist;             // 1 = manual, 2 = manual & suggested gear, 3 = auto
      uint8           m_pitAssist;                 // 0 = off, 1 = on
      uint8           m_pitReleaseAssist;          // 0 = off, 1 = on
      uint8           m_ERSAssist;                 // 0 = off, 1 = on
      uint8           m_DRSAssist;                 // 0 = off, 1 = on
      uint8           m_dynamicRacingLine;         // 0 = off, 1 = corners only, 2 = full
      uint8           m_dynamicRacingLineType;     // 0 = 2D, 1 = 3D
   };
*/



   private Header header;

   private Weather weather;
   private int trackTemperature;
   private int airTemperature;
   private int totalLaps;
   private int trackLength;
   private SessionType sessionType;
   private int trackId; //todo: map the tracks
   private int formula; // 0 = f1 modern, 1 = f1 classic, 2 = f2, 3 = f1 generic
   private int sessionTimeLeft;
   private int sessionDuration;
   private int pitSpeedLimit;
   private int gamePaused;
   private int isSpectating;
   private int spectatorCarIndex;
   private int sliProNativeSupport;
   private int numMarshalZones;
   private List<MarshalZone> marshalZones;
   private SafetyCarStatus safetyCarStatus;
   private int networkGame;
   private int numWeatherForecastSamples;
   private List<WeatherForecastSample> weatherForecastSamples;
   private int forecastAccuracy;
   private int aiDifficulty;
   private long seasonLinkIdentifier;
   private long weekendLinkIdentifier;
   private long sessionLinkIdentifier;
   private int pitStopWindowIdealLap;
   private int pitStopWindowLatestLap;
   private int pitStopRejoinPosition;
   private int steeringAssist;
   private int brakingAssist;
   private int gearboxAssist;
   private int pitAssist;
   private int pitReleaseAssist;
   private int ersAssist;
   private int drsAssist;
   private int dynamicRacingLine;
   private int dynamicRacingLineType;

}
