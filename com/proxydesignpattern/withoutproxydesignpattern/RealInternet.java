package com.proxydesignpattern.withoutproxydesignpattern;

class RealInternet implements Internet {
    public void connectTo(String serverhost) {
        System.out.println("Connecting to " + serverhost);
    }
}