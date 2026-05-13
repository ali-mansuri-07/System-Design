package com.proxydesignpattern.withdesignpattern.protectionProxy;

// Main class for demonstrating the protection proxy design pattern
public class ProtectionProxyDemo {
    public static void main(String[] args) {
        DatabaseAccess admin = new DatabaseProxy("ADMIN");
        DatabaseAccess user  = new DatabaseProxy("USER");
        DatabaseAccess guest = new DatabaseProxy("GUEST");

        System.out.println("─── ADMIN ───");
        admin.readData();
        admin.writeData("admin data");
        admin.deleteData();

        System.out.println("─── USER ───");
        user.readData();
        user.writeData("user data");
        user.deleteData();   // denied

        System.out.println("─── GUEST ───");
        guest.readData();
        guest.writeData("guest data"); // denied
        guest.deleteData();            // denied

    }
}
