package com.phong.leetcode.problem.hard;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
@SpringBootTest
class RegularExpressionMatchingTest {

    @Autowired
    private RegularExpressionMatching regularExpressionMatching;

    @Test
    void isMatch() {
        regularExpressionMatching.setSequence("aa");
        regularExpressionMatching.setPattern("a");
        assertFalse(regularExpressionMatching.runWithLog());
    }

    @Test
    void isMatch2() {
        regularExpressionMatching.setSequence("aa");
        regularExpressionMatching.setPattern("a*");
        assertTrue(regularExpressionMatching.runWithLog());
    }

    @Test
    void isMatch3() {
        regularExpressionMatching.setSequence("ab");
        regularExpressionMatching.setPattern(".*");
        assertTrue(regularExpressionMatching.runWithLog());
    }
}
