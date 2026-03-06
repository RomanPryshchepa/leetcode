package com.leetcode.lc189;

import java.util.Arrays;

/*
189. Rotate Array

Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.



Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]



Constraints:

    1 <= nums.length <= 105
    -231 <= nums[i] <= 231 - 1
    0 <= k <= 105



Follow up:

    Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
    Could you do it in-place with O(1) extra space?
 */
public class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        int[] arr;

        arr = new int[] {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(arr, 3);
        System.out.println(Arrays.toString(arr));

        arr = new int[] {-1, -100, 3, 99};
        solution.rotate(arr, 2);
        System.out.println(Arrays.toString(arr));
    }

    public void rotate(int[] nums, int k) {
        if (k % nums.length == 0)
            return;
        if (k > nums.length)
            k = k % nums.length;
        var tmp = new int[nums.length];
        System.arraycopy(nums, 0, tmp, 0, nums.length);
        if (nums.length - k >= 0)
            System.arraycopy(tmp, 0, nums, k, nums.length - k);
        if (k >= 0)
            System.arraycopy(tmp, nums.length - k, nums, 0, k);
    }
}
