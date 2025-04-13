package kafka.producer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Service
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void send(String phoneNumber) {
        LOGGER.info("Sending phone number: {}", phoneNumber);
        CompletableFuture.delayedExecutor(10, TimeUnit.SECONDS).execute(() ->
                kafkaTemplate.send("deneme2703JSON", phoneNumber, phoneNumber));
    }


}
