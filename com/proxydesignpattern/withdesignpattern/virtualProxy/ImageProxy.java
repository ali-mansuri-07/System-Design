package com.proxydesignpattern.withdesignpattern.virtualProxy;

// Virtual Proxy — delays loading until display() called
public class ImageProxy implements Image {
    private RealImage realImage; //null until load on demand
    private String fileName; 

    public ImageProxy(String fileName) {
        this.fileName = fileName;
        // RealImage NOT created yet — lazy!
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName); // create only when needed
        }
        realImage.display();
    }
    
}
