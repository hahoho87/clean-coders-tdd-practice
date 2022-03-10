package com.hahoho87;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MovieTest {

    private Movie movie;

    @BeforeEach
    void init() {
        movie = new Movie();
    }
    @Test
    void foo() {
    }

    @Test
    void canCreateMovieInstance() {
        new Movie();
    }

    @Test
    @DisplayName("한번도 rate 되지 않으면 average 0 리턴")
    void should_return_0_when_no_rating() {
        assertThat(movie.averageRating()).isEqualTo(0);
    }

    @Test
    @DisplayName("한번 rate 되면 average 는 rate 값 리턴")
    void should_return_rate_when_one_rating() {
        movie.rate(1);
        assertThat(movie.averageRating()).isEqualTo(1);
    }

    @Test
    @DisplayName("두번 rate 되면 average 는 rate 값의 평균 리턴")
    void should_return_average_when_two_rating() {
        movie.rate(1);
        movie.rate(3);
        assertThat(movie.averageRating()).isEqualTo(2);
    }

}
