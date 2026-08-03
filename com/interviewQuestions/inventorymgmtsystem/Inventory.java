package com.interviewQuestions.inventorymgmtsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Inventory {
    List<ProductCategory> productCategories;

    Inventory() {
        this.productCategories = new ArrayList<>();
    }

    public void addProductCategory(int categoryId, String categoryName, double price) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.productCategoryId = categoryId;
        productCategory.productCategoryName = categoryName;
        productCategory.price = price;
        productCategories.add(productCategory);
    }

    public void addProduct(Product product, int categoryId) {
        ProductCategory productCategory = null;
        for (ProductCategory pg : productCategories) {
            if (pg.productCategoryId == categoryId) {
                productCategory = pg;
            }
        }
        if (productCategory != null) {
            productCategory.addProduct(product);
        }
    }

    public void removeItems(Map<Integer, Integer> productCategoryAndCountMap) {
        for (Map.Entry<Integer, Integer> entry : productCategoryAndCountMap.entrySet()) {
            ProductCategory category = getProductCategoryFromID(entry.getKey());
            category.removeProduct(entry.getValue());
        }
    }

    private ProductCategory getProductCategoryFromID(int productCategoryId) {

        for (ProductCategory productCategory : productCategories) {

            if (productCategory.productCategoryId == productCategoryId) {
                return productCategory;
            }
        }

        return null;
    }
}
