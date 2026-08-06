package com.iteratordesignpattern.solution;

public class Main {
    public static void main(String[] args) {
        Book[] books = {
                new Book("Book 1", 10),
                new Book("Book 2", 20),
                new Book("Book 3", 30),
                new Book("Book 4", 40),
        };

        Library library = new Library(books);

        // Forward iteration
        System.out.println("Forward Iteration:");
        Iterator<Book> iterator = library.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Reverse iteration
        System.out.println("\nReverse Iteration:");
        Iterator<Book> reverseIterator = library.createReverseIterator();
        while (reverseIterator.hasNext()) {
            System.out.println(reverseIterator.next());
        }
    }
}
