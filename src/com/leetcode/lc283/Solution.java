package com.leetcode.lc283;

import java.util.Arrays;

/*
283. Move Zeroes

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.



Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:

Input: nums = [0]
Output: [0]



Constraints:

    1 <= nums.length <= 104
    -231 <= nums[i] <= 231 - 1


Follow up: Could you minimize the total number of operations done?
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums;

    nums = new int[]{0, 1, 0, 3, 12};
    solution.moveZeroes(nums);
    System.out.println(Arrays.toString(nums)); // 1, 3, 12, 0, 0

    nums = new int[]{0};
    solution.moveZeroes(nums);
    System.out.println(Arrays.toString(nums)); // 0

    nums = new int[]{4, 0, 7, 2, 0, 1, 0, 3, 12};
    solution.moveZeroes(nums);
    System.out.println(Arrays.toString(nums)); // 4, 7, 2, 1, 3, 12, 0, 0, 0

    nums = new int[]{0, 0, 0};
    solution.moveZeroes(nums);
    System.out.println(Arrays.toString(nums)); // 0, 0, 0

    nums = new int[]{0, 0, 1};
    solution.moveZeroes(nums);
    System.out.println(Arrays.toString(nums)); // 1, 0, 0

    nums = new int[]{0, 0, 1, 0};
    solution.moveZeroes(nums);
    System.out.println(Arrays.toString(nums)); // 1, 0, 0, 0

    nums = new int[]{0, 0, 1, 2, 0};
    solution.moveZeroes(nums);
    System.out.println(Arrays.toString(nums)); // 1, 2, 0, 0, 0

    nums = new int[]{1, 0, 3, 0, 1, 0, 2, 0, 4};
    solution.moveZeroes(nums);
    System.out.println(Arrays.toString(nums)); // 1, 3, 1, 2, 4, 0, 0, 0, 0
  }

  public void moveZeroes(int[] nums) {
    if (nums.length < 2) {
      return;
    }

    int j = nums.length - 1;
    while (j >= 0 && nums[j] == 0) {
      j--;
    }

    int i = 0;
    while (i <= j) {
      if (nums[i] == 0) {
        int k = i;
        while (k < j) {
          nums[k] = nums[k + 1];
          k++;
        }
        nums[k] = 0;
        j--;
        i--;
      }
      i++;
    }
  }

}
