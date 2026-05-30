package com.interviewQuestions.vehiclerentalsystem.strategy;
import com.interviewQuestions.vehiclerentalsystem.Vehicle;

public class CarPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(Vehicle vehicle, int days) {
        return 50 * days;
    }
    
}
