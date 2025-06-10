package com.leetcode.lc1512;

import java.util.HashMap;

/*
1512. Number of Good Pairs

Given an array of integers nums, return the number of good pairs.

A pair (i, j) is called good if nums[i] == nums[j] and i < j.



Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.

Example 2:

Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.

Example 3:

Input: nums = [1,2,3]
Output: 0



Constraints:

    1 <= nums.length <= 100
    1 <= nums[i] <= 100
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.numIdenticalPairs(new int[]{1,2,3,1,1,3}));
    System.out.println(solution.numIdenticalPairs(new int[]{1,1,1,1}));
    System.out.println(solution.numIdenticalPairs(new int[]{1,2,3}));
  }

  public int numIdenticalPairs(int[] nums) {
    var map = new HashMap<Integer, Integer>();
    for (int num : nums) {
      if (!map.containsKey(num))
        map.put(num, 1);
      else
        map.put(num, map.get(num) + 1);
    }
    var res = 0;
    for (var key : map.keySet()) {
      if (map.get(key) > 1)
        res += map.get(key) * (map.get(key) - 1) / 2;
    }
    return res;
  }
}
