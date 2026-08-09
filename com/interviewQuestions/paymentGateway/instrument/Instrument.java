package com.interviewQuestions.paymentGateway.instrument;

public class Instrument {
    int instrumentId;
    int userId;
    InstrumentType instrumentType;

    public Instrument(int instrumentId, int userId, InstrumentType instrumentType) {
        this.instrumentId = instrumentId;
        this.userId = userId;
        this.instrumentType = instrumentType;
    }

    public int getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(int instrumentId) {
        this.instrumentId = instrumentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public InstrumentType getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(InstrumentType instrumentType) {
        this.instrumentType = instrumentType;
    }

    
}
