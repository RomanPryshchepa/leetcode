package com.leetcode.lc209;

/*
209. Minimum Size Subarray Sum

Given an array of positive integers nums and a positive integer target, return the minimal length of a whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.



Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1

Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0



Constraints:

    1 <= target <= 109
    1 <= nums.length <= 105
    1 <= nums[i] <= 104


Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
 */
public class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(solution.minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(solution.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        var min = 0;
        var left = 0;
        var right = 0;
        var sum = 0;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= target) {
                min = min == 0 ? right - left : Math.min(min, right - left);
                sum -= nums[left++];
            }
        }
        return min;
    }
}
