package com.interviewQuestions.paymentGateway.transaction;

import com.interviewQuestions.paymentGateway.instrument.InstrumentDO;

public class Processor {
    public void processPayment(InstrumentDO senderInstrumentDO, InstrumentDO receiverInstrumentDO) {
        // process payment logic here

        // validate sender instrument

        // validate receiver instrument

        // process payment

        // update balance in sender instrument - debit

        // update balance in receiver instrument - credit
    }
}
