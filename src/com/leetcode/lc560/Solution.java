package com.leetcode.lc560;

/*
560. Subarray Sum Equals K

Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.



Example 1:

Input: nums = [1,1,1], k = 2
Output: 2

Example 2:

Input: nums = [1,2,3], k = 3
Output: 2



Constraints:

    1 <= nums.length <= 2 * 104
    -1000 <= nums[i] <= 1000
    -107 <= k <= 107
 */
public class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.subarraySum(new int[]{1,1,1}, 2)); //2
        System.out.println(solution.subarraySum(new int[]{1,2,3}, 3)); //2
    }

    public int subarraySum(int[] nums, int k) {
        var result = 0;
        var sum = 0;
        for (var lp = 0; lp < nums.length; lp++) {
            for (int rp = lp; rp < nums.length; rp++) {
                sum += nums[rp];
                if (sum == k)
                    result++;
            }
            sum = 0;
        }
        return result;
    }
}

