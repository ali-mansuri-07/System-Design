package com.interviewQuestions.inventorymgmtsystem;

import java.util.Map;

public class Warehouse {
    Inventory inventory;
    Address address;

    public void removeItemFromInventory(Map<Integer, Integer> productCategoryAndQuantityMap) {
        inventory.removeItems(productCategoryAndQuantityMap);
    }

    public void addProductCategoryInInventory() {
        
    }
}
