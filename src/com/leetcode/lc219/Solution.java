package com.leetcode.lc219;

import java.util.HashMap;
import java.util.Map;

/*
219. Contains Duplicate II

Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.



Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false



Constraints:

    1 <= nums.length <= 105
    -109 <= nums[i] <= 109
    0 <= k <= 105
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums;
    int k;

    nums = new int[]{1, 2, 3, 1};
    k = 3;
    System.out.println(solution.containsNearbyDuplicate(nums, k));

    nums = new int[]{1, 0, 1, 1};
    k = 1;
    System.out.println(solution.containsNearbyDuplicate(nums, k));

    nums = new int[]{1, 2, 3, 1, 2, 3};
    k = 2;
    System.out.println(solution.containsNearbyDuplicate(nums, k));
  }

  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        if (i - map.get(nums[i]) <= k) {
          return true;
        }
        map.put(nums[i], i);
      } else {
        map.put(nums[i], i);
      }
    }
    return false;
  }
}
