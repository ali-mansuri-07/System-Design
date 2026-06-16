package com.interviewQuestions.vendingmachine;

public class ProductSelectedState implements VendingMachineState {
    private VendingMachine machine;

    public ProductSelectedState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin(Coin coin) {
        machine.addMoney(coin.getValue());
        System.out.println("Coin inserted: Rs." + coin.getValue() +
                " | Total: Rs." + machine.getInsertedMoney());
        dispense(); // re-check after inserting more
    }

    @Override
    public void selectProduct(Product product) {
        System.out.println("Product already selected. Please wait.");
    }

    @Override
    public void dispense() {
        Product selected = machine.getSelectedProduct();
        double price = selected.getPrice();
        double insertedMoney = machine.getInsertedMoney();

        if (insertedMoney < price) {
            System.out.println("Insufficient funds. Need Rs." + price +
                    ", have Rs." + insertedMoney +
                    ". Please insert Rs." + (price - insertedMoney) + " more.");
            machine.setState(machine.getHasMoneyState()); // go back — wait for more coins
            return;
        }

        // Enough money — move to dispensing
        machine.setState(machine.getDispensingState());
        machine.getCurrentState().dispense();
    }

    @Override
    public void refund() {
        double refundAmount = machine.getInsertedMoney();
        machine.resetMoney();
        machine.setSelectedProduct(null);
        System.out.println("Refunded: Rs." + refundAmount);
        machine.setState(machine.getIdleState());
    }
}