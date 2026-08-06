package com.interviewQuestions.couponapplication.coupons;

import java.util.ArrayList;
import java.util.List;

import com.interviewQuestions.couponapplication.product.Product;
import com.interviewQuestions.couponapplication.product.ProductType;

public class TypeCouponDecorator extends CouponDecorator {
    static List<ProductType> eligibleProductTypes = new ArrayList<>();
    static {
        eligibleProductTypes.add(ProductType.FURNITURE);
        eligibleProductTypes.add(ProductType.ELECTRONICS);
    }

    public TypeCouponDecorator(Product product, double percentageDiscount) {
        super(product, percentageDiscount);
    }

    @Override
    public double getPrice() {
        double price = this.product.getPrice();
        if (eligibleProductTypes.contains(this.product.getProductType())) {
            double priceAfterDiscount = price - (price * discountPercentage) / 100;
            System.out.println("Applying specific product type coupon of " + discountPercentage + "% on " + product.getName() + ", original price : " + price + ", price after discount : " + priceAfterDiscount);
            return priceAfterDiscount;
        }
        return price;
    }
}
