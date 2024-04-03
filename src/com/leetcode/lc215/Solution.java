package com.leetcode.lc215;

import java.util.Arrays;

/*
215. Kth Largest Element in an Array

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?



Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4



Constraints:

    1 <= k <= nums.length <= 105
    -104 <= nums[i] <= 104
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums;
    int k;

    nums = new int[]{3, 2, 1, 5, 6, 4};
    k = 2;
    System.out.println(solution.findKthLargest(nums, k)); // 5

    nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
    k = 4;
    System.out.println(solution.findKthLargest(nums, k)); // 4

    nums = new int[]{2, 1};
    k = 2;
    System.out.println(solution.findKthLargest(nums, k)); // 1
  }

  public int findKthLargestV1(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length - k];
  }

  public int findKthLargest(int[] nums, int k) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int num : nums) {
      if (num < min) {
        min = num;
      }
      if (num > max) {
        max = num;
      }
    }

    int[] counters = new int[max - min + 1];

    for (int num : nums) {
      counters[num - min]++;
    }

    int i = counters.length - 1;

    while (k > 0) {
      k -= counters[i--];
    }

    return min + i + 1;
  }
}
