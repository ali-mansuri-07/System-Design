package com.observerdesignpattern;

import java.util.ArrayList;
import java.util.List;

// OrderService.java — the Subject
// When an order is placed, all subscribed observers are notified
class OrderService implements Observable {

    // List of all subscribed observers
    private List<Observer> observers = new ArrayList<>();
    private String currentItem;

    // Subscribe a new observer
    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
        System.out.println(observer.getClass().getSimpleName() + " subscribed");
    }

    // Unsubscribe an observer
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
        System.out.println(observer.getClass().getSimpleName() + " unsubscribed");
    }

    // Notify ALL observers — doesn't care who they are
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(currentItem);
        }
    }

    // Business method — triggers notification
    public void placeOrder(String item) {
        System.out.println("\n--- Order placed: " + item + " ---");
        this.currentItem = item;
        notifyObservers(); // automatically tells everyone
    }

}