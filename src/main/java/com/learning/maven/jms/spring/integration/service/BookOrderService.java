package com.learning.maven.jms.spring.integration.service;


import com.learning.maven.jms.spring.integration.model.BookOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookOrderService {

    private final String BOOK_QUEUE = "book.order.queue";
    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(BookOrder bookOrder){
        jmsTemplate.convertAndSend(BOOK_QUEUE,bookOrder);
    }
}
