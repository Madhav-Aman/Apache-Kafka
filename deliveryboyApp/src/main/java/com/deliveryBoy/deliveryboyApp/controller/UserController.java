package com.deliveryBoy.deliveryboyApp.controller;

import com.deliveryBoy.deliveryboyApp.service.KafkaService;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class UserController {

    @Autowired
    private KafkaService kafkaService;


    final Logger log = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation(){
        this.kafkaService.updateLocation("("+Math.random()+" "+Math.random()+")");
        log.info("done ");
        return new ResponseEntity<>(Map.of(), HttpStatus.OK);
    }
}
