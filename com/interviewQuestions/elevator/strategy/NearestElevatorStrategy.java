package com.interviewQuestions.elevator.strategy;

import java.util.List;

import com.interviewQuestions.elevator.ElevatorController;
import com.interviewQuestions.elevator.requests.ExternalRequest;

public class NearestElevatorStrategy implements ElevatorSelectionStrategy {
    @Override
    public ElevatorController selectElevator(List<ElevatorController> controllers,
            ExternalRequest request) {
        // Logic to select the nearest elevator based on current positions and
        // directions of elevators
        ElevatorController nearestController = null;
        int minDistance = Integer.MAX_VALUE;
        for (ElevatorController controller : controllers) {
            // Check if the elevator is moving towards the request floor or is idle and
            // calculate distance
            int distance = Math.abs(controller.getElevator().getCurrentFloor() - request.getSourceFloor());
            // Consider the direction of the elevator and the request to determine if it can
            // serve the request efficiently
            if (distance < minDistance) {
                minDistance = distance;
                nearestController = controller;
            }
        }
        return nearestController;
    }

}
