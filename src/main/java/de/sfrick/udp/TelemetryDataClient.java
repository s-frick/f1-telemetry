package de.sfrick.udp;

import de.sfrick.application.Message;
import de.sfrick.application.TelemetryWebsocketHandler;
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

import static java.util.Objects.isNull;

public class TelemetryDataClient extends Thread {

   private static final Logger LOGGER = LoggerFactory.getLogger(TelemetryDataClient.class);
   private DatagramSocket socket;
   private boolean running;
   private byte[] buf = new byte[1024];
   private TelemetryWebsocketHandler websocket;

   public TelemetryDataClient(int port) throws SocketException {
      socket = new DatagramSocket(port);
   }

   public void setWebsocket(TelemetryWebsocketHandler websocket) {
      this.websocket = websocket;
   }

   public void run() {
      if (websocket == null) {
         return;
      }
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

            Message message = Message.builder()
                  .textMessage(new TextMessage(telemetryPacket.toJSON()))
                  .key(PacketType.valueOfInt(telemetryPacket.getHeader().getPacketId()).toString())
                  .build();
            websocket.broadcast(message);
         }
      }
      socket.close();
   }

   private byte[] getData(InetAddress address, int port) {
      return new DatagramPacket(buf, buf.length, address, port).getData();
   }

}
