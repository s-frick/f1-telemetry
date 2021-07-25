package de.sfrick.udp.f1.packets;

import com.fasterxml.jackson.databind.ObjectMapper;

public interface Packet {

   Header getHeader();

   default String toJSON() {
      ObjectMapper mapper = new ObjectMapper();
      String json = "";
      try {
         json = mapper.writeValueAsString(this);
      }catch(Exception e) {
         //TODO: Handle this exception
      }
      return json.replace("\\u0000", "");
   }
}
