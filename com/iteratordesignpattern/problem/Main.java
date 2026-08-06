package com.iteratordesignpattern.problem;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // BAD — caller must know internal structure of every collection
        // Different traversal code for every data structure

        // For Array
        Library library = new Library(new Book[] {
                new Book("Book 1", 100),
                new Book("Book 2", 200),
                new Book("Book 3", 300)
        });
        Book[] books = library.getBooks();
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getTitle());
        }

        // For ArrayList
        // Library library = new Library(new ArrayList<>());
        ArrayList<Book> booksList = library.getBooksList();
        for (int i = 0; i < booksList.size(); i++) {
            System.out.println(booksList.get(i).getTitle());
        }

        // For LinkedList — different again!
        LinkedList<Book> booksLinkedList = library.getLinkedBooks();
        // ... yet another traversal style
        for (Book book : booksLinkedList) {
            System.out.println(book.getTitle());
        }

        // Problem: caller is tightly coupled to the collection's internal structure
        // Change ArrayList to LinkedList = change ALL traversal code everywhere
    }

}