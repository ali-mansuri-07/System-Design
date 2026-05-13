package com.proxydesignpattern.withoutproxydesignpattern;

// Main class for demonstrating the without proxy design pattern
public class Main {
    public static void main(String[] args) {
        Internet internet = new RealInternet();
        internet.connectTo("google.com");
        internet.connectTo("facebook.com");
    }
}