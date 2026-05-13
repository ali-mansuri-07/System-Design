package com.proxydesignpattern.withdesignpattern.protectionProxy;

public class RealDatabase implements DatabaseAccess {
     @Override
    public void readData() {
        System.out.println("Reading data from database");
    }

    @Override
    public void writeData(String data) {
        System.out.println("Writing to database: " + data);
    }

    @Override
    public void deleteData() {
        System.out.println("Deleting data from database");
    }
    
}
