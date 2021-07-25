package de.sfrick.udp;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.SocketException;

import static org.junit.jupiter.api.Assertions.*;

class TelemetryDataClientTest {


   EchoClient client;

//   @BeforeEach
//   public void setup() throws SocketException {
//      new EchoServer(20777).start();
//      client = new EchoClient();
//   }

   @Test
   public void whenCanSendAndReceivePacket_thenCorrect() throws IOException {
      String echo = client.sendEcho("hello server");
      assertEquals("hello server", echo);
      echo = client.sendEcho("server is working");


      assertFalse(echo.equals("hello server"));
   }

   @AfterEach
   public void tearDown() throws IOException {
      client.sendEcho("end");
      client.close();
   }

}
