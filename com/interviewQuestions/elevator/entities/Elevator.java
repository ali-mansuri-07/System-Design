package com.interviewQuestions.elevator.entities;

import com.interviewQuestions.elevator.enums.Direction;
import com.interviewQuestions.elevator.enums.ElevatorStatus;

public class Elevator {
    private int id;
    private int currentFloor;
    private Display display;
    private ElevatorStatus status;
    private Door door;
    private Direction direction;

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.display = new Display();
        this.status = ElevatorStatus.IDLE;
        this.door = new Door();
        this.direction = Direction.IDLE;
    }

    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public ElevatorStatus getStatus() {
        return status;
    }

    public void setStatus(ElevatorStatus status) {
        this.status = status;
    }

    public Door getDoor() {
        return door;
    }

    public Display getDisplay() {
        return display;
    }

}
