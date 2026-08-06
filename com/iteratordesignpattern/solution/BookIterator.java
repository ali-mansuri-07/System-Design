package com.iteratordesignpattern.solution;


public class BookIterator implements Iterator<Book> {
    Book[] books;
    int index;

    public BookIterator(Book[] books) {
        this.books = books;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if (index < books.length) {
            return true;
        }
        return false;
    }

    @Override
    public Book next() {
        if (this.hasNext()) {
            return books[index++];
        }
        return null;
    }

}
