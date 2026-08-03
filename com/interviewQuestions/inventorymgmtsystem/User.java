package com.interviewQuestions.inventorymgmtsystem;

import java.util.ArrayList;
import java.util.List;

public class User {
    int userId;
    String username;
    Address address;
    Cart cart;
    List<Order> orderList;

    public User() {
        cart = new Cart();
        orderList = new ArrayList<>();
    }

    public Cart getCart() {
        return cart;
    }
}
