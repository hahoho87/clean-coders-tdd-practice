package com.hahoho87.bowling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void canRoll() {
        game.role(0);
    }

    @Test
    void gutterGame() {
        manyRolls(20, 0);
        assertGameScore(0);
    }

    @Test
    void allOnes() {
        manyRolls(20, 1);
        assertGameScore(20);
    }

    @Test
    void oneSpare() {
        roleSpare();
        game.role(3);
        manyRolls(17, 0);
        assertGameScore(16);
    }

    @Test
    void oneStrike() {
        game.role(10);
        game.role(5);
        game.role(3);
        manyRolls(16, 0);
        assertGameScore(26);
    }

    @Test
    void perfectGame() {
        manyRolls(12, 10);
        assertGameScore(300);
    }

    private void roleSpare() {
        game.role(5);
        game.role(5);
    }

    private void assertGameScore(int expected) {
        assertThat(game.getScore()).isEqualTo(expected);
    }

    private void manyRolls(int rolls, int pins) {
        for (int i = 0; i < rolls; i++) {
            game.role(pins);
        }
    }
}
