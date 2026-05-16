package com.interviewQuestions.parkingLot.entities;

import com.interviewQuestions.parkingLot.gates.EntranceGate;
import com.interviewQuestions.parkingLot.gates.ExitGate;
import com.interviewQuestions.parkingLot.utility.FeeStrategy;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private static ParkingLot instance;

    public List<ParkingFloor> floors = new ArrayList<>();
    public List<EntranceGate> entranceGates = new ArrayList<>();
    public List<ExitGate> exitGates = new ArrayList<>();

    public FeeStrategy feeStrategy;

    private ParkingLot() {
    }

    public static ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }
}