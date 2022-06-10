package com.fadili.kafkanotificationsystem.config;


import com.fadili.kafkanotificationsystem.services.WebSocketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {

    @Autowired
    private WebSocketService webSocketService;

    private final Logger logger = LoggerFactory.getLogger(Producer.class);

    @KafkaListener(topics = "message", groupId = "group_id")
    public void consume(String message) throws IOException {
        this.webSocketService.sendMessage("message", message);
        logger.info(String.format("#### -> Consumed message -> %s", message));
    }
}
