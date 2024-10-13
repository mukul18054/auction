package com.work.notification.listener;

import com.work.notification.dto.WinnerDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SampleListener {

    Logger logger = LoggerFactory.getLogger(getClass());

    @KafkaListener(topics = "${kafka.topic}", groupId = "${kafka.groupId}")
    public void listen(WinnerDTO message) {
        logger.info("Received message from Kafka: {}", message);
    }
}
