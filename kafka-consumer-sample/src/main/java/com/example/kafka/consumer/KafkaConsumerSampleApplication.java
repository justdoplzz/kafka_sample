package com.example.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class KafkaConsumerSampleApplication {

    private static final Logger logger =
            LoggerFactory.getLogger(KafkaConsumerSampleApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerSampleApplication.class, args);
    }


    @KafkaListener(topics = "${kafka.topic_name}", groupId = "${kafka.group_id}")
    public void listener(String message) {
        logger.info("Received message = {}", message);
    }
}