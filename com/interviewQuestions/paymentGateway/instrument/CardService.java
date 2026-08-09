package com.interviewQuestions.paymentGateway.instrument;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardService extends InstrumentService {

    public CardService() {
        super();
    }

    @Override
    public InstrumentDO addInstrument(InstrumentDO instrumentDO) {
        // card specific logic here

        CardInstrument cardInstrument = new CardInstrument();
        cardInstrument.instrumentId = new Random().nextInt(100 - 10) + 10;
        cardInstrument.cardNumber = instrumentDO.cardNumber;
        cardInstrument.cvv = instrumentDO.cvvNumber;
        cardInstrument.instrumentType = InstrumentType.CARD;
        cardInstrument.userId = instrumentDO.userId;
        List<Instrument> userInstrumentsList = userInstruments.get(cardInstrument.userId);
        if (userInstrumentsList == null) {
            userInstrumentsList = new ArrayList<>();
            userInstruments.put(cardInstrument.userId, userInstrumentsList);
        }
        userInstrumentsList.add(cardInstrument);
        return mapBankInstrumentToInstrumentDO((CardInstrument) cardInstrument);
    }

    private InstrumentDO mapBankInstrumentToInstrumentDO(CardInstrument cardInstrument) {
        InstrumentDO instrumentDOObj = new InstrumentDO();
        instrumentDOObj.instrumentType = cardInstrument.instrumentType;
        instrumentDOObj.instrumentId = cardInstrument.instrumentId;
        instrumentDOObj.cardNumber = cardInstrument.cardNumber;
        instrumentDOObj.cvvNumber = cardInstrument.cvv;
        instrumentDOObj.userId = cardInstrument.userId;
        return instrumentDOObj;
    }

    public List<InstrumentDO> getInstrumentsByUserId(int userID) {
        List<Instrument> userInstrumentsList = userInstruments.get(userID);
        List<InstrumentDO> userInstrumentsFetched = new ArrayList<>();
        for (Instrument instrument : userInstrumentsList) {
            if (instrument.getInstrumentType() == InstrumentType.CARD)
                userInstrumentsFetched.add(mapBankInstrumentToInstrumentDO((CardInstrument) instrument));
        }
        return userInstrumentsFetched;
    }
}
