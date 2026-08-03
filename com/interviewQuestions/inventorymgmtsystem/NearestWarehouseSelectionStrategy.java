package com.interviewQuestions.inventorymgmtsystem;

import java.util.List;

public class NearestWarehouseSelectionStrategy extends WarehouseSelectionStrategy {
    @Override
    public Warehouse selectWarehouse(List<Warehouse> warehouseList) {
        // Implement logic to select the nearest warehouse based on distance or other criteria
        // For simplicity, let's assume we return the first warehouse in the list
        if (warehouseList != null && !warehouseList.isEmpty()) {
            return warehouseList.get(0);
        }
        return null;
    }
    
}
