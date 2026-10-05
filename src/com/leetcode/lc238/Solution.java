package com.leetcode.lc238;

import java.util.Arrays;

/*
238. Product of Array Except Self

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.



Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]



Constraints:

    2 <= nums.length <= 105
    -30 <= nums[i] <= 30
    The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.



Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */
public class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(solution.productExceptSelf2(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(solution.productExceptSelf3(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
        System.out.println(Arrays.toString(solution.productExceptSelf2(new int[]{-1, 1, 0, -3, 3})));
        System.out.println(Arrays.toString(solution.productExceptSelf3(new int[]{-1, 1, 0, -3, 3})));
    }

    public int[] productExceptSelf(int[] nums) {
        var prefSum = new int[nums.length + 1];
        var suffSum = new int[nums.length + 1];
        prefSum[0] = 1;
        suffSum[nums.length] = 1;
        for (var i = 0; i < nums.length; i++) {
            prefSum[i + 1] = prefSum[i] * nums[i];
            suffSum[nums.length - i - 1] = suffSum[nums.length - i] * nums[nums.length - i - 1];
        }
        var result = new int[nums.length];
        for (var i = 0; i < nums.length; i++)
            result[i] = prefSum[i] * suffSum[i + 1];
        return result;
    }

    public int[] productExceptSelf2(int[] nums) {
        int[] prefix = new int[nums.length];
        int prod = prefix[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prod *= nums[i-1];
            prefix[i] = prod;
        }

        int[] suffix = new int[nums.length];
        prod = suffix[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            prod *= nums[i + 1];
            suffix[i] = prod;
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = prefix[i] * suffix[i];
        }
        return res;
    }

    public int[] productExceptSelf3(int[] nums) {
        int[] result = new int[nums.length];
        int prod = result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            prod *= nums[i-1];
            result[i] = prod;
        }

        prod = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            prod *= nums[i + 1];
            result[i] *= prod;
        }

        return result;
    }
}
