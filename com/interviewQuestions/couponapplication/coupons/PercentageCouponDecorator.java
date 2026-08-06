package com.interviewQuestions.couponapplication.coupons;

import com.interviewQuestions.couponapplication.product.Product;

public class PercentageCouponDecorator extends CouponDecorator {
    public PercentageCouponDecorator(Product product, double discountPercentage) {
        super(product, discountPercentage);
    }

    @Override
    public double getPrice() {
        double price = super.getPrice();
        return price - (price * discountPercentage / 100);
    }

}
