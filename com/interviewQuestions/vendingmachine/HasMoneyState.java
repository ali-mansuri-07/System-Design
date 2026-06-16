package com.interviewQuestions.vendingmachine;

public class HasMoneyState implements VendingMachineState {
    private VendingMachine machine;

    public HasMoneyState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin(Coin coin) {
        // Accept more coins — stay in same state
        machine.addMoney(coin.getValue());
        System.out.println("Coin inserted: Rs." + coin.getValue() +
                " | Total: Rs." + machine.getInsertedMoney());
    }

    @Override
    public void selectProduct(Product product) {
        if (!machine.getInventory().isAvailable(product)) {
            System.out.println("Sorry, " + product.getName() + " is out of stock!");
            return;
        }
        machine.setSelectedProduct(product);
        System.out.println("Product selected: " + product);
        machine.setState(machine.getProductSelectedState()); // transition
        machine.getCurrentState().dispense(); // trigger dispense check
    }

    @Override
    public void dispense() {
        System.out.println("Please select a product first.");
    }

    @Override
    public void refund() {
        double refundAmount = machine.getInsertedMoney();
        machine.resetMoney();
        System.out.println("Refunded: Rs." + refundAmount);
        machine.setState(machine.getIdleState()); // transition back
    }
}