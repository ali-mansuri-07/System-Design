package com.interviewQuestions.vendingmachine;

public class DispensingState implements VendingMachineState {
    private VendingMachine machine;

    public DispensingState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please wait — dispensing in progress.");
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Please wait — dispensing in progress.");
    }

    @Override
    public void dispense() {
        Product product = machine.getSelectedProduct();
        double price = product.getPrice();
        double inserted = machine.getInsertedMoney();
        double change = inserted - price;

        // Dispense the product
        machine.getInventory().dispense(product);
        System.out.println("Dispensing: " + product.getName() + " ✓");

        // Return change
        if (change > 0) {
            System.out.println("Returning change: Rs." + change);
        }

        // Reset machine for next transaction
        machine.resetMoney();
        machine.setSelectedProduct(null);
        machine.setState(machine.getIdleState()); // back to IDLE
        System.out.println("Transaction complete. Machine is ready.");
    }

    @Override
    public void refund() {
        System.out.println("Dispensing in progress — cannot refund now.");
    }
}