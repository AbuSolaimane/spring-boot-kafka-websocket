package com.fadili.kafkanotificationsystem.controllers;


import com.fadili.kafkanotificationsystem.config.Producer;
import com.fadili.kafkanotificationsystem.entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final Producer producer;

    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/readDataFromWebUi")
    public void readDataFromWebUi(@RequestBody Message message) {

        this.producer.sendMessage(message.toString());
    }
}
