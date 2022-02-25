package com.kafkaDemo.producer.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kafkaDemo.producer.service.ProducerService;

@RestController
@RequestMapping("/message")
public class ProducerResource {

    @Autowired
    ProducerService producerService;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message){
        producerService.sendMessageToKafka(message);
        return ResponseEntity.ok().body("Message sent successfully: " + message); //HTTP response (code 200)
    }
}