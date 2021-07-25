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
