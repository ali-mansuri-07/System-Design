package com.interviewQuestions.parkingLot.parkingStrategy;

import com.interviewQuestions.parkingLot.utility.FeeStrategy;

public class StrategyFactory {
    public static ParkingSpotLookupStrategy getLookupStrategy(String type) {
        if ("NEAREST".equalsIgnoreCase(type)) {
            return new NearestSpotStrategy();
        } else if ("FIRST_AVAILABLE".equalsIgnoreCase(type)) {
            return new FirstAvailableStrategy();
        }
        return new NearestSpotStrategy(); // default
    }

    public static FeeStrategy getFeeStrategy(String type) {
        if ("HOURLY".equalsIgnoreCase(type)) {
            return new HourlyFeeStrategy();
        }
        return new HourlyFeeStrategy(); // default
    }
}
