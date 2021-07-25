package de.sfrick.udp.f1;

import de.sfrick.udp.f1.data.Buttons;
import de.sfrick.udp.f1.data.CarMotionData;
import de.sfrick.udp.f1.data.CarSetupData;
import de.sfrick.udp.f1.data.CarStatusData;
import de.sfrick.udp.f1.data.CarTelemetryData;
import de.sfrick.udp.f1.data.DriveThroughPenaltyServed;
import de.sfrick.udp.f1.data.DriverStatus;
import de.sfrick.udp.f1.data.EventDetails;
import de.sfrick.udp.f1.data.FastestLap;
import de.sfrick.udp.f1.data.Flashback;
import de.sfrick.udp.f1.data.LapData;
import de.sfrick.udp.f1.data.MarshalZone;
import de.sfrick.udp.f1.data.ParticipantData;
import de.sfrick.udp.f1.data.Penalty;
import de.sfrick.udp.f1.data.PitStatus;
import de.sfrick.udp.f1.data.RaceWinner;
import de.sfrick.udp.f1.data.ResultStatus;
import de.sfrick.udp.f1.data.Retirement;
import de.sfrick.udp.f1.data.SafetyCarStatus;
import de.sfrick.udp.f1.data.SessionType;
import de.sfrick.udp.f1.data.SpeedTrap;
import de.sfrick.udp.f1.data.StartLights;
import de.sfrick.udp.f1.data.StopGoPenaltyServed;
import de.sfrick.udp.f1.data.TeamMateInPits;
import de.sfrick.udp.f1.data.Weather;
import de.sfrick.udp.f1.data.WeatherForecastSample;
import de.sfrick.udp.f1.data.WheelData;
import de.sfrick.udp.f1.data.ZoneFlag;
import de.sfrick.udp.f1.packets.Header;
import de.sfrick.udp.f1.packets.Packet;
import de.sfrick.udp.f1.packets.PacketCarSetupData;
import de.sfrick.udp.f1.packets.PacketCarStatusData;
import de.sfrick.udp.f1.packets.PacketCarTelemetryData;
import de.sfrick.udp.f1.packets.PacketEventData;
import de.sfrick.udp.f1.packets.PacketLapData;
import de.sfrick.udp.f1.packets.PacketMotionData;
import de.sfrick.udp.f1.packets.PacketParticipantsData;
import de.sfrick.udp.f1.packets.PacketSessionData;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PacketDeserializer {

   public static final int TOTAL_NBR_CARS = 20;
   public static final int MAX_NBR_MARSHAL_ZONES = 21;


   private PacketBuffer buffer;

   private PacketDeserializer(byte[] data) {
      buffer = PacketBuffer.wrap(data);
   }

   public static Packet read(byte[] data) {
      return new PacketDeserializer(data).buildPacket();
   }

   private Packet buildPacket() {
//      TODO: update packets for 2021

      Header header = buildHeader();

      switch (header.getPacketId()) {
         case 0:
            return buildPacketMotionData(header);
         case 1:
            return buildPacketSessionData(header);
         case 2:
            return buildPacketLapData(header);
         case 3:
            return buildPacketEventData(header);
         case 4:
            return buildPacketParticipantsData(header);
         case 5:
            return buildPacketCarSetupData(header);
         case 6:
            return buildPacketCarTelemetryData(header);
         case 7:
            return buildPacketCarStatusData(header);
      }

      return null;
   }

   private Header buildHeader() {
      return Header.builder()
            .packetFormat(buffer.getNextUInt16AsInt())
            .gameMajorVersion(buffer.getNextUInt8AsInt())
            .gameMinorVersion(buffer.getNextUInt8AsInt())
            .packetVersion(buffer.getNextUInt8AsInt())
            .packetId(buffer.getNextUInt8AsInt())
            .sessionUID(buffer.getNextUInt64AsBigInteger())
            .sessionTime(buffer.getNextFloat())
            .frameIdentifier(buffer.getNextUIntAsLong())
            .playerCarIndex(buffer.getNextUInt8AsInt())
            .secondaryPlayerCarIndex(buffer.getNextUInt8AsInt())
            .build();
   }

   private Packet buildPacketCarStatusData(Header header) {
      return PacketCarStatusData.builder()
            .header(header)
            .carStatusData(
                  IntStream.of(22)
                        .mapToObj((i) -> buildCarStatusData())
                        .collect(Collectors.toList())
            )
            .build();
   }

   private CarStatusData buildCarStatusData() {
      return CarStatusData.builder()
            .tractionControl(buffer.getNextUInt8AsInt())
            .antiLockBrakes(buffer.getNextUInt8AsInt())
            .fuelMix(buffer.getNextUInt8AsInt())
            .frontBrakeBias(buffer.getNextUInt8AsInt())
            .pitLimiterStatus(buffer.getNextUInt8AsInt())
            .fuelInTank(buffer.getNextFloat())
            .fuelCapacity(buffer.getNextFloat())
            .fuelRemainingLaps(buffer.getNextFloat())
            .maxRPM(buffer.getNextUInt16AsInt())
            .idleRPM(buffer.getNextUInt16AsInt())
            .maxGears(buffer.getNextUInt8AsInt())
            .drsAllowed(buffer.getNextUInt8AsInt())
            .drsActivationDistance(buffer.getNextUInt16AsInt())
            .actualTyreCompound(buffer.getNextUInt8AsInt())
            .visualTyreCompound(buffer.getNextUInt8AsInt())
            .tyresAgeLaps(buffer.getNextUInt8AsInt())
            .vehicleFiaFlags(buffer.getNextUInt8AsInt())
            .ersStoreEnergy(buffer.getNextFloat())
            .ersdeployMode(buffer.getNextUInt8AsInt())
            .ersHarvestedThisLapMguk(buffer.getNextFloat())
            .ersHarvestedThisLapMguh(buffer.getNextFloat())
            .ersDeployedThisLap(buffer.getNextFloat())
            .networkPaused(buffer.getNextUInt8AsInt())
            .build();
   }

   private Packet buildPacketCarTelemetryData(Header header) {
      return PacketCarTelemetryData.builder()
            .header(header)
            .carTelemetryData(
                  IntStream.of(22)
                        .mapToObj(i -> buildCarTelemetryData())
                        .collect(Collectors.toList())
            )
            .build();
   }

   private CarTelemetryData buildCarTelemetryData() {
      return CarTelemetryData.builder()
            .speed(buffer.getNextUInt16AsInt())
            .throttle(buffer.getNextFloat())
            .steer(buffer.getNextFloat())
            .brake(buffer.getNextFloat())
            .clutch(buffer.getNextUInt8AsInt())
            .gear(buffer.getNextUInt8AsInt())
            .engineRPM(buffer.getNextUInt16AsInt())
            .drs(buffer.getNextUInt8AsInt())
            .revLightsPercent(buffer.getNextUInt8AsInt())
            .revLightsBitValue(buffer.getNextUInt16AsInt())
            .brakesTemperature(
                  IntStream.of(4)
                        .mapToObj(i -> buffer.getNextUInt16AsInt())
                        .collect(Collectors.toList())
            )
            .tyresSurfaceTemperature(
                  IntStream.of(4)
                        .mapToObj(i -> buffer.getNextUInt8AsInt())
                        .collect(Collectors.toList())
            )
            .tyresInnerTemperature(
                  IntStream.of(4)
                        .mapToObj(i -> buffer.getNextUInt8AsInt())
                        .collect(Collectors.toList())
            )
            .engineTemperature(buffer.getNextUInt16AsInt())
            .tyrePressure(
                  IntStream.of(4)
                        .mapToObj(i -> buffer.getNextFloat())
                        .collect(Collectors.toList())
            )
            .surfaceType(
                  IntStream.of(4)
                        .mapToObj(i -> buffer.getNextUInt8AsInt())
                        .collect(Collectors.toList())
            )
            .build();
   }

   private Packet buildPacketCarSetupData(Header header) {
      return PacketCarSetupData.builder()
            .header(header)
            .carSetups(
                  IntStream.of(22)
                  .mapToObj(i -> buildCarSetupData())
                  .collect(Collectors.toList())
            )
            .build();
   }

   private CarSetupData buildCarSetupData() {
      return CarSetupData.builder()
            .frontWing(buffer.getNextUInt8AsInt())
            .rearWing(buffer.getNextUInt8AsInt())
            .onThrottle(buffer.getNextUInt8AsInt())
            .offThrottle(buffer.getNextUInt8AsInt())
            .frontCamber(buffer.getNextFloat())
            .rearCamber(buffer.getNextFloat())
            .frontToe(buffer.getNextFloat())
            .rearToe(buffer.getNextFloat())
            .frontSuspension(buffer.getNextUInt8AsInt())
            .rearSuspension(buffer.getNextUInt8AsInt())
            .frontAntiRollBar(buffer.getNextUInt8AsInt())
            .rearAntiRollBar(buffer.getNextUInt8AsInt())
            .frontSuspensionHeight(buffer.getNextUInt8AsInt())
            .rearSuspensionHeight(buffer.getNextUInt8AsInt())
            .brakePressure(buffer.getNextUInt8AsInt())
            .brakeBias(buffer.getNextUInt8AsInt())
            .rearLeftTyrePressure(buffer.getNextFloat())
            .rearRightTyrePressure(buffer.getNextFloat())
            .frontLeftTyrePressure(buffer.getNextFloat())
            .frontRightTyrePressure(buffer.getNextFloat())
            .ballast(buffer.getNextUInt8AsInt())
            .fuelLoad(buffer.getNextFloat())
            .build();
   }

   private Packet buildPacketParticipantsData(Header header) {
      return PacketParticipantsData.builder()
            .header(header)
            .numActiveCars(buffer.getNextUInt8AsInt())
            .participantsData(
                  IntStream.of(22)
                  .mapToObj(i -> buildParticipantData())
                  .collect(Collectors.toList())
            )
            .build();
   }

   private ParticipantData buildParticipantData() {
      return ParticipantData.builder()
            .aiControlled(buffer.getNextUInt8AsInt())
            .driverId(buffer.getNextUInt8AsInt())
            .networkId(buffer.getNextUInt8AsInt())
            .teamId(buffer.getNextUInt8AsInt())
            .myTeam(buffer.getNextUInt8AsInt())
            .raceNumber(buffer.getNextUInt8AsInt())
            .nationality(buffer.getNextUInt8AsInt())
            .name(buffer.getNextCharArrayAsString(48))
            .yourTelemetry(buffer.getNextUInt8AsInt())
            .build();
   }

   private Packet buildPacketEventData(Header header) {
      return PacketEventData.builder()
            .header(header)
            .eventStringCode(
                  IntStream.of(4)
                  .mapToObj(i -> buffer.getNextUInt8AsInt())
                  .collect(Collectors.toList())
            )
            .eventDetails(
                  EventDetails.builder()
                        .fastestLap(buildFastestLap())
                        .retirement(buildRetirement())
                        .teamMateInPits(buildteamMateInPits())
                        .raceWinner(buildraceWinner())
                        .penalty(buildpenalty())
                        .speedTrap(buildspeedTrap())
                        .startLights(buildstartLights())
                        .driveThroughPenaltyServed(builddriveThroughPenaltyServed())
                        .stopGoPenaltyServed(buildstopGoPenaltyServed())
                        .flashback(buildflashback())
                        .buttons(buildbuttons())
                        .build()
            )
            .build();
   }

   private Buttons buildbuttons() {
      return Buttons.builder()
            .buttonStatus(buffer.getNextUIntAsLong())
            .build();
   }

   private Flashback buildflashback() {
      return Flashback.builder()
            .flashbackFrameIdentifier(buffer.getNextUIntAsLong())
            .flashbackSessionTime(buffer.getNextFloat())
            .build();
   }

   private StopGoPenaltyServed buildstopGoPenaltyServed() {
      return StopGoPenaltyServed.builder()
            .vehicleIdx(buffer.getNextUInt8AsInt())
            .build();
   }

   private DriveThroughPenaltyServed builddriveThroughPenaltyServed() {
      return DriveThroughPenaltyServed.builder()
            .vehicleIdx(buffer.getNextUInt8AsInt())
            .build();
   }

   private StartLights buildstartLights() {
      return StartLights.builder()
            .numLights(buffer.getNextUInt8AsInt())
            .build();
   }

   private SpeedTrap buildspeedTrap() {
      return SpeedTrap.builder()
            .vehicleIdx(buffer.getNextUInt8AsInt())
            .speed(buffer.getNextFloat())
            .overallFastestInSession(buffer.getNextUInt8AsInt())
            .driverFastestInSession(buffer.getNextUInt8AsInt())
            .build();
   }

   private Penalty buildpenalty() {
      return Penalty.builder()
            .penaltyType(buffer.getNextUInt8AsInt())
            .infringementType(buffer.getNextUInt8AsInt())
            .vehicleIdx(buffer.getNextUInt8AsInt())
            .otherVehicleIdx(buffer.getNextUInt8AsInt())
            .time(buffer.getNextUInt8AsInt())
            .lapNum(buffer.getNextUInt8AsInt())
            .placesGained(buffer.getNextUInt8AsInt())
            .build();
   }

   private RaceWinner buildraceWinner() {
      return RaceWinner.builder()
            .vehicleIdx(buffer.getNextUInt8AsInt())
            .build();
   }

   private TeamMateInPits buildteamMateInPits() {
      return TeamMateInPits.builder()
            .vehicleIdx(buffer.getNextUInt8AsInt())
            .build();
   }

   private Retirement buildRetirement() {
      return Retirement.builder()
            .vehicleIdx(buffer.getNextUInt8AsInt())
            .build();
   }

   private FastestLap buildFastestLap() {
      return FastestLap.builder()
            .vehicleIdx(buffer.getNextUInt8AsInt())
            .lapTime(buffer.getNextFloat())
            .build();
   }

   private Packet buildPacketLapData(Header header) {
      return PacketLapData.builder()
            .header(header)
            .lapData(
                  IntStream.of(22)
                  .mapToObj(i -> buildLapData())
                  .collect(Collectors.toList())
            )
            .build();
   }

   private LapData buildLapData() {
      return LapData.builder()
            .lastLapTimeMs(buffer.getNextUIntAsLong())
            .currentLapTimeMs(buffer.getNextUIntAsLong())
            .sector1TimeMs(buffer.getNextUInt16AsInt())
            .sector2TimeMs(buffer.getNextUInt16AsInt())
            .lapDistance(buffer.getNextFloat())
            .safetyCarDelta(buffer.getNextFloat())
            .carPosition(buffer.getNextUInt8AsInt())
            .currentLapNumber(buffer.getNextUInt8AsInt())
            .pitStatus(PitStatus.valueOfInt(buffer.getNextUInt8AsInt()))
            .numPitStopsTaken(buffer.getNextUInt8AsInt())
            .sector(buffer.getNextUInt8AsInt())
            .currentLapInvalid(buffer.getNextUInt8AsInt())
            .numUnservedDriveThroughPenalties(buffer.getNextUInt8AsInt())
            .numUnservedStopAndGoPenalties(buffer.getNextUInt8AsInt())
            .gridPosition(buffer.getNextUInt8AsInt())
            .driverStatus(DriverStatus.valueOfInt(buffer.getNextUInt8AsInt()))
            .resultStatus(ResultStatus.valueOfInt(buffer.getNextUInt8AsInt()))
            .pitLaneTimerActive(buffer.getNextUInt8AsInt())
            .pitLaneTimeInLaneMs(buffer.getNextUInt16AsInt())
            .pitStopTimerMs(buffer.getNextUInt16AsInt())
            .pitStopShouldServePenalty(buffer.getNextUInt8AsInt())
            .build();
   }

   private Packet buildPacketSessionData(Header header) {
      return PacketSessionData.builder()
            .header(header)
            .weather(Weather.valueOfInt(buffer.getNextUInt8AsInt()))
            .trackTemperature(buffer.getNextUInt8AsInt())
            .airTemperature(buffer.getNextUInt8AsInt())
            .totalLaps(buffer.getNextUInt8AsInt())
            .trackLength(buffer.getNextUInt16AsInt())
            .sessionType(SessionType.valueOfInt(buffer.getNextUInt16AsInt()))
            .trackId(buffer.getNextUInt8AsInt())
            .formula(buffer.getNextUInt8AsInt())
            .sessionTimeLeft(buffer.getNextUInt16AsInt())
            .sessionDuration(buffer.getNextUInt16AsInt())
            .pitSpeedLimit(buffer.getNextUInt8AsInt())
            .gamePaused(buffer.getNextUInt8AsInt())
            .isSpectating(buffer.getNextUInt8AsInt())
            .spectatorCarIndex(buffer.getNextUInt8AsInt())
            .sliProNativeSupport(buffer.getNextUInt8AsInt())
            .numMarshalZones(buffer.getNextUInt8AsInt())
            .marshalZones(
                  IntStream.of(21)
                  .mapToObj(i -> MarshalZone.builder().zoneStart(buffer.getNextFloat()).zoneFlag(ZoneFlag.valueOfInt(buffer.getNextUInt8AsInt())).build())
                  .collect(Collectors.toList())
            )
            .safetyCarStatus(SafetyCarStatus.valueOfInt(buffer.getNextUInt8AsInt()))
            .networkGame(buffer.getNextUInt8AsInt())
            .numWeatherForecastSamples(buffer.getNextUInt8AsInt())
            .weatherForecastSamples(
                  IntStream.of(56)
                  .mapToObj(i -> buildWeatherForecastSample())
                  .collect(Collectors.toList())
            )
            .forecastAccuracy(buffer.getNextUInt8AsInt())
            .aiDifficulty(buffer.getNextUInt8AsInt())
            .seasonLinkIdentifier(buffer.getNextUIntAsLong())
            .weekendLinkIdentifier(buffer.getNextUIntAsLong())
            .sessionLinkIdentifier(buffer.getNextUIntAsLong())
            .pitStopWindowIdealLap(buffer.getNextUInt8AsInt())
            .pitStopWindowLatestLap(buffer.getNextUInt8AsInt())
            .pitStopRejoinPosition(buffer.getNextUInt8AsInt())
            .steeringAssist(buffer.getNextUInt8AsInt())
            .brakingAssist(buffer.getNextUInt8AsInt())
            .gearboxAssist(buffer.getNextUInt8AsInt())
            .pitReleaseAssist(buffer.getNextUInt8AsInt())
            .ersAssist(buffer.getNextUInt8AsInt())
            .drsAssist(buffer.getNextUInt8AsInt())
            .dynamicRacingLine(buffer.getNextUInt8AsInt())
            .dynamicRacingLineType(buffer.getNextUInt8AsInt())
            .build();
   }

   private WeatherForecastSample buildWeatherForecastSample() {
      return WeatherForecastSample.builder()
            .sessionType(SessionType.valueOfInt(buffer.getNextUInt8AsInt()))
            .timeOffset(buffer.getNextUInt8AsInt())
            .weather(Weather.valueOfInt(buffer.getNextUInt8AsInt()))
            .trackTemperature(buffer.getNextUInt8AsInt())
            .trackTemperatureChange(buffer.getNextUInt8AsInt())
            .airTemperature(buffer.getNextUInt8AsInt())
            .airTemperatureChange(buffer.getNextUInt8AsInt())
            .rainPercentage(buffer.getNextUInt8AsInt())
            .build();
   }

   private Packet buildPacketMotionData(Header header) {
      return PacketMotionData.builder()
            .header(header)
            .carMotionDataList(
                  IntStream.of(22)
                  .mapToObj(i -> buildCarMotionData())
                  .collect(Collectors.toList())
            )
            .suspensionPosition(buildWheelData())
            .suspensionVelocity(buildWheelData())
            .suspensionAcceleration(buildWheelData())
            .wheelSpeed(buildWheelData())
            .wheelSlip(buildWheelData())
            .localVelocityX(buffer.getNextFloat())
            .localVelocityY(buffer.getNextFloat())
            .localVelocityZ(buffer.getNextFloat())
            .angularVelocityX(buffer.getNextFloat())
            .angularVelocityY(buffer.getNextFloat())
            .angularVelocityZ(buffer.getNextFloat())
            .angularAccelerationX(buffer.getNextFloat())
            .angularAccelerationY(buffer.getNextFloat())
            .angularAccelerationZ(buffer.getNextFloat())
            .frontWheelsAngle(buffer.getNextFloat())
            .build();
   }

   private WheelData<Float> buildWheelData() {
      return WheelData.<Float>builder()
            .rearLeft(buffer.getNextFloat())
            .rearRight(buffer.getNextFloat())
            .frontLeft(buffer.getNextFloat())
            .frontRight(buffer.getNextFloat())
            .build();
   }

   private CarMotionData buildCarMotionData() {
      return CarMotionData.builder()
            .worldPositionX(buffer.getNextFloat())
            .worldPositionY(buffer.getNextFloat())
            .worldPositionZ(buffer.getNextFloat())
            .worldVelocityX(buffer.getNextFloat())
            .worldVelocityY(buffer.getNextFloat())
            .worldVelocityZ(buffer.getNextFloat())
            .worldForwardDirX(buffer.getNextUInt16AsInt())
            .worldForwardDirY(buffer.getNextUInt16AsInt())
            .worldForwardDirZ(buffer.getNextUInt16AsInt())
            .worldRightDirX(buffer.getNextUInt16AsInt())
            .worldRightDirY(buffer.getNextUInt16AsInt())
            .worldRightDirZ(buffer.getNextUInt16AsInt())
            .gForceLateral(buffer.getNextFloat())
            .gForceLongitudinal(buffer.getNextFloat())
            .gForceVertical(buffer.getNextFloat())
            .yaw(buffer.getNextFloat())
            .pitch(buffer.getNextFloat())
            .roll(buffer.getNextFloat())
            .build();
   }

}
