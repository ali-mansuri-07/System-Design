package com.interviewQuestions.vendingmachine;

public class IdleState implements VendingMachineState {
    private VendingMachine machine;

    public IdleState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin(Coin coin) {
        machine.addMoney(coin.getValue());
        System.out.println("Coin inserted: Rs." + coin.getValue() +
                           " | Total: Rs." + machine.getInsertedMoney());
        machine.setState(machine.getHasMoneyState()); // transition
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Please insert a coin first.");
    }

    @Override
    public void dispense() {
        System.out.println("No product selected.");
    }

    @Override
    public void refund() {
        System.out.println("No money inserted. Nothing to refund.");
    }
}