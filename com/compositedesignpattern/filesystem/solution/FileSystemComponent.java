package com.compositedesignpattern.filesystem.solution;

// FileSystemComponent.java
// The common interface — client uses ONLY this
public interface FileSystemComponent {
    String getName();
    double getSize();          // in KB
    void display(String indent); // print tree structure
    void add(FileSystemComponent component);    // only Directories use this
    void remove(FileSystemComponent component); // only Directories use this
}
