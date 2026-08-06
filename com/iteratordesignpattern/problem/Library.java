package com.iteratordesignpattern.problem;

import java.util.ArrayList;
import java.util.LinkedList;

public class Library {
    Book books[];

    public Library(Book[] books) {
        this.books = books;
    }

    public Book[] getBooks() {
        return books;
    }

    public ArrayList<Book> getBooksList() {
        ArrayList<Book> bookList = new ArrayList<>();
        for (Book book : books) {
            bookList.add(book);
        }
        return bookList;
    }

    public LinkedList<Book> getLinkedBooks() {
        LinkedList<Book> bookLinkedList = new LinkedList<>();
        for (Book book : books) {
            bookLinkedList.add(book);
        }
        return bookLinkedList;
    }
}
