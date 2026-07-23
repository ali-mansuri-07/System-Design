package com.interviewQuestions.atm.processors;

public interface CashWithdrawalProcessor {
    void setNext(CashWithdrawalProcessor next);
    void withdraw(int amount);
}
