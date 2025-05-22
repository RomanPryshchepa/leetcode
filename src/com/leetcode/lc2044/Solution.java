package com.leetcode.lc2044;

import java.util.ArrayList;
import java.util.List;

/*
2044. Count Number of Maximum Bitwise-OR Subsets

Given an integer array nums, find the maximum possible bitwise OR of a subset of nums and return the number of different non-empty subsets with the maximum bitwise OR.

An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b. Two subsets are considered different if the indices of the elements chosen are different.

The bitwise OR of an array a is equal to a[0] OR a[1] OR ... OR a[a.length - 1] (0-indexed).



Example 1:

Input: nums = [3,1]
Output: 2
Explanation: The maximum possible bitwise OR of a subset is 3. There are 2 subsets with a bitwise OR of 3:
- [3]
- [3,1]

Example 2:

Input: nums = [2,2,2]
Output: 7
Explanation: All non-empty subsets of [2,2,2] have a bitwise OR of 2. There are 23 - 1 = 7 total subsets.

Example 3:

Input: nums = [3,2,1,5]
Output: 6
Explanation: The maximum possible bitwise OR of a subset is 7. There are 6 subsets with a bitwise OR of 7:
- [3,5]
- [3,1,5]
- [3,2,5]
- [3,2,1,5]
- [2,5]
- [2,1,5]



Constraints:

    1 <= nums.length <= 16
    1 <= nums[i] <= 105
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.countMaxOrSubsets(new int[]{3,1}));
    System.out.println(solution.countMaxOrSubsets(new int[]{2,2,2}));
    System.out.println(solution.countMaxOrSubsets(new int[]{3,2,1,5}));
  }

  public int countMaxOrSubsets(int[] nums) {
    var res = 0;
    var maxBitwiseOR = 0;
    for (int num : nums) {
      maxBitwiseOR = maxBitwiseOR | num;
    }

    var allSubsets = getAllSubsets(nums);
    for (var subset : allSubsets) {
      var bitwiseOR = 0;
      for (Integer i : subset) {
        bitwiseOR = bitwiseOR | i;
      }
      if (bitwiseOR == maxBitwiseOR)
        res++;
    }
    return res;
  }

  private List<List<Integer>> getAllSubsets(int[] arr) {
    List<List<Integer>> res = new ArrayList<>();
    var n = (int)Math.pow(2, arr.length);
    for (int i = 1; i < n; i++) {
      var binaryString = Integer.toBinaryString(i);
      var flags = ("0".repeat(arr.length - binaryString.length()) + binaryString).toCharArray();
      var list = new ArrayList<Integer>();
      for (int j = 0; j < arr.length; j++) {
        if (flags[j] == '1')
          list.add(arr[j]);
      }
      res.add(list);
    }
    return res;
  }
}
