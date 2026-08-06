package com.interviewQuestions.couponapplication.product;

public class Item4 extends Product {
    public Item4(String name, double originalPrice, ProductType productType) {
        super(name, originalPrice, productType);
    }

    @Override
    public double getPrice() {
        return originalPrice;
    }

}
