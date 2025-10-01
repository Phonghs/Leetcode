package com.phong.leetcode.problem.medium;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SingleNumber2Test {
    @Autowired
    private SingleNumber2 singleNumber2;

    @Test
    public void test1() {
        int[] nums = new int[]{2,2,3,2};
        singleNumber2.setNums(nums);
        int result = singleNumber2.runWithLog();
        assertEquals(3, result);
    }

    @Test
    public void test2() {
        int[] nums = new int[]{0,1,0,1,0,1,99};
        singleNumber2.setNums(nums);
        int result = singleNumber2.runWithLog();
        assertEquals(99, result);
    }
}
