package com.leetcode.lc540;

/*
540. Single Element in a Sorted Array

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.



Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2

Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10



Constraints:

    1 <= nums.length <= 105
    0 <= nums[i] <= 105
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8})); //2
    System.out.println(solution.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11})); //10
    System.out.println(solution.singleNonDuplicate(new int[]{3, 3, 7, 9, 9})); //7
    System.out.println(solution.singleNonDuplicate(new int[]{3, 3, 7, 7, 9})); //9
    System.out.println(solution.singleNonDuplicate(new int[]{3, 7, 7, 9, 9})); //3
    System.out.println(solution.singleNonDuplicate(new int[]{3, 3, 7})); //7
    System.out.println(solution.singleNonDuplicate(new int[]{3, 7, 7})); //3
    System.out.println(solution.singleNonDuplicate(new int[]{3})); //3
  }

  public int singleNonDuplicate(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    var start = 0;
    var end = nums.length - 1;
    var mid = 0;
    while (start <= end) {
      mid = start + (end - start) / 2;
      if (mid == 0 && nums[mid] != nums[mid + 1]
          || mid == nums.length - 1 && nums[mid] != nums[mid - 1]
          || nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
        return nums[mid];
      }
      if ((mid % 2 == 0 && nums[mid] == nums[mid - 1])
          || (mid % 2 == 1 && nums[mid] == nums[mid + 1])) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return nums[mid];
  }

  public int singleNonDuplicate1(int[] nums) {
    var result = 0;
    for (int num : nums) {
      result ^= num;
    }
    return result;
  }
}
