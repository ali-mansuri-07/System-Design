package com.interviewQuestions.inventorymgmtsystem;

import java.util.ArrayList;
import java.util.List;

public class ProductCategory {
    int productCategoryId;
    String productCategoryName;
    List<Product> products;
    double price;

    public ProductCategory() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        products.add(product);
    }

    public void removeProduct(int count) {
        for (int i = 0; i < count; i++) {
            if (products != null && !products.isEmpty()) {
                products.remove(products.size() - 1);
            }
        }
    }

}
