package org.example.server2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Consumer {

    @KafkaListener(topics = "test", groupId = "junGroup")
    public void listen1(String message) {
        log.info("컨슈머가 메세지 poll 합니다.");
        log.info("junGroup 이 받은 message: " + message);
    }

    @KafkaListener(topics = "json", groupId = "objectGroup")
    public void listen2(KafkaDto kafkaDto) {
        log.info("컨슈머가 객체 poll 합니다.");
        log.info("junGroup 이 받은 객체: " + kafkaDto.toString());
    }
}