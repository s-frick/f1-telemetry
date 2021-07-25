package de.sfrick.application;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.socket.TextMessage;

@Data
@Builder
public class Message {
   private TextMessage textMessage;
   private String key;
}
