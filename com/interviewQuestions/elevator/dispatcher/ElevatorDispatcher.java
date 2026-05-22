package com.interviewQuestions.elevator.dispatcher;

import java.util.List;

import com.interviewQuestions.elevator.ElevatorController;
import com.interviewQuestions.elevator.requests.ExternalRequest;
import com.interviewQuestions.elevator.strategy.ElevatorSelectionStrategy;

public class ElevatorDispatcher {
    private ElevatorSelectionStrategy strategy;

    public ElevatorDispatcher(ElevatorSelectionStrategy strategy) {
        this.strategy = strategy;
    }

    public ElevatorController assignElevator(List<ElevatorController> controllers, ExternalRequest externalRequest) {
        // Logic to assign elevator based on strategy
        return strategy.selectElevator(controllers, externalRequest);
    }
}
