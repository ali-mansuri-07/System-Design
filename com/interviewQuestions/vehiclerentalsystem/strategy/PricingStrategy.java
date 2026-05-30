package com.interviewQuestions.vehiclerentalsystem.strategy;

import com.interviewQuestions.vehiclerentalsystem.Vehicle;

public interface PricingStrategy {
    double calculatePrice(Vehicle vehicle, int totalDays);
}