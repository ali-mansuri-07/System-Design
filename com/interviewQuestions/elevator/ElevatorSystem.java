package com.interviewQuestions.elevator;

import java.util.ArrayList;
import java.util.List;

import com.interviewQuestions.elevator.dispatcher.ElevatorDispatcher;
import com.interviewQuestions.elevator.entities.Elevator;
import com.interviewQuestions.elevator.entities.Floor;
import com.interviewQuestions.elevator.requests.ExternalRequest;
import com.interviewQuestions.elevator.strategy.ElevatorSelectionStrategy;

public class ElevatorSystem {

    private List<Floor> floors = new ArrayList<>();
    private List<ElevatorController> controllers = new ArrayList<>();
    private ElevatorDispatcher dispatcher;

    public ElevatorSystem(ElevatorSelectionStrategy strategy) {
        dispatcher = new ElevatorDispatcher(strategy);
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    public void addElevator(Elevator elevator) {
        controllers.add(new ElevatorController(elevator));
    }

    public ElevatorController requestElevator(ExternalRequest request) {

        ElevatorController controller = dispatcher.assignElevator(controllers, request);

        System.out.println(
                "\nAssigned Elevator: " +
                        controller.getElevator().getId());

        controller.submitExternalRequest(request);

        return controller;
    }
}