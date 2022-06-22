package com.learning.maven.jms.spring.integration;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "test.queue",containerFactory = "warehouseFactory")
    public void receiveMessage(String message){
        System.out.println(message);
    }
}
