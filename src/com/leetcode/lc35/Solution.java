package com.leetcode.lc35;

/*
35. Search Insert Position

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4



Constraints:

    1 <= nums.length <= 104
    -104 <= nums[i] <= 104
    nums contains distinct values sorted in ascending order.
    -104 <= target <= 104
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums;
    int target;

    nums = new int[]{1, 3, 5, 6};
    target = 5;
    System.out.println(solution.searchInsert(nums, target)); // 2

    System.out.println("======================");

    nums = new int[]{1, 3, 5, 6};
    target = 2;
    System.out.println(solution.searchInsert(nums, target)); // 1

    System.out.println("======================");

    nums = new int[]{1, 3, 5, 6};
    target = 7;
    System.out.println(solution.searchInsert(nums, target)); // 4

    System.out.println("======================");
    System.out.println("======================");

    nums = new int[]{1, 3, 5, 6};
    target = 0;
    System.out.println(solution.searchInsert(nums, target)); // 0

    System.out.println("======================");

    nums = new int[]{1, 3, 4, 5, 6};
    target = 2;
    System.out.println(solution.searchInsert(nums, target)); // 1

    System.out.println("======================");

    nums = new int[]{1};
    target = 0;
    System.out.println(solution.searchInsert(nums, target)); // 0

    System.out.println("======================");

    nums = new int[]{1, 3};
    target = 1;
    System.out.println(solution.searchInsert(nums, target)); // 0

    System.out.println("======================");

    nums = new int[]{1, 3, 5, 7, 9};
    target = 6; //6
    System.out.println(solution.searchInsert(nums, target)); // 0
  }

  public int searchInsert(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return start;
  }

  public int searchInsertOld(int[] nums, int target) {
    if (target < nums[0]) {
      return 0;
    }
    if (target > nums[nums.length - 1]) {
      return nums.length;
    }

    int beginIdx = 0;
    int endIdx = nums.length;
    do {
      if (nums[beginIdx] == target) {
        return beginIdx;
      }
      if (nums[endIdx - 1] == target) {
        return endIdx - 1;
      }
      int midIdx = beginIdx + (endIdx - beginIdx) / 2;
      if (nums[midIdx] == target) {
        return midIdx;
      }

      if (nums[midIdx] > target) {
        endIdx = midIdx;
      } else {
        beginIdx = midIdx;
      }
    } while (endIdx - beginIdx != 1 && endIdx != beginIdx);
    return endIdx;
  }
}
