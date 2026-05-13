package com.proxydesignpattern.withproxydesignpattern.protectionProxy;

public interface DatabaseAccess {
    void readData();
    void writeData(String data);
    void deleteData();
}