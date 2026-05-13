package com.observerdesignpattern;

// Observer.java
// Every observer must implement this
// When observable changes, update() is called on all observers
interface Observer {
    void update(String item);
}