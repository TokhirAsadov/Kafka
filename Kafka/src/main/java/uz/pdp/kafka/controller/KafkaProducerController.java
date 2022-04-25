package uz.pdp.kafka.controller;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/kafka/producer")
public class KafkaProducerController {
    @Autowired
    KafkaTemplate<String,Object> kafkaTemplate;

    @Autowired
    NewTopic newTopic;

    @PostMapping
    public HttpEntity<?> sendToKafkaBroker(){
        kafkaTemplate.send("topic1","Hello Kafka "+new Date());
        return ResponseEntity.ok("Send");
    }
}
