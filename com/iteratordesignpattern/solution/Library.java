package com.iteratordesignpattern.solution;

public class Library implements BookCollection {
    Book books[];

    public Library(Book[] books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> createIterator() {
        return new BookIterator(books);
    }

    @Override
    public Iterator<Book> createReverseIterator() {
        return new BookReverseIterator(books);
    }
}
