package uz.pdp.kafkacomsumer.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    @Value("${server.port}")
    private String port;

    @KafkaListener(id = "myId", topics = "topic1")
    public void listen(String in) {
        System.out.println("Port : "+port+" , Message : "+in);
    }
}
