package com.interviewQuestions.vehiclerentalsystem.strategy;

public class BikePricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(com.interviewQuestions.vehiclerentalsystem.Vehicle vehicle, int days) {
        return 20 * days;
    }

}
