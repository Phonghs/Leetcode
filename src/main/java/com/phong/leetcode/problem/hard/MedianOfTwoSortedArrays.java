package com.phong.leetcode.problem.hard;

import com.phong.leetcode.base.AbstractBaseClass;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

/**
 * LeetCode 4 - Median of Two Sorted Arrays
 * Difficulty: Hard
 *
 * Problem:
 * Given two sorted arrays nums1 and nums2 of size m and n respectively,
 * return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 *
 * Example 2:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 * Constraints:
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 */
@Setter
@Service
public class MedianOfTwoSortedArrays extends AbstractBaseClass<Double> {

    private int[] nums1;
    private int[] nums2;

    @Override
    protected Double run() {
        return findMedianSortedArrays(nums1, nums2);
    }

    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length) {
            return findMedianSortedArrays(arr2, arr1);
        }

        int len1 = arr1.length;
        int len2 = arr2.length;
        int low = 0;
        int high = len1;
        int halfLen = (len1 + len2 + 1) / 2;

        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = halfLen - cut1;

            int left1Max = (cut1 == 0) ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int right1Min = (cut1 == len1) ? Integer.MAX_VALUE : arr1[cut1];

            int left2Max = (cut2 == 0) ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int right2Min = (cut2 == len2) ? Integer.MAX_VALUE : arr2[cut2];

            if (left1Max <= right2Min && left2Max <= right1Min) {
                if ((len1 + len2) % 2 == 0) {
                    return (Math.max(left1Max, left2Max) + Math.min(right1Min, right2Min)) / 2.0;
                } else {
                    return Math.max(left1Max, left2Max);
                }
            } else if (left1Max > right2Min) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return Double.NaN;
    }
}
