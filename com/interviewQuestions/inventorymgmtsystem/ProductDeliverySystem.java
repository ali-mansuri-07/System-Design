package com.interviewQuestions.inventorymgmtsystem;

import java.util.List;

public class ProductDeliverySystem {

    UserController userController;
    WarehouseController warehouseController;
    OrderController orderController;

    ProductDeliverySystem(List<User> userList, List<Warehouse> warehouseList) {
        userController = new UserController(userList);
        warehouseController = new WarehouseController(warehouseList, new NearestWarehouseSelectionStrategy());
        orderController = new OrderController();
    }

    // get user object
    public User getUser(int userId) {
        return userController.getUserById(userId);
    }

    // get warehouse
    public Warehouse getWarehouse(WarehouseSelectionStrategy warehouseSelectionStrategy) {
        return warehouseController.selectWarehouse(warehouseSelectionStrategy);

    }

    // get inventory
    public Inventory getInventory(Warehouse warehouse) {
        return warehouse.inventory;

    }

    // add product to cart
    public void addProductToCart(User user, ProductCategory product, int count) {
        Cart cart = user.getCart();
        cart.addItemInCart(product.productCategoryId, count);
    }

    // place order
    public Order placeOrder(User user, Warehouse warehouse) {
        return orderController.createOrder(user, warehouse);
    }

    public void checkout(Order order) {
        order.checkout();
        System.out.println("Order checked out successfully for user: " + order.user.username);
    }

}
