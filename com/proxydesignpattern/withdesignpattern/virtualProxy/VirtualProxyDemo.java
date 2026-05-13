package com.proxydesignpattern.withdesignpattern.virtualProxy;

// Main class for demonstrating the virtual proxy design pattern
public class VirtualProxyDemo {
    public static void main(String[] args) {
        Image image = new ImageProxy("photo.jpg");
        // image NOT loaded yet
        System.out.println("Image created but not loaded yet");
        image.display(); // NOW it loads
        image.display(); // uses cached realImage — no reload
    }
}
