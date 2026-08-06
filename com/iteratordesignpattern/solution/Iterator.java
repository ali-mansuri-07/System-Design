package com.iteratordesignpattern.solution;

// Iterator interface
public interface Iterator<T> {
    boolean hasNext();

    T next();
}