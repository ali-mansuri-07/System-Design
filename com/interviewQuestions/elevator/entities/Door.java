package com.interviewQuestions.elevator.entities;

import com.interviewQuestions.elevator.enums.DoorStatus;

public class Door {
    private DoorStatus status = DoorStatus.CLOSED;
    
    public void open() {
        status = DoorStatus.OPEN;
        System.out.println("Door is Opened...");
    }

    public void close() {
        status = DoorStatus.CLOSED;
        System.out.println("Door is Closed...");
    }
}
