package org.example.server1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class KafkaDto {
  private String sender;
  private String title;
  private String content;
}
