package com.interviewQuestions.paymentGateway.transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.interviewQuestions.paymentGateway.instrument.InstrumentController;
import com.interviewQuestions.paymentGateway.instrument.InstrumentDO;

public class TransactionService {
    public static Map<Integer, List<Transaction>> userTransactionsList = new HashMap<>();
    InstrumentController instrumentController;
    Processor processor;

    public TransactionService() {
        this.instrumentController = new InstrumentController();
        this.processor = new Processor();
    }

    public List<Transaction> getTransactionHistory(int userId) {
        return userTransactionsList.get(userId);
    }

    public TransactionDO makePayment(TransactionDO transactionDO) {
        // validate transactionDO

        // get sender instrument
        InstrumentDO senderInstrumentDO = instrumentController.getInstrumentById(transactionDO.getSenderId(),
                transactionDO.getDebitInstrumentId());

        // get receiver
        InstrumentDO receiverInstrumentDO = instrumentController.getInstrumentById(transactionDO.getReceiverId(),
                transactionDO.getCreditInstrumentId());

        // process payment
        processor.processPayment(senderInstrumentDO, receiverInstrumentDO);

        // based on processor response, we will set the status. for now har coding it to
        // SUCCESS
        Transaction txn = new Transaction();
        txn.setAmount(transactionDO.getAmount());
        txn.setTxnId(transactionDO.getTxnId());
        txn.setSenderId(transactionDO.getSenderId());
        txn.setReceiverId(transactionDO.getReceiverId());
        txn.setDebitInstrumentId(transactionDO.getDebitInstrumentId());
        txn.setCreditInstrumentId(transactionDO.getCreditInstrumentId());
        txn.setTransactionStatus(TransactionStatus.SUCCESS);

        // history
        List<Transaction> senderTxnsList = userTransactionsList.get(txn.getSenderId());
        if (senderTxnsList == null) {
            senderTxnsList = new ArrayList<>();
            userTransactionsList.put(txn.getSenderId(), senderTxnsList);
        }
        senderTxnsList.add(txn);
        List<Transaction> receiverTxnLists = userTransactionsList.get(txn.getReceiverId());
        if (receiverTxnLists == null) {
            receiverTxnLists = new ArrayList<>();
            userTransactionsList.put(txn.getReceiverId(), receiverTxnLists);
        }
        receiverTxnLists.add(txn);
        transactionDO.setTxnId(txn.getTxnId());
        transactionDO.setTransactionStatus(txn.getTransactionStatus());
        return transactionDO;
    }
}
