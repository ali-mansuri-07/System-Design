package com.interviewQuestions.elevator.strategy;

import java.util.List;

import com.interviewQuestions.elevator.ElevatorController;
import com.interviewQuestions.elevator.requests.ExternalRequest;

public interface ElevatorSelectionStrategy {
    ElevatorController selectElevator(List<ElevatorController> controllers, ExternalRequest externalRequest);
}
