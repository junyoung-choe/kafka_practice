package org.example.server2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Consumer {

//    @KafkaListener(topics = "test", groupId = "junGroup")
//    public void listen1(String message) {
//        log.info("컨슈머가 메세지 poll 합니다.");
//        log.info("junGroup 이 받은 message: " + message);
//    }

    @KafkaListener(topics = "json", groupId = "objectGroup")
    public void listen2(String str) {
        log.info("컨슈머가 객체 poll 합니다.");
        log.info("junGroup 이 받은 객체: " + str);

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        KafkaDto kafkaDto;
        try {
            kafkaDto = mapper.readValue(str, KafkaDto.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        log.info(kafkaDto.toString());
    }
}