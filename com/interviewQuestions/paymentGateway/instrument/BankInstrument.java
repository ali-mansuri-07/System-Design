package com.interviewQuestions.paymentGateway.instrument;

public class BankInstrument extends Instrument {
    String bankAccountNumber;
    String ifscCode;

    public BankInstrument(){
        super(0, 0, null);
    }

    public BankInstrument(int instrumentId, int userId, InstrumentType instrumentType,
            String bankAccountNumber, String ifscCode) {
        super(instrumentId, userId, instrumentType);
        this.bankAccountNumber = bankAccountNumber;
        this.ifscCode = ifscCode;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

}
