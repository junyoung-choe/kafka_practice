package org.example.server1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class Controller {
    private final Producer producer;
//    @PostMapping("kafka")
//    public String testApi(@RequestBody String message) {
//        log.info("API 수신 했습니다.");
//        producer.sendMessage("Jun 님이 message 보냅니다");
//        return "api 통신 성공";
//    }

    @PostMapping("kafka/object")
    public String testObjectApi(@RequestBody KafkaDto kafkaDto) {
        log.info("API 객체 수신 했습니다.");
        producer.sendObject(kafkaDto);
        return "api 객체 수신 성공";
    }
}
