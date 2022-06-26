package com.learning.maven.jms.spring.integration.controller;


import com.learning.maven.jms.spring.integration.model.BookOrder;
import com.learning.maven.jms.spring.integration.service.BookOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BookController {

    @Autowired
    private BookOrderService bookOrderService;

    @PostMapping(value = "order")
    public BookOrder orderBook(@RequestBody BookOrder bookOrder){
        bookOrderService.send(bookOrder);
        return bookOrder;
    }
}
