package com.leetcode.lc2367;

import java.util.HashSet;

/*
2367. Number of Arithmetic Triplets

You are given a 0-indexed, strictly increasing integer array nums and a positive integer diff. A triplet (i, j, k) is an arithmetic triplet if the following conditions are met:

    i < j < k,
    nums[j] - nums[i] == diff, and
    nums[k] - nums[j] == diff.

Return the number of unique arithmetic triplets.



Example 1:

Input: nums = [0,1,4,6,7,10], diff = 3
Output: 2
Explanation:
(1, 2, 4) is an arithmetic triplet because both 7 - 4 == 3 and 4 - 1 == 3.
(2, 4, 5) is an arithmetic triplet because both 10 - 7 == 3 and 7 - 4 == 3.

Example 2:

Input: nums = [4,5,6,7,8,9], diff = 2
Output: 2
Explanation:
(0, 2, 4) is an arithmetic triplet because both 8 - 6 == 2 and 6 - 4 == 2.
(1, 3, 5) is an arithmetic triplet because both 9 - 7 == 2 and 7 - 5 == 2.



Constraints:

    3 <= nums.length <= 200
    0 <= nums[i] <= 200
    1 <= diff <= 50
    nums is strictly increasing.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.arithmeticTriplets(new int[]{0, 1, 4, 6, 7, 10}, 3));
    System.out.println(solution.arithmeticTriplets(new int[]{4, 5, 6, 7, 8, 9}, 2));
  }

  public int arithmeticTriplets(int[] nums, int diff) {
    var result = 0;
    var set = new HashSet<Integer>();
    for (int num : nums) {
      set.add(num);
    }
    for (int i = 0; i < nums.length - 2; i++) {
      if (set.contains(nums[i] + diff) && set.contains(nums[i] + diff + diff)) {
        result++;
      }
    }
    return result;
  }
}
