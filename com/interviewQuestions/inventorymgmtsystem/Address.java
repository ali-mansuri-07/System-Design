package com.interviewQuestions.inventorymgmtsystem;

public class Address {
    String pincode;
    String city;
    String state;

    public Address(String pincode, String city, String state) {
        this.pincode = pincode;
        this.city = city;
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
