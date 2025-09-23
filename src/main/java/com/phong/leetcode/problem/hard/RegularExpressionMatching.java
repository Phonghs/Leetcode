package com.phong.leetcode.problem.hard;

import com.phong.leetcode.base.AbstractBaseClass;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

/**
 * LeetCode 10 - Regular Expression Matching
 * Difficulty: Hard
 *
 * Problem:
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 * - '.' Matches any single character.
 * - '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Example 1:
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 * Example 2:
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 *
 * Example 3:
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 *
 * Constraints:
 * 1 <= s.length <= 20
 * 1 <= p.length <= 20
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '.', and '*'.
 * It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 */

@Service
@Setter
public class RegularExpressionMatching extends AbstractBaseClass<Boolean> {

    private String sequence;
    private String pattern;

    public boolean isMatch(String text, String pattern) {
        Boolean[][] memo = new Boolean[text.length() + 1][pattern.length() + 1];
        return matchHelper(text, 0, pattern, 0, memo);
    }

    private boolean matchHelper(String text, int textIndex, String pattern, int patternIndex, Boolean[][] memo) {
        if (memo[textIndex][patternIndex] != null) {
            return memo[textIndex][patternIndex];
        }

        boolean result;
        if (patternIndex == pattern.length()) {
            result = (textIndex == text.length());
        } else {

            boolean currentCharMatch = (textIndex < text.length() &&
                    (text.charAt(textIndex) == pattern.charAt(patternIndex) || pattern.charAt(patternIndex) == '.'));

            if (patternIndex + 1 < pattern.length() && pattern.charAt(patternIndex + 1) == '*') {
                result = matchHelper(text, textIndex, pattern, patternIndex + 2, memo) ||
                        (currentCharMatch && matchHelper(text, textIndex + 1, pattern, patternIndex, memo));
            } else {
                result = currentCharMatch && matchHelper(text, textIndex + 1, pattern, patternIndex + 1, memo);
            }
        }

        memo[textIndex][patternIndex] = result;
        return result;
    }

    @Override
    protected Boolean run() {
        return isMatch(sequence, pattern);
    }
}
