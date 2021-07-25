package de.sfrick.udp;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;


@RequiredArgsConstructor
public class MessageDecoder implements Decoder.Text<Message> {

   private final ObjectMapper om;

   @SneakyThrows
   @Override
   public Message decode(String s) throws DecodeException {
      return om.readValue(s, Message.class);
   }

   @Override
   public boolean willDecode(String s) {
      return (s != null);
   }

   @Override
   public void init(EndpointConfig endpointConfig) {
      // no op
   }

   @Override
   public void destroy() {
      // no op
   }
}
