package com.producer.producer.resource;


import com.producer.producer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class ProducerResource {

    @Autowired
    ProducerService producerService;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message){
        producerService.sendMessageToKafka(message);
        return ResponseEntity.ok().body(message); //HTTP response (code 200)
    }
}
