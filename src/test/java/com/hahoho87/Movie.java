package com.hahoho87;

public class Movie {

    private int countOfRate = 0;
    private int sumOfRate = 0;

    public Integer averageRating() {
        return this.countOfRate == 0 ? 0 : sumOfRate / countOfRate;
    }

    public void rate(int rate) {
        this.sumOfRate += rate;
        countOfRate++;
    }
}
