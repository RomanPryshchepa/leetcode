package com.leetcode.lc704;

/*
704. Binary Search

Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1



Constraints:

    1 <= nums.length <= 104
    -104 < nums[i], target < 104
    All the integers in nums are unique.
    nums is sorted in ascending order.

 */
public class Solution {

  public static void main(String[] args) {
    int[] nums;
    int target;
    //Example 1:
    //
    //Input: nums = [-1,0,3,5,9,12], target = 9
    //Output: 4
    //Explanation: 9 exists in nums and its index is 4
    nums = new int[]{-1, 0, 3, 5, 9, 12};
    target = 9;
    System.out.println(search(nums, target));

    //Example 2:
    //
    //Input: nums = [-1,0,3,5,9,12], target = 2
    //Output: -1
    //Explanation: 2 does not exist in nums so return -1
    nums = new int[]{-1, 0, 3, 5, 9, 12};
    target = 2;
    System.out.println(search(nums, target));

    nums = new int[]{-50, -24, -15, -1, 0, 3, 5, 9, 12};
    target = -1;
    System.out.println(search(nums, target));

    nums = new int[]{5};
    target = 5;
    System.out.println(search(nums, target));

    nums = new int[]{2, 5};
    target = 2;
    System.out.println(search(nums, target));

    nums = new int[]{2, 5};
    target = 5;
    System.out.println(search(nums, target));
  }

  public static int search(int[] nums, int target) {
    int leftBorder = 0;
    int rightBorder = nums.length - 1;
    if (target == nums[leftBorder]) {
      return leftBorder;
    }
    if (target == nums[rightBorder]) {
      return rightBorder;
    }
    while (rightBorder - leftBorder > 1) {
      int i = leftBorder + (rightBorder - leftBorder) / 2;
      if (target == nums[i]) {
        return i;
      }
      if (target < nums[i]) {
        rightBorder = i;
      } else {
        leftBorder = i;
      }
    }
    return -1;
  }
}
