package com.iteratordesignpattern.solution;

public class BookReverseIterator implements Iterator<Book> {
    private Book[] books;
    private int position;

    public BookReverseIterator(Book[] books) {
        this.books = books;
        this.position = books.length - 1;
    }

    @Override
    public boolean hasNext() {
        return position >= 0;
    }

    @Override
    public Book next() {
        return books[position--];
    }
    
}
