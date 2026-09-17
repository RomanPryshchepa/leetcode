package com.leetcode.lc75;

import java.util.Arrays;

/*
75. Sort Colors

You are given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.



Example 1:

Input: nums = [2,0,2,1,1,0]

Output: [0,0,1,1,2,2]

Explanation:

The array has two 0s, two 1s, and two 2s. Sorting them in-place places all 0s first, then all 1s, then all 2s.

Example 2:

Input: nums = [2,0,1]

Output: [0,1,2]

Explanation:

The array has one each of 0, 1, and 2, arranged in-place in the order 0, 1, 2.



Constraints:

    n == nums.length
    1 <= n <= 300
    nums[i] is either 0, 1, or 2.



Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */
public class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        var nums = new int[] {2,0,2,1,1,0};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[] {2,0,1};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        var colorCnt = new int[3];
        for (var num : nums)
            colorCnt[num]++;
        var i = 0;
        for (var k = 0; k < colorCnt.length; k++)
            for (var j = 0; j < colorCnt[k]; j++)
                nums[i++] = k;
    }
}
