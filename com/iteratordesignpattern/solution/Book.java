package com.iteratordesignpattern.solution;

public class Book {
    String title;
    int price;

    public Book(String title, int price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book [Title=" + title + ", Price=" + price + "]";
    }
}
