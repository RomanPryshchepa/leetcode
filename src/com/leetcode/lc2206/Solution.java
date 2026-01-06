package com.leetcode.lc2206;

import java.util.Arrays;

/*
2206. Divide Array Into Equal Pairs

You are given an integer array nums consisting of 2 * n integers.

You need to divide nums into n pairs such that:

    Each element belongs to exactly one pair.
    The elements present in a pair are equal.

Return true if nums can be divided into n pairs, otherwise return false.



Example 1:

Input: nums = [3,2,3,2,2,2]
Output: true
Explanation:
There are 6 elements in nums, so they should be divided into 6 / 2 = 3 pairs.
If nums is divided into the pairs (2, 2), (3, 3), and (2, 2), it will satisfy all the conditions.

Example 2:

Input: nums = [1,2,3,4]
Output: false
Explanation:
There is no way to divide nums into 4 / 2 = 2 pairs such that the pairs satisfy every condition.



Constraints:

    nums.length == 2 * n
    1 <= n <= 500
    1 <= nums[i] <= 500
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divideArray(new int[] {3,2,3,2,2,2}));
        System.out.println(solution.divideArray2(new int[] {3,2,3,2,2,2}));
        System.out.println(solution.divideArray(new int[] {1,2,3,4}));
        System.out.println(solution.divideArray2(new int[] {1,2,3,4}));
    }

    public boolean divideArray(int[] nums) {
        Arrays.sort(nums);
        for (var i = 0; i < nums.length; i += 2)
            if (nums[i] != nums[i + 1])
                return false;
        return true;
    }

    public boolean divideArray2(int[] nums) {
        var arr = new int[501];
        for (var num : nums)
            arr[num]++;
        for (var num : arr)
            if (num % 2 != 0)
                return false;
        return true;
    }
}
