package com.interviewQuestions.paymentGateway.instrument;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class InstrumentService {
    static Map<Integer, List<Instrument>> userInstruments = new HashMap<>();

    public abstract InstrumentDO addInstrument(InstrumentDO instrumentDo);

    public abstract List<InstrumentDO> getInstrumentsByUserId(int userId);

}
