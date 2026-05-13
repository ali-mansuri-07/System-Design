package com.proxydesignpattern.withdesignpattern.protectionProxy;

public class DatabaseProxy implements DatabaseAccess {
    private RealDatabase database;
    private String       userRole; // ADMIN, USER, GUEST

    public DatabaseProxy(String userRole) {
        this.database = new RealDatabase();
        this.userRole = userRole;
    }

    @Override
    public void readData() {
        // everyone can read
        database.readData();
    }

    @Override
    public void writeData(String data) {
        if (userRole.equals("ADMIN") || userRole.equals("USER")) {
            database.writeData(data);
        } else {
            System.out.println("Access DENIED: " + userRole + " cannot write");
        }
    }

    @Override
    public void deleteData() {
        if (userRole.equals("ADMIN")) {
            database.deleteData();
        } else {
            System.out.println("Access DENIED: " + userRole + " cannot delete");
        }
    }
}
