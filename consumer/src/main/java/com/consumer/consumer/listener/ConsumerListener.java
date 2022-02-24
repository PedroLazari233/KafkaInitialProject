package com.consumer.consumer.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class ConsumerListener {

    private final Logger logger = LoggerFactory.getLogger(ConsumerListener.class);

    @KafkaListener(topics = "${topic.demo-topic}", groupId = "group_id")
    public void consume(String message) throws IOException {
        logger.info(String.format("Listening message: %s", message));
    }
}
