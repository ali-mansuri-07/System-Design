package com.interviewQuestions.elevator.entities;

import com.interviewQuestions.elevator.enums.Direction;
import com.interviewQuestions.elevator.enums.ElevatorStatus;

public class Display {
    public void show(int floor, Direction direction, ElevatorStatus status) {
        System.out.println("Floor: " + floor + " Direction: " + direction + " Status: " + status);
    }
}
