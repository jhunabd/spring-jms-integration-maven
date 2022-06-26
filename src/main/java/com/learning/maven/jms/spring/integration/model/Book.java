package com.learning.maven.jms.spring.integration.model;

public class Book {
    private final String bookId;
    private final String title;

    public Book(String bookId, String title) {
        this.bookId = bookId;
        this.title = title;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }
}
