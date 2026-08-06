package com.interviewQuestions.couponapplication.product;

public class Item1 extends Product {
    public Item1(String name, double originalPrice, ProductType productType) {
        super(name, originalPrice, productType);
    }

    @Override
    public double getPrice() {
        return originalPrice;
    }
    
}
