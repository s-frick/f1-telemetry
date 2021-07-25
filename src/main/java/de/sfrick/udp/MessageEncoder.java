package de.sfrick.udp;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

@RequiredArgsConstructor
public class MessageEncoder implements Encoder.Text<Message> {

   private final ObjectMapper om;

   @SneakyThrows
   @Override
   public String encode(Message message) throws EncodeException {
      return om.writeValueAsString(message);
   }

   @Override
   public void init(EndpointConfig endpointConfig) {
      //      no op
   }

   @Override
   public void destroy() {
      //      no op
   }
}
