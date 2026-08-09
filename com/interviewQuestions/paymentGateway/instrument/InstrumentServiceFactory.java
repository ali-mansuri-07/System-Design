package com.interviewQuestions.paymentGateway.instrument;

public class InstrumentServiceFactory{
    public InstrumentService getInstrumentService(InstrumentType instrumentType){
        if(instrumentType == InstrumentType.BANK){
            return new BankService();
        }else if(instrumentType == InstrumentType.CARD){
            return new CardService();
        }
        return null;
    }
}
