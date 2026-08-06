package com.interviewQuestions.couponapplication.coupons;

import com.interviewQuestions.couponapplication.product.Product;

public class CouponDecorator extends Product {
    protected Product product;
    double discountPercentage;
    public CouponDecorator(Product product, double discountPercentage) {
        super(product.getName(), product.getPrice(), product.getProductType());
        this.product = product;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double getPrice() {
        return product.getPrice();
    }
    
}
