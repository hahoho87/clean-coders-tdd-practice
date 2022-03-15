package com.hahoho87.wordwrap;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WordWrapTest {

    @Test
    void should_wrap() {
        assertWraps(null, 1, "");
        assertWraps("", 1, "");
        assertWraps("x", 1, "x");
        assertWraps("xx", 1, "x\nx");
        assertWraps("xxx", 1, "x\nx\nx");
        assertWraps("x x", 1, "x\nx");
        assertWraps("x xx", 3, "x\nxx");
        assertWraps("four score and seven years ago our fathers brought forth upon this continent",
                7, "four\nscore\nand\nseven\nyears\nago our\nfathers\nbrought\nforth\nupon\nthis\ncontine\nnt");
    }

    private void assertWraps(String s, int length, String expected) {
        assertThat(wrap(s, length)).isEqualTo(expected);
    }

    private String wrap(String s, int length) {
        if (s == null)
            return "";
        if (s.length() > length) {
            int breakPoint = s.lastIndexOf(" ", length);
            if (breakPoint == -1) {
                breakPoint = length;
            }
            return s.substring(0, breakPoint) + "\n" + wrap(s.substring(breakPoint).trim(), length);
        } else {
            return s;
        }
    }
}
