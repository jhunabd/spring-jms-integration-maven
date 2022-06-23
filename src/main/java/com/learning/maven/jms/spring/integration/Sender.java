package com.learning.maven.jms.spring.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    @Autowired
    private JmsTemplate jmsTemplate;


    public void send(String destination,String message){
        jmsTemplate.convertAndSend(destination,message);
    }
}
