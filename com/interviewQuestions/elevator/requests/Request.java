package com.interviewQuestions.elevator.requests;

import com.interviewQuestions.elevator.enums.Direction;

public abstract class Request {
    int sourceFloor;
    int destinationFloor;
    Direction direction;

    public Direction getDirection() {
        return direction;
    }

    public int getSourceFloor() {
        return sourceFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }
}
