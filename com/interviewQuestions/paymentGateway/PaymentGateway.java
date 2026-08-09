package com.interviewQuestions.paymentGateway;

import java.util.List;

import com.interviewQuestions.paymentGateway.instrument.InstrumentController;
import com.interviewQuestions.paymentGateway.instrument.InstrumentDO;
import com.interviewQuestions.paymentGateway.instrument.InstrumentType;
import com.interviewQuestions.paymentGateway.transaction.Transaction;
import com.interviewQuestions.paymentGateway.transaction.TransactionController;
import com.interviewQuestions.paymentGateway.transaction.TransactionDO;
import com.interviewQuestions.paymentGateway.user.UserController;
import com.interviewQuestions.paymentGateway.user.UserDO;

public class PaymentGateway {

    public static void main(String[] args) {

        System.out.println("\nLLD Code - Payment Gateway\n");

        InstrumentController instrumentController = new InstrumentController();
        UserController userController = new UserController();
        TransactionController transactionController = new TransactionController();

        // Add USER1
        UserDO user1 = new UserDO();
        user1.setUserId(1);
        user1.setUserName("Alice");
        user1.setEmail("alice@conceptandcoding.com");
        UserDO user1Details = userController.addUser(user1);

        // Add USER2
        UserDO user2 = new UserDO();
        user2.setUserId(2);
        user2.setUserName("Bob");
        user2.setEmail("bob@conceptandcoding.com");
        UserDO user2Details = userController.addUser(user2);

        // Add Bank to User1
        InstrumentDO bankInstrumentDO = new InstrumentDO();
        bankInstrumentDO.setBankAccountNumber("234324234324324");
        bankInstrumentDO.setInstrumentType(InstrumentType.BANK);
        bankInstrumentDO.setUserId(user1Details.getUserId());
        bankInstrumentDO.setIfscCode("ER3223E");
        InstrumentDO user1BankInstrument = instrumentController.addInstrument(bankInstrumentDO);
        System.out.println("Bank Instrument created for User1: " + user1BankInstrument.getInstrumentId());

        // Add Card to User2
        InstrumentDO cardInstrumentDO = new InstrumentDO();
        cardInstrumentDO.setCardNumber("1230099");
        cardInstrumentDO.setInstrumentType(InstrumentType.CARD);
        cardInstrumentDO.setCvvNumber("0000");
        cardInstrumentDO.setUserId(user2Details.getUserId());
        InstrumentDO user2CardInstrument = instrumentController.addInstrument(cardInstrumentDO);
        System.out.println("Card Instrument created for User2: " + user2CardInstrument.getInstrumentId());

        // Make Payment
        TransactionDO transactionDO = new TransactionDO();
        transactionDO.setTxnId(101);
        transactionDO.setAmount(500);
        transactionDO.setSenderId(user1Details.getUserId());
        transactionDO.setReceiverId(user2Details.getUserId());
        transactionDO.setDebitInstrumentId(user1BankInstrument.getInstrumentId());
        transactionDO.setCreditInstrumentId(user2CardInstrument.getInstrumentId());
        transactionController.makePayment(transactionDO);

        // Get all instruments of USER1
        List<InstrumentDO> user1Instruments = instrumentController.getAllInstruments(user1Details.getUserId());
        for (InstrumentDO instrumentDO : user1Instruments) {
            System.out.println("\nUser1 Name: " + user1Details.getUserName() +
                    "; UserID: " + instrumentDO.getUserId() +
                    "; InstrumentID: " + instrumentDO.getInstrumentId() +
                    "; InstrumentType: " + instrumentDO.getInstrumentType().name());
        }

        // Get all instruments of USER2
        List<InstrumentDO> user2Instruments = instrumentController.getAllInstruments(user2Details.getUserId());
        for (InstrumentDO instrumentDO : user2Instruments) {
            System.out.println("User2 Name: " + user2Details.getUserName() +
                    "; UserID: " + instrumentDO.getUserId() +
                    "; InstrumentID: " + instrumentDO.getInstrumentId() +
                    "; InstrumentType: " + instrumentDO.getInstrumentType().name());
        }

        // Get transaction history of USER1
        List<Transaction> user1TransactionList = transactionController.getTransactionHistory(user1Details.getUserId());
        for (Transaction txn : user1TransactionList) {
            System.out.println("\nUser1 txnID: " + txn.getTxnId() +
                    "; Amount: " + txn.getAmount() +
                    "; SenderId: " + txn.getSenderId() +
                    "; ReceiverId: " + txn.getReceiverId());
        }

        // Get transaction history of USER2
        List<Transaction> user2TransactionList = transactionController.getTransactionHistory(user2Details.getUserId());
        for (Transaction txn : user2TransactionList) {
            System.out.println("User2 txnID: " + txn.getTxnId() +
                    "; Amount: " + txn.getAmount() +
                    "; SenderId: " + txn.getSenderId() +
                    "; ReceiverId: " + txn.getReceiverId());
        }
    }
}
