package com.leetcode.lc169;

import java.util.Arrays;
import java.util.HashMap;

/*
169. Majority Element

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3

Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2



Constraints:

    n == nums.length
    1 <= n <= 5 * 104
    -109 <= nums[i] <= 109


Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.majorityElement(new int[]{3, 2, 3}));
    System.out.println(solution.majorityElement2(new int[]{3, 2, 3}));
    System.out.println(solution.majorityElement3(new int[]{3, 2, 3}));
    System.out.println(solution.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    System.out.println(solution.majorityElement2(new int[]{2, 2, 1, 1, 1, 2, 2}));
    System.out.println(solution.majorityElement3(new int[]{2, 2, 1, 1, 1, 2, 2}));
  }

  public int majorityElement(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2];
  }

  public int majorityElement2(int[] nums) {
    var maxCnt = 0;
    var map = new HashMap<Integer, Integer>();
    for (var num : nums) {
      if (map.containsKey(num))
        map.put(num, map.get(num) + 1);
      else
        map.put(num, 1);
      if (map.get(num) > maxCnt)
        maxCnt = map.get(num);
      if (maxCnt > nums.length / 2)
        return num;
    }
    return 0;
  }

  public int majorityElement3(int[] nums) {
    var elem = nums[0];
    var count = 1;
    for (var i = 1; i < nums.length; i++) {
      if (nums[i] == elem)
        count++;
      else if (count > 0)
        count--;
      else
        elem = nums[i];
    }
    return elem;
  }
}
