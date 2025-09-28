package com.phong.leetcode.problem.hard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class MedianOfTwoSortedArraysTest {

    @Autowired
    private MedianOfTwoSortedArrays medianService;

    @Test
    public void testFindMedianSortedArraysExample1() {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        medianService.setNums1(nums1);
        medianService.setNums2(nums2);
        double result = medianService.runWithLog();
        assertEquals(2.0, result);
    }

    @Test
    public void testFindMedianSortedArraysExample2() {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        medianService.setNums1(nums1);
        medianService.setNums2(nums2);
        double result = medianService.runWithLog();
        assertEquals(2.5, result);
    }
}
