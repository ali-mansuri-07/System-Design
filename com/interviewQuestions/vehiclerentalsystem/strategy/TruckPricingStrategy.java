package com.interviewQuestions.vehiclerentalsystem.strategy;

public class TruckPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(com.interviewQuestions.vehiclerentalsystem.Vehicle vehicle, int days) {
        return 100 * days;
    }

}
