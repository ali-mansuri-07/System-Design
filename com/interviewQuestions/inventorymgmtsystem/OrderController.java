package com.interviewQuestions.inventorymgmtsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderController {
    List<Order> orderList;
    Map<Integer, List<Order>> userIDVsOrders;

    OrderController() {
        orderList = new ArrayList<>();
        userIDVsOrders = new HashMap<>();
    }

    public Order createOrder(User user, Warehouse warehouse) {
        Order order = new Order(user, warehouse);
        orderList.add(order);

        if (userIDVsOrders.containsKey(user.userId)) {
            List<Order> orders = userIDVsOrders.get(user.userId);
            orders.add(order);
            userIDVsOrders.put(user.userId, orders);
        } else {
            List<Order> orders = new ArrayList<>();
            orders.add(order);
            userIDVsOrders.put(user.userId, orders);
        }
        System.out.println("Order created successfully for user: " + user.username);
        return order;
    }

    public void removeOrder(Order order) {
        orderList.remove(order);
        List<Order> orders = userIDVsOrders.get(order.user.userId);
        orders.remove(order);
        userIDVsOrders.put(order.user.userId, orders);
        System.out.println("Order removed successfully for user: " + order.user.username);
    }

    public List<Order> getOrdersByUser(User user) {
        return userIDVsOrders.get(user.userId);
    }
}
