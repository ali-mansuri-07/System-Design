package com.interviewQuestions.elevator;

import java.util.Collections;
import java.util.PriorityQueue;

import com.interviewQuestions.elevator.entities.Elevator;
import com.interviewQuestions.elevator.enums.Direction;
import com.interviewQuestions.elevator.enums.ElevatorStatus;
import com.interviewQuestions.elevator.requests.ExternalRequest;
import com.interviewQuestions.elevator.requests.InternalRequest;

public class ElevatorController {
    private Elevator elevator;

    public ElevatorController(Elevator elevator) {
        this.elevator = elevator;
    }

    public Elevator getElevator() {
        return elevator;
    }

    private PriorityQueue<Integer> upQueue = new PriorityQueue<>();
    private PriorityQueue<Integer> downQueue = new PriorityQueue<>(Collections.reverseOrder());

    public void submitInternalRequest(InternalRequest internalRequest) {
        int destinationFloor = internalRequest.getDestinationFloor();
        if (destinationFloor > elevator.getCurrentFloor()) {
            upQueue.offer(destinationFloor);
        } else if (destinationFloor < elevator.getCurrentFloor()) {
            downQueue.offer(destinationFloor);
        }
        processRequests();
    }

    public void submitExternalRequest(ExternalRequest externalRequest) {
        int sourceFloor = externalRequest.getSourceFloor();
        if (sourceFloor > elevator.getCurrentFloor()) {
            upQueue.offer(sourceFloor);
        } else if (sourceFloor < elevator.getCurrentFloor()) {
            downQueue.offer(sourceFloor);
        }
        processRequests();
    }

    private void processRequests() {
        processUpRequests();
        processDownRequests();
    }

    private void processUpRequests() {
        while (!upQueue.isEmpty()) {
            int targetFloor = upQueue.poll();
            moveToFloor(targetFloor);
        }
    }

    private void processDownRequests() {
        while (!downQueue.isEmpty()) {
            int targetFloor = downQueue.poll();
            moveToFloor(targetFloor);
        }
    }

    private void moveToFloor(int targetFloor) {
        elevator.setStatus(ElevatorStatus.MOVING);
        if(targetFloor > elevator.getCurrentFloor()) {
            elevator.setDirection(Direction.UP);
        } else {
            elevator.setDirection(Direction.DOWN);
        }

        while(targetFloor != elevator.getCurrentFloor()) {
            if(elevator.getDirection() == Direction.UP) {
                elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
            } else {
                elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
            }
            elevator.getDisplay().show(elevator.getCurrentFloor(), elevator.getDirection(), elevator.getStatus());
        }
        elevator.getDoor().open();
        elevator.getDoor().close();

        elevator.setStatus(ElevatorStatus.IDLE);
        elevator.setDirection(Direction.IDLE);
    }
}
