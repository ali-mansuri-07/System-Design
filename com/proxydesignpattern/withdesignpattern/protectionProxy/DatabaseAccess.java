package com.proxydesignpattern.withdesignpattern.protectionProxy;

public interface DatabaseAccess {
    void readData();
    void writeData(String data);
    void deleteData();
}