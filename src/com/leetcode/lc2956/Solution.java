package com.leetcode.lc2956;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
2956. Find Common Elements Between Two Arrays

You are given two integer arrays nums1 and nums2 of sizes n and m, respectively. Calculate the following values:

    answer1 : the number of indices i such that nums1[i] exists in nums2.
    answer2 : the number of indices i such that nums2[i] exists in nums1.

Return [answer1,answer2].



Example 1:

Input: nums1 = [2,3,2], nums2 = [1,2]

Output: [2,1]

Explanation:

Example 2:

Input: nums1 = [4,3,2,3,1], nums2 = [2,2,5,2,3,6]

Output: [3,4]

Explanation:

The elements at indices 1, 2, and 3 in nums1 exist in nums2 as well. So answer1 is 3.

The elements at indices 0, 1, 3, and 4 in nums2 exist in nums1. So answer2 is 4.

Example 3:

Input: nums1 = [3,4,2,3], nums2 = [1,5]

Output: [0,0]

Explanation:

No numbers are common between nums1 and nums2, so answer is [0,0].



Constraints:

    n == nums1.length
    m == nums2.length
    1 <= n, m <= 100
    1 <= nums1[i], nums2[i] <= 100
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(Arrays.toString(solution.findIntersectionValues(new int[]{2,3,2}, new int[]{1,2})));
    System.out.println(Arrays.toString(solution.findIntersectionValues(new int[]{4,3,2,3,1}, new int[]{2,2,5,2,3,6})));
    System.out.println(Arrays.toString(solution.findIntersectionValues(new int[]{3,4,2,3}, new int[]{1,5})));
  }

  public int[] findIntersectionValues(int[] nums1, int[] nums2) {
    var dict1 = GetElementsAndCount(nums1);
    var dict2 = GetElementsAndCount(nums2);
    var count1 = GetCount(dict2, dict1);
    var count2 = GetCount(dict1, dict2);
    return new int[] { count1, count2 };
  }

  private Map<Integer, Integer> GetElementsAndCount(int[] nums) {
    var dict = new HashMap<Integer, Integer>();
    for (var num : nums)
      if (dict.containsKey(num))
        dict.put(num, dict.get(num) + 1);
      else
        dict.put(num, 1);
    return dict;
  }

  private int GetCount(Map<Integer, Integer> dict1, Map<Integer, Integer> dict2) {
    var count = 0;
    for (var num : dict1.keySet())
      if (dict2.containsKey(num))
        count += dict2.get(num);
    return count;
  }
}
