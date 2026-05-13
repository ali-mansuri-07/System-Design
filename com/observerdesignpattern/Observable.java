package com.observerdesignpattern;

public interface Observable {
    // The Observable (publisher) maintains a list of observers
    void subscribe(Observer observer);

    void unsubscribe(Observer observer);

    void notifyObservers();
}
