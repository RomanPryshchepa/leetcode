package com.leetcode.lc896;

/*
896. Monotonic Array

An array is monotonic if it is either monotone increasing or monotone decreasing.

An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].

Given an integer array nums, return true if the given array is monotonic, or false otherwise.



Example 1:

Input: nums = [1,2,2,3]
Output: true

Example 2:

Input: nums = [6,5,4,4]
Output: true

Example 3:

Input: nums = [1,3,2]
Output: false



Constraints:

    1 <= nums.length <= 105
    -105 <= nums[i] <= 105
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums;

    nums = new int[]{1, 2, 2, 3};
    System.out.println(solution.isMonotonic(nums)); // true

    nums = new int[]{6, 5, 4, 4};
    System.out.println(solution.isMonotonic(nums)); // true

    nums = new int[]{1, 3, 2};
    System.out.println(solution.isMonotonic(nums)); // false
  }

  public boolean isMonotonic(int[] nums) {
    if (nums.length == 1) {
      return true;
    }
    int compare = Integer.compare(nums[0], nums[1]);
    for (int i = 1; i < nums.length; i++) {
      if((compare > 0 && nums[i - 1] < nums[i]) || (compare < 0 && nums[i - 1] > nums[i])) {
        return false;
      }
      if (nums[i] != nums[i - 1]) {
        compare = Integer.compare(nums[i-1], nums[i]);
      }
    }
    return true;
  }
}
