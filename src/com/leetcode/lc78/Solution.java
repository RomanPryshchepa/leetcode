package com.leetcode.lc78;

import java.util.ArrayList;
import java.util.List;

/*
78. Subsets

Given an integer array nums of unique elements, return all possible

(the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:

Input: nums = [0]
Output: [[],[0]]



Constraints:

    1 <= nums.length <= 10
    -10 <= nums[i] <= 10
    All the numbers of nums are unique.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.subsets(new int[]{1, 2, 3}));
    System.out.println(solution.subsets(new int[]{0}));
  }

  public List<List<Integer>> subsets(int[] nums) {
    var n = (int)Math.pow(2, nums.length);
    var result = new ArrayList<List<Integer>>();
    for (int i = 0; i < n; i++) {
      var list = new ArrayList<Integer>();
      var bits = Integer.toBinaryString(i + n).toCharArray();
      for (int j = 1; j < bits.length; j++) {
        if (bits[j] == '1')
          list.add(nums[j - 1]);
      }
      result.add(list);
    }
    return result;
  }
}
