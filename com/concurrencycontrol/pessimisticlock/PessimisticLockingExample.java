package com.concurrencycontrol.pessimisticlock;

// Using JDBC — SELECT FOR UPDATE acquires a row-level lock
// No other transaction can read or write this row until we commit/rollback

import java.sql.*;

class PessimisticLockingExample {

    public void withdraw(Connection conn, String accountId, double amount)
            throws SQLException {

        conn.setAutoCommit(false); // start transaction

        try {
            // SELECT FOR UPDATE — locks the row immediately
            // Any other transaction trying to SELECT FOR UPDATE on same row
            // will BLOCK until this transaction commits or rolls back
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT balance FROM accounts WHERE id = ? FOR UPDATE");
            ps.setString(1, accountId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                double balance = rs.getDouble("balance");
                System.out.println("Current balance: " + balance);

                if (balance < amount) {
                    System.out.println("Insufficient funds!");
                    conn.rollback();
                    return;
                }

                // Safe to write — we hold the lock
                PreparedStatement update = conn.prepareStatement(
                        "UPDATE accounts SET balance = ? WHERE id = ?");
                update.setDouble(1, balance - amount);
                update.setString(2, accountId);
                update.executeUpdate();

                conn.commit(); // lock released here
                System.out.println("Withdrawal successful. New balance: " + (balance - amount));
            }

        } catch (SQLException e) {
            conn.rollback(); // lock released on rollback too
            throw e;
        }
    }
}