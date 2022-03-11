package com.hahoho87.bowling;

public class Game {

    private final int[] rolls = new int[21];
    private int currentRoll = 0;

    public void role(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int getScore() {
        int score = 0;
        int firstFrame = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isSpare(firstFrame)) {
                score += 10 + nextBallForSpare(firstFrame);
                firstFrame += 2;
            } else if(isStrike(firstFrame)) {
                score += 10 + nextTwoBallsForStrike(firstFrame);
                firstFrame += 1;
            } else {
                score += nextBallsInFrame(firstFrame);
                firstFrame += 2;
            }
        }
        return score;

    }

    private int nextBallsInFrame(int firstFrame) {
        return rolls[firstFrame] + rolls[firstFrame + 1];
    }

    private int nextTwoBallsForStrike(int firstFrame) {
       return rolls[firstFrame + 1] + rolls[firstFrame + 2];
    }
    private int nextBallForSpare(int firstFrame) {
        return rolls[firstFrame + 2];
    }

    private boolean isStrike(int firstFrame) {
        return rolls[firstFrame] == 10;
    }

    private boolean isSpare(int firstFrame) {
        return rolls[firstFrame] + rolls[firstFrame + 1] == 10;
    }
}
