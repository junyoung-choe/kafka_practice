package org.example.server2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Consumer {

    @KafkaListener(topics = "test", groupId = "junGroup")
    public void listen(String message) {
        log.info("컨슈머가 메세지 poll 합니다.");
        log.info("junGroup 이 받은 message: " + message);
    }
}