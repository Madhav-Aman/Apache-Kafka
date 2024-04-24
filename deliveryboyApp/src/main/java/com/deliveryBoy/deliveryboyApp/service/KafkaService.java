package com.deliveryBoy.deliveryboyApp.service;

import com.deliveryBoy.deliveryboyApp.config.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String ,String> kafkaTemplate;

    public boolean updateLocation(String location){
        for(int i =0;i<100000;i++){
            this.kafkaTemplate.send(AppConstant.LOCATION_TOPIC_UPDATE, location);
            System.out.println("__________________________________________________________________________");
        }
        return true;
    }
}
