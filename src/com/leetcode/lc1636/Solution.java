package com.leetcode.lc1636;

import java.util.Arrays;

/*
1636. Sort Array by Increasing Frequency

Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.

Return the sorted array.



Example 1:

Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.

Example 2:

Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.

Example 3:

Input: nums = [-1,1,-6,4,5,-6,1,4,1]
Output: [5,-1,4,4,-6,-6,1,1,1]



Constraints:

    1 <= nums.length <= 100
    -100 <= nums[i] <= 100
 */
public class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(Arrays.toString(solution.frequencySort(new int[]{1,1,2,2,2,3})));
        System.out.println(Arrays.toString(solution.frequencySort(new int[]{2,3,1,3,2})));
        System.out.println(Arrays.toString(solution.frequencySort(new int[]{-1,1,-6,4,5,-6,1,4,1})));
    }

    public int[] frequencySort(int[] nums) {
        var cnt = new int[201];
        for (var num : nums)
            cnt[num + 100]++;
        var allCnt = 0;
        for (int k : cnt)
            if (k > 0)
                allCnt++;
        var pairs = new int[allCnt][2];
        var p = 0;
        for (var i = 0; i < cnt.length; i++) {
            if (cnt[i] > 0) {
                pairs[p][0] = i - 100;
                pairs[p][1] = cnt[i];
                p++;
            }
        }
        Arrays.sort(pairs, (a, b) -> a[1] - b[1] != 0 ? a[1] - b[1] : b[0] - a[0]);
        var result = new int[nums.length];
        p = 0;
        for (int[] pair : pairs)
            for (var j = 0; j < pair[1]; j++)
                result[p++] = pair[0];
        return result;
    }
}
