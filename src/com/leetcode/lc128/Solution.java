package com.leetcode.lc128;

import java.util.Arrays;

/*
128. Longest Consecutive Sequence

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.



Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9



Constraints:

    0 <= nums.length <= 105
    -109 <= nums[i] <= 109

 */
public class Solution {

  public static void main(String[] args) {
    int[] nums = new int[]{100, 4, 200, 1, 3, 2};
    System.out.println(longestConsecutive(nums));
    nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
    System.out.println(longestConsecutive(nums));
    nums = new int[]{1, 2, 0, 1};
    System.out.println(longestConsecutive(nums));

  }

  // 0 0 4 1 3 9 -> 2
  // 2 1 3 1 1 5 -> 3
  // 0 0 5 3 4 9 -> 3

  public static int longestConsecutive(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    Arrays.sort(nums);
    int res = 1;
    int cur = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] - nums[i - 1] == 1) {
        cur++;
      } else if (nums[i] - nums[i - 1] != 0) {
        if (cur > res) {
          res = cur;
        }
        cur = 1;
      }
    }
    if (cur > res) {
      res = cur;
    }
    return res;
  }
}
