package com.leetcode.lc912;

import java.util.Arrays;

/*
912. Sort an Array

Given an array of integers nums, sort the array in ascending order and return it.
You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.
Example 1:
Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
Example 2:
Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
Explanation: Note that the values of nums are not necessairly unique.
Constraints:
    1 <= nums.length <= 5 * 104
    -5 * 104 <= nums[i] <= 5 * 104
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums;

    nums = new int[]{5, 2, 3, 1};
    System.out.println(Arrays.toString(solution.sortArray(nums))); // 1,2,3,5

    nums = new int[]{5, 1, 1, 2, 0, 0};
    System.out.println(Arrays.toString(solution.sortArray(nums))); // 0,0,1,1,2,5
  }


  public int[] sortArray(int[] nums) {
    if (nums.length <= 1) {
      return nums;
    }
    int[] left = Arrays.copyOfRange(nums, 0, nums.length / 2);
    int[] right = Arrays.copyOfRange(nums, nums.length / 2, nums.length);

    merge(sortArray(left), sortArray(right), nums);
    return nums;
  }

  private void merge(int[] left, int[] right, int[] res) {
    int leftIdx = 0;
    int rightIdx = 0;
    int idx = 0;
    while (leftIdx < left.length && rightIdx < right.length) {
      if (left[leftIdx] < right[rightIdx]) {
        res[idx++] = left[leftIdx++];
      } else {
        res[idx++] = right[rightIdx++];
      }
    }
    while (leftIdx < left.length) {
      res[idx++] = left[leftIdx++];
    }
    while (rightIdx < right.length) {
      res[idx++] = right[rightIdx++];
    }
  }
}
