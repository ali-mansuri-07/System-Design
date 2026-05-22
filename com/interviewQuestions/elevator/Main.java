package com.interviewQuestions.elevator;

import com.interviewQuestions.elevator.entities.Elevator;
import com.interviewQuestions.elevator.entities.Floor;
import com.interviewQuestions.elevator.enums.Direction;
import com.interviewQuestions.elevator.requests.ExternalRequest;
import com.interviewQuestions.elevator.requests.InternalRequest;
import com.interviewQuestions.elevator.strategy.NearestElevatorStrategy;

public class Main {

    public static void main(String[] args) {

        ElevatorSystem system =
                new ElevatorSystem(
                        new NearestElevatorStrategy()
                );

        // Floors
        for (int i = 0; i <= 10; i++) {
            system.addFloor(new Floor(i));
        }

        // Elevators
        system.addElevator(new Elevator(1));
        system.addElevator(new Elevator(2));
        system.addElevator(new Elevator(3));

        //--------------------------------------------------
        // TEST CASE 1
        //--------------------------------------------------
        System.out.println("TEST CASE 1");
        System.out.println("User at floor 3 wants to go UP");

        ExternalRequest request1 =
                new ExternalRequest(3, Direction.UP);

        ElevatorController controller1 =
                system.requestElevator(request1);

        controller1.submitInternalRequest(
                new InternalRequest(8)
        );

        //--------------------------------------------------
        // TEST CASE 2
        //--------------------------------------------------
        System.out.println("\nTEST CASE 2");
        System.out.println("User at floor 7 wants to go DOWN");

        ExternalRequest request2 =
                new ExternalRequest(7, Direction.DOWN);

        ElevatorController controller2 =
                system.requestElevator(request2);

        controller2.submitInternalRequest(
                new InternalRequest(1)
        );

        //--------------------------------------------------
        // TEST CASE 3
        //--------------------------------------------------
        System.out.println("\nTEST CASE 3");
        System.out.println("User at floor 0 wants to go UP");

        ExternalRequest request3 =
                new ExternalRequest(0, Direction.UP);

        ElevatorController controller3 =
                system.requestElevator(request3);

        controller3.submitInternalRequest(
                new InternalRequest(10)
        );

        //--------------------------------------------------
        // TEST CASE 4
        //--------------------------------------------------
        System.out.println("\nTEST CASE 4");
        System.out.println("Multiple internal stops");

        ElevatorController controller4 =
                system.requestElevator(
                        new ExternalRequest(2, Direction.UP)
                );

        controller4.submitInternalRequest(
                new InternalRequest(5)
        );

        controller4.submitInternalRequest(
                new InternalRequest(9)
        );

        controller4.submitInternalRequest(
                new InternalRequest(6)
        );

        //--------------------------------------------------
        // TEST CASE 5
        //--------------------------------------------------
        System.out.println("\nTEST CASE 5");
        System.out.println("Nearest elevator selection");

        ElevatorController controller5 =
                system.requestElevator(
                        new ExternalRequest(4, Direction.UP)
                );

        controller5.submitInternalRequest(
                new InternalRequest(10)
        );
    }
}
