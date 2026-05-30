package com.interviewQuestions.vehiclerentalsystem;

import com.interviewQuestions.vehiclerentalsystem.enums.VehicleType;
import com.interviewQuestions.vehiclerentalsystem.enums.VehicleStatus;

public abstract class Vehicle {

    protected String vehicleId;
    protected String vehicleNumber;
    protected VehicleType vehicleType;
    protected VehicleStatus status;

    public Vehicle(
            String vehicleId,
            String vehicleNumber,
            VehicleType type) {

        this.vehicleId = vehicleId;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = type;
        this.status = VehicleStatus.AVAILABLE;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }
}
