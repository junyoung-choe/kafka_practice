package org.example.server1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class Producer {

//    private static final String TOPIC1 = "test";
//    private final KafkaTemplate<String, String> kafkaTemplate1;
//
//    public void sendMessage(String message) {
//        log.info("프로듀서가 메세지 보냅니다.");
//        this.kafkaTemplate1.send(TOPIC1, message);
//    }

    private static final String TOPIC2 = "json";
    private final KafkaTemplate<String, Object> kafkaTemplate2;

    public  void sendObject(KafkaDto kafkaDto) {
        log.info("프로듀서가 객체 보냅니다.");
        this.kafkaTemplate2.send(TOPIC2,  kafkaDto);
    }
}