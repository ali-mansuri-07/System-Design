package com.interviewQuestions.paymentGateway.instrument;

public class CardInstrument extends Instrument {
    String cardNumber;
    String cvv;

    public CardInstrument(){
        super(0, 0, null);
    }

    public CardInstrument(int instrumentId, int userId, InstrumentType instrumentType,
            String cardNumber, String cvv) {
        super(instrumentId, userId, instrumentType);
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

}
