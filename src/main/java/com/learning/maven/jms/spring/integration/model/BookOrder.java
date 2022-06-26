package com.learning.maven.jms.spring.integration.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookOrder {
    private final String orderId;
    private final String customerId;
    private final String bookId;

    @JsonCreator
    public BookOrder(@JsonProperty("orderId") String orderId,
                     @JsonProperty("customerId") String customerId,
                     @JsonProperty("bookId") String bookId) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.bookId = bookId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getBookId() {
        return bookId;
    }
}
