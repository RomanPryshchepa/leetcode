package com.leetcode.lc2529;

/*
2529. Maximum Count of Positive Integer and Negative Integer

Given an array nums sorted in non-decreasing order, return the maximum between the number of positive integers and the number of negative integers.

    In other words, if the number of positive integers in nums is pos and the number of negative integers is neg, then return the maximum of pos and neg.

Note that 0 is neither positive nor negative.



Example 1:

Input: nums = [-2,-1,-1,1,2,3]
Output: 3
Explanation: There are 3 positive integers and 3 negative integers. The maximum count among them is 3.

Example 2:

Input: nums = [-3,-2,-1,0,0,1,2]
Output: 3
Explanation: There are 2 positive integers and 3 negative integers. The maximum count among them is 3.

Example 3:

Input: nums = [5,20,66,1314]
Output: 4
Explanation: There are 4 positive integers and 0 negative integers. The maximum count among them is 4.



Constraints:

    1 <= nums.length <= 2000
    -2000 <= nums[i] <= 2000
    nums is sorted in a non-decreasing order.



Follow up: Can you solve the problem in O(log(n)) time complexity?
 */
public class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.maximumCount(new int[] {-2,-1,-1,1,2,3}));
        System.out.println(solution.maximumCount(new int[] {-3,-2,-1,0,0,1,2}));
        System.out.println(solution.maximumCount(new int[] {5,20,66,1314}));
    }

    public int maximumCount(int[] nums) {
        if (nums[0] > 0 || nums[nums.length - 1] < 0)
            return nums.length;
        var start = 0;
        var end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] > -0.5)
                end = mid - 1;
            else
                start = mid + 1;
        }
        var negCount = end + 1;
        start = negCount;
        end = nums.length - 1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] > 0.5)
                end = mid - 1;
            else
                start = mid + 1;
        }
        var posCount = nums.length - end - 1;
        return Math.max(negCount, posCount);
    }
}
