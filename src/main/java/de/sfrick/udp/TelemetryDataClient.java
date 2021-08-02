package de.sfrick.udp;

import de.sfrick.application.Channel;
import de.sfrick.application.Message;
import de.sfrick.udp.f1.PacketDeserializer;
import de.sfrick.udp.f1.packets.Packet;
import de.sfrick.udp.f1.packets.PacketType;
import io.vavr.control.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class TelemetryDataClient extends Thread {

   private static final Logger LOGGER = LoggerFactory.getLogger(TelemetryDataClient.class);

   private final Map<PacketType, Channel> messageQueue;
   private DatagramSocket socket;
   private boolean running;
   private byte[] buf = new byte[1024];


   public TelemetryDataClient(int port, List<Channel> messageQueue) throws SocketException {
      socket = new DatagramSocket(port);
      this.messageQueue = messageQueue.stream().collect(Collectors.toMap(
            Channel::getChannelName,
            channel -> channel
      ));

   }


   public void run() {
      running = true;

      while (running) {
         DatagramPacket packet
               = new DatagramPacket(buf, buf.length);
         DatagramPacket finalPacket = packet;
         Try.run(() -> socket.receive(finalPacket));

         InetAddress address = packet.getAddress();
         int port = packet.getPort();

         Packet telemetryPacket = PacketDeserializer.read(getData(address, port));

         if (!isNull(telemetryPacket)) {
            LOGGER.debug(telemetryPacket.toJSON());

            PacketType packetType = PacketType.valueOfInt(telemetryPacket.getHeader().getPacketId());
            Message message = Message.builder()
                  .textMessage(new TextMessage(telemetryPacket.toJSON()))
                  .key(packetType.toString())
                  .build();
            messageQueue.get(packetType).add(message);
         }
      }
      socket.close();
   }

   private byte[] getData(InetAddress address, int port) {
      return new DatagramPacket(buf, buf.length, address, port).getData();
   }

}
