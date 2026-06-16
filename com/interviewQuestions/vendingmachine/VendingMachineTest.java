package com.interviewQuestions.vendingmachine;

public class VendingMachineTest {

    static VendingMachine machine;
    static Product chips;
    static Product water;
    static Product coffee;

    static void setup() {
        machine = new VendingMachine();
        chips = new Product("Chips", 20);
        water = new Product("Water", 15);
        coffee = new Product("Coffee", 50);

        machine.restock(chips, 5);
        machine.restock(water, 3);
        machine.restock(coffee, 2);
    }

    // ── Test 1: Happy path — exact change ────────────────────
    static void testHappyPathExactChange() {
        System.out.println("\n====== TEST 1: Happy path — exact change ======");
        setup();

        machine.insertCoin(Coin.TEN);
        machine.insertCoin(Coin.TEN);
        machine.selectProduct(chips); // Rs.20 exact

        // Expected:
        // Coin inserted: Rs.10 | Total: Rs.10
        // Coin inserted: Rs.10 | Total: Rs.20
        // Product selected: Chips (Rs.20.0)
        // Dispensing: Chips ✓
        // Transaction complete. Machine is ready.
    }

    // ── Test 2: Happy path — with change returned ─────────────
    static void testHappyPathWithChange() {
        System.out.println("\n====== TEST 2: Happy path — with change ======");
        setup();

        machine.insertCoin(Coin.FIFTY);
        machine.selectProduct(chips); // Rs.20, inserted Rs.50

        // Expected:
        // Dispensing: Chips ✓
        // Returning change: Rs.30.0
    }

    // ── Test 3: Insufficient funds — insert more coins ────────
    static void testInsufficientFundsThenTopUp() {
        System.out.println("\n====== TEST 3: Insufficient → insert more ======");
        setup();

        machine.insertCoin(Coin.TEN);
        machine.selectProduct(coffee); // Rs.50, have only Rs.10 — should prompt
        // Insufficient funds. Need Rs.50, have Rs.10. Insert Rs.40 more.

        machine.insertCoin(Coin.TWENTY);
        machine.insertCoin(Coin.TWENTY);
        // Now has Rs.50 — should auto-dispense

        // Expected:
        // Dispensing: Coffee ✓
        // Transaction complete.
    }

    // ── Test 4: Refund mid-transaction ────────────────────────
    static void testRefund() {
        System.out.println("\n====== TEST 4: Refund ======");
        setup();

        machine.insertCoin(Coin.TWENTY);
        machine.insertCoin(Coin.TEN);
        machine.refund();

        // Expected:
        // Coin inserted: Rs.20 | Total: Rs.20
        // Coin inserted: Rs.10 | Total: Rs.30
        // Refunded: Rs.30.0
    }

    // ── Test 5: Out of stock product ──────────────────────────
    static void testOutOfStock() {
        System.out.println("\n====== TEST 5: Out of stock ======");
        machine = new VendingMachine();
        Product juice = new Product("Juice", 25);
        // NOT restocked — stock = 0

        machine.insertCoin(Coin.TWENTY);
        machine.insertCoin(Coin.TEN);
        machine.selectProduct(juice);

        // Expected:
        // Sorry, Juice is out of stock!
        // (stays in HasMoneyState — money not lost)

        machine.refund();
        // Refunded: Rs.30.0
    }

    // ── Test 6: Select product without inserting coin ─────────
    static void testSelectWithoutCoin() {
        System.out.println("\n====== TEST 6: Select without coin ======");
        setup();

        machine.selectProduct(chips);

        // Expected:
        // Please insert a coin first.
    }

    // ── Test 7: Multiple transactions in sequence ─────────────
    static void testMultipleTransactions() {
        System.out.println("\n====== TEST 7: Multiple transactions ======");
        setup();

        // Transaction 1
        machine.insertCoin(Coin.TWENTY);
        machine.selectProduct(chips);

        // Transaction 2 — machine back to IDLE
        machine.insertCoin(Coin.FIFTY);
        machine.selectProduct(coffee);

        // Transaction 3 — another chips
        machine.insertCoin(Coin.TEN);
        machine.insertCoin(Coin.TEN);
        machine.selectProduct(water); // Rs.15 but inserted Rs.20

        // Expected: change Rs.5 returned after water
    }

    // ── Test 8: Refund when no money inserted ─────────────────
    static void testRefundWithNoMoney() {
        System.out.println("\n====== TEST 8: Refund with no money ======");
        setup();

        machine.refund();
        // Expected:
        // No money inserted. Nothing to refund.
    }

    // ── Run all tests ─────────────────────────────────────────
    public static void main(String[] args) {
        testHappyPathExactChange();
        testHappyPathWithChange();
        testInsufficientFundsThenTopUp();
        testRefund();
        testOutOfStock();
        testSelectWithoutCoin();
        testMultipleTransactions();
        testRefundWithNoMoney();

        System.out.println("\n====== All tests ran ======");
    }
}