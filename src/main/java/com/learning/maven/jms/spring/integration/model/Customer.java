package com.learning.maven.jms.spring.integration.model;

public class Customer {
    private final String customerId;
    private final String fullname;

    public Customer(String customerId, String fullname) {
        this.customerId = customerId;
        this.fullname = fullname;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getFullname() {
        return fullname;
    }
}
