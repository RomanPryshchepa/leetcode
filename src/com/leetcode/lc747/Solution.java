package com.leetcode.lc747;

/*
747. Largest Number At Least Twice of Others

You are given an integer array nums where the largest integer is unique.

Determine whether the largest element in the array is at least twice as much as every other number in the array. If it is, return the index of the largest element, or return -1 otherwise.



Example 1:

Input: nums = [3,6,1,0]
Output: 1
Explanation: 6 is the largest integer.
For every other number in the array x, 6 is at least twice as big as x.
The index of value 6 is 1, so we return 1.

Example 2:

Input: nums = [1,2,3,4]
Output: -1
Explanation: 4 is less than twice the value of 3, so we return -1.



Constraints:

    2 <= nums.length <= 50
    0 <= nums[i] <= 100
    The largest element in nums is unique.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.dominantIndex(new int[] {3,6,1,0})); // 1
    System.out.println(solution.dominantIndex(new int[] {3,3,6,1,0})); // 2
    System.out.println(solution.dominantIndex(new int[] {1,2})); // 1
    System.out.println(solution.dominantIndex(new int[] {3,2})); // -1
    System.out.println(solution.dominantIndex(new int[] {2,3})); // -1
    System.out.println(solution.dominantIndex(new int[] {1,1})); // -1
  }

  public int dominantIndex(int[] nums) {
    var maxIdx = nums[0] > nums[1] ? 0 : 1;
    var max = nums[maxIdx];
    var prevMax = Math.min(nums[0], nums[1]);
    for (int i = 2; i < nums.length; i++) {
      if (nums[i] > max) {
        prevMax = max;
        max = nums[i];
        maxIdx = i;
      } else if (nums[i] > prevMax) {
        prevMax = nums[i];
      }
    }
    if (prevMax * 2 <= max) {
      return maxIdx;
    }
    return -1;
  }
}
