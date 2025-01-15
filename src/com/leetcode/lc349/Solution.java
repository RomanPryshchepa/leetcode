package com.leetcode.lc349;

import java.util.Arrays;
import java.util.HashSet;

/*
349. Intersection of Two Arrays
Solved
Easy
Topics
Companies

Given two integer arrays nums1 and nums2, return an array of their
intersection
. Each element in the result must be unique and you may return the result in any order.



Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.



Constraints:

    1 <= nums1.length, nums2.length <= 1000
    0 <= nums1[i], nums2[i] <= 1000
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(
        Arrays.toString(solution.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    System.out.println(
        Arrays.toString(solution.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
  }

  public int[] intersection(int[] nums1, int[] nums2) {
    var res = new HashSet<Integer>();
    var set = new HashSet<Integer>();
    for (int i = 0; i < nums1.length; i++) {
      set.add(nums1[i]);
    }
    for (int i = 0; i < nums2.length; i++) {
      if (set.contains(nums2[i])) {
        res.add(nums2[i]);
      }
    }
    var result = new int[res.size()];
    var i = 0;
    for (Integer number : res) {
      result[i++] = number;
    }
    return result;
  }
}
