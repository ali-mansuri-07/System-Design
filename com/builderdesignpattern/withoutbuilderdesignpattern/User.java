package com.builderdesignpattern.withoutbuilderdesignpattern;

class User {
    String name;
    int age;
    String email;
    String phone;
    String address;

    // Constructor with all parameters
    public User(String name, int age, String email,
            String phone, String address) {

        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
}
