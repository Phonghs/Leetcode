package com.phong.leetcode.problem.medium;

import com.phong.leetcode.base.AbstractBaseClass;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
 * <p>
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 */
@Service
@Setter
public class SingleNumber2 extends AbstractBaseClass<Integer> {
    private int[] nums;

    @Override
    protected Integer run() {
        return singleNumber(nums);
    }

    public int singleNumber(int[] nums) {
        int result = 0;
        int temp = 0;
        for (int num : nums) {
            result ^= num & ~temp;
            temp ^= num & ~result;
        }
        return result;
    }
}
