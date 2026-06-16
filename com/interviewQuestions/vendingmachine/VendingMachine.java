package com.interviewQuestions.vendingmachine;

public class VendingMachine {
    // States
    private VendingMachineState idleState;
    private VendingMachineState hasMoneyState;
    private VendingMachineState dispensingState;
    private VendingMachineState productSelectedState;

    // current state
    private VendingMachineState currentState;

    // Transaction data
    private Inventory inventory;
    private double insertedMoney;
    private Product selectedProduct;

    public VendingMachine() {
        // Initialize states
        this.idleState = new IdleState(this);
        this.hasMoneyState = new HasMoneyState(this);
        this.dispensingState = new DispensingState(this);
        this.productSelectedState = new ProductSelectedState(this);

        // Machine data
        this.inventory = new Inventory();
        this.insertedMoney = 0;
        this.selectedProduct = null;

        // Start in idle state
        this.currentState = idleState;
    }

    // ── Delegating actions to current state ──────────────────

    public synchronized void insertCoin(Coin coin) {
        currentState.insertCoin(coin);
    }

    public synchronized void selectProduct(Product product) {
        currentState.selectProduct(product);
    }

    public synchronized void refund() {
        currentState.refund();
    }

    public synchronized void dispense() {
        currentState.dispense();
    }

    // ── Admin operations ─────────────────────────────────────
    public void restock(Product product, int quantity) {
        inventory.addProduct(product, quantity);
        System.out.println("Restocked " + quantity + " units of " + product.getName());
    }

    public void displayStatus() {
        System.out.println("\n=== Vending Machine Status ===");
        System.out.println("State          : " + currentState.getClass().getSimpleName());
        System.out.println("Inserted money : Rs." + insertedMoney);
        System.out.println("Selected product: " +
                (selectedProduct != null ? selectedProduct : "None"));
        inventory.displayStock();
        System.out.println("==============================\n");
    }

    // ── Internal helpers (used by states) ────────────────────

    public void setState(VendingMachineState state) {
        this.currentState = state;
    }

    public VendingMachineState getCurrentState() {
        return currentState;
    }

    public void addMoney(double amount) {
        this.insertedMoney += amount;
    }

    public void resetMoney() {
        this.insertedMoney = 0;
    }

    public double getInsertedMoney() {
        return insertedMoney;
    }

    public void setSelectedProduct(Product p) {
        this.selectedProduct = p;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public VendingMachineState getIdleState() {
        return idleState;
    }

    public VendingMachineState getHasMoneyState() {
        return hasMoneyState;
    }

    public VendingMachineState getProductSelectedState() {
        return productSelectedState;
    }

    public VendingMachineState getDispensingState() {
        return dispensingState;
    }

}
