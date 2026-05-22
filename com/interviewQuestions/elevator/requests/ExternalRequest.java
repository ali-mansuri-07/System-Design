package com.interviewQuestions.elevator.requests;

import com.interviewQuestions.elevator.enums.Direction;

public class ExternalRequest extends Request {

    public ExternalRequest(int sourceFloor, Direction direction) {
        this.sourceFloor = sourceFloor;
        this.direction = direction;
    }
}
