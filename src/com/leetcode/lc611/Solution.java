package com.leetcode.lc611;

import java.util.Arrays;

/*
611. Valid Triangle Number

Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.



Example 1:

Input: nums = [2,2,3,4]
Output: 3
Explanation: Valid combinations are:
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3

Example 2:

Input: nums = [4,2,3,4]
Output: 4



Constraints:

    1 <= nums.length <= 1000
    0 <= nums[i] <= 1000
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.triangleNumber(new int[]{2, 2, 3, 4})); // 3
    System.out.println(solution.triangleNumber(new int[]{4, 2, 3, 4})); // 4
    System.out.println(solution.triangleNumber(new int[]{})); // 0
    System.out.println(solution.triangleNumber(new int[]{2})); // 0
    System.out.println(solution.triangleNumber(new int[]{2, 2})); // 0
    System.out.println(solution.triangleNumber(new int[]{2, 5, 4, 1, 3, 6})); // 7
    System.out.println(solution.triangleNumber(
        new int[]{181, 57, 142, 163, 162, 194, 15, 63, 12, 17, 83, 76, 124, 164, 21, 170, 127, 31,
            183, 93, 99, 191, 42, 199, 121, 119, 29, 101, 125, 113})); // 2062
  }

  public int triangleNumber(int[] nums) {
    if (nums.length < 3) {
      return 0;
    }
    var count = 0;
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
      var a = nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        var b = nums[j];
        for (int k = j + 1; k < nums.length; k++) {
          var c = nums[k];
          if (i != j && i != k && j != k && a + b > c && a + c > b && b + c > a) {
            count++;
          } else {
            break;
          }
        }
      }
    }
    return count;
  }
}