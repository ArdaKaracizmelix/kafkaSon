package kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer2 {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer2.class);

    @KafkaListener(topics = "deneme2703JSON", groupId = "group1")
    public void consume(ConsumerRecord<String, String> record) {
        String phoneNumber = record.value();
        int partition = record.partition();
        String topic = record.topic();
        long offset = record.offset();
        if (phoneNumber.equals("0")) {
            throw new RuntimeException("fail");
        }
        LOGGER.info("[Consumer-2]  phone number: {} | Partition: {} | Offset: {} | Topic: {} | GroupId: group1",
                phoneNumber, partition, offset, topic);

        mockSmsService(phoneNumber, "Consumer-2");
    }
    private void mockSmsService(String phone, String consumerName) {
        LOGGER.info("[{}] Mock SMS sent to {}", consumerName, phone);
    }
}
