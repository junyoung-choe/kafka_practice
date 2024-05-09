package org.example.server1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class Producer {
    private static final String TOPIC = "test";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        log.info("프로듀서가 메세지 보냅니다.");
        this.kafkaTemplate.send(TOPIC, message);
    }
}