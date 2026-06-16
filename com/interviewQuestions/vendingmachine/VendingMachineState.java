package com.interviewQuestions.vendingmachine;

public interface VendingMachineState {
    void insertCoin(Coin coin);

    void selectProduct(Product product);

    void dispense();

    void refund();
}
