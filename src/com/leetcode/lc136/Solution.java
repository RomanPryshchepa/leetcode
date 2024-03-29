package com.leetcode.lc136;

import java.util.HashSet;
import java.util.Set;

/*
136. Single Number

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.



Example 1:

Input: nums = [2,2,1]
Output: 1

Example 2:

Input: nums = [4,1,2,1,2]
Output: 4

Example 3:

Input: nums = [1]
Output: 1



Constraints:

    1 <= nums.length <= 3 * 104
    -3 * 104 <= nums[i] <= 3 * 104
    Each element in the array appears twice except for one element which appears only once.

 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums;

    nums = new int[]{2, 2, 1};
    System.out.println(solution.singleNumber(nums)); // 1

    nums = new int[]{4,1,2,1,2};
    System.out.println(solution.singleNumber(nums)); // 4

    nums = new int[]{1};
    System.out.println(solution.singleNumber(nums)); // 1
  }

  public int singleNumber(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    int sum = 0;
    Set<Integer> numsSet = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (numsSet.add(nums[i])) {
        sum += nums[i];
      } else {
        sum -= nums[i];
      }
    }
    return sum;
  }
}
