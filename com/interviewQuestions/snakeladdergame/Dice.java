package com.interviewQuestions.snakeladdergame;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int diceCount;

    int minValue;
    int maxValue;

    public Dice(int diceCount, int minValue, int maxValue) {
        this.diceCount = diceCount;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public int rollDice() {
        int totalSum = 0;
        int diceUsed = 0;

        while (diceUsed < diceCount) {

            totalSum += ThreadLocalRandom.current().nextInt(minValue, maxValue + 1);
            diceUsed++;
        }

        return totalSum;
    }
}
