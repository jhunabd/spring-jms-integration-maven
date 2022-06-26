package com.learning.maven.jms.spring.integration.service;

import com.learning.maven.jms.spring.integration.model.BookOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class BookOrderReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookOrderReceiver.class);

    @JmsListener(destination = "book.order.queue")
    public void receive(BookOrder bookOrder){
        LOGGER.warn("message received");
        LOGGER.warn("message is" +bookOrder);
    }
}
