package com.interviewQuestions.inventorymgmtsystem;

import java.util.Map;

public class Order {
    User user;
    Address deliveryAddress;
    Map<Integer, Integer> productCategoryIdAndCountMap;
    Warehouse warehouse;
    OrderStatus orderStatus;
    Invoice invoice;
    Payment payment;

    public Order(User user, Warehouse warehouse){
        this.user = user;
        this.warehouse = warehouse;
        this.productCategoryIdAndCountMap = user.getCart().getCartItems();
        this.deliveryAddress = user.address;
        invoice = new Invoice();
        invoice.generateInvoice(this);
    }

    public void checkout(){
        //1. Update the inventory of the warehouse
        warehouse.removeItemFromInventory(productCategoryIdAndCountMap);
        //2. Make payment
        boolean isPaymentSuccessful = makePayment(new UPIPaymentMode());
        if(isPaymentSuccessful){
            user.getCart().emptyCart();
            orderStatus = OrderStatus.DELIVERED;
        } else {
            warehouse.addProductCategoryInInventory();
            orderStatus = OrderStatus.UNDELIVERED;
        }
    }

    public boolean makePayment(PaymentMode paymentMode){
        payment = new Payment(paymentMode);
       return payment.makePayment(invoice.getTotalFinalPrice());
    }

    public void generateOrderInvoice(){
        invoice.generateInvoice(this);
    }
}
