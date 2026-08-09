package com.interviewQuestions.paymentGateway.instrument;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankService extends InstrumentService {

    public BankService() {
        super();
    }

    @Override
    public InstrumentDO addInstrument(InstrumentDO instrumentDO) {
        // bank specific logic here
        BankInstrument bankInstrument = new BankInstrument();
        bankInstrument.instrumentId = new Random().nextInt(100 - 10) + 10;
        bankInstrument.bankAccountNumber = instrumentDO.bankAccountNumber;
        bankInstrument.ifscCode = instrumentDO.ifscCode;
        bankInstrument.instrumentType = InstrumentType.BANK;
        bankInstrument.userId = instrumentDO.userId;

        List<Instrument> userInstrumentsList = userInstruments.get(bankInstrument.userId);
        if (userInstrumentsList == null) {
            userInstrumentsList = new ArrayList<>();
            userInstruments.put(bankInstrument.userId, userInstrumentsList);
        }
        userInstrumentsList.add(bankInstrument);
        return mapBankInstrumentToInstrumentDO(bankInstrument);
    }

    public List<InstrumentDO> getInstrumentsByUserId(int userID) {
        List<Instrument> userInstrumentsList = userInstruments.get(userID);
        List<InstrumentDO> userInstrumentsFetched = new ArrayList<>();
        for (Instrument instrument : userInstrumentsList) {
            if (instrument.getInstrumentType() == InstrumentType.BANK)
                userInstrumentsFetched.add(mapBankInstrumentToInstrumentDO((BankInstrument) instrument));
        }
        return userInstrumentsFetched;
    }

    public InstrumentDO mapBankInstrumentToInstrumentDO(BankInstrument bankInstrument) {
        InstrumentDO instrumentDOObj = new InstrumentDO();
        instrumentDOObj.instrumentType = bankInstrument.instrumentType;
        instrumentDOObj.instrumentId = bankInstrument.instrumentId;
        instrumentDOObj.bankAccountNumber = bankInstrument.bankAccountNumber;
        instrumentDOObj.ifscCode = bankInstrument.ifscCode;
        instrumentDOObj.userId = bankInstrument.userId;
        return instrumentDOObj;
    }
}
