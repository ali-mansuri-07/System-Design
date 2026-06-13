package com.concurrencycontrol.optimisticlock;

// Implements the read → compute → check version → write → retry loop
class OptimisticLockService {

    public void withdraw(BankAccount account, String user, double amount) {
        int maxRetries = 3;

        for (int attempt = 1; attempt <= maxRetries; attempt++) {
            System.out.println(user + " attempt " + attempt + ": " +
                    "reading balance=" + account.getBalance() +
                    " v=" + account.getVersion());

            // Step 1 — Read (no lock acquired)
            double currentBalance = account.getBalance();
            int currentVersion = account.getVersion();

            // Step 2 — Compute
            if (currentBalance < amount) {
                System.out.println(user + ": Insufficient funds!");
                return;
            }

            // Simulate some processing delay
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
            }

            // Step 3 — Write with version check
            // If version changed between read and now → someone else wrote → retry
            boolean success = account.withdraw(amount, currentVersion);

            if (success) {
                System.out.println(user + ": Transaction committed successfully!");
                return;
            }

            System.out.println(user + ": Retrying... (attempt " + attempt + ")");
        }

        System.out.println(user + ": Failed after " + maxRetries + " retries");
    }
}