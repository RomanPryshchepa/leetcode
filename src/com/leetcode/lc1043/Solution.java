package com.leetcode.lc1043;

/*
1043. Partition Array for Maximum Sum

Given an integer array arr, partition the array into (contiguous) subarrays of length at most k. After partitioning, each subarray has their values changed to become the maximum value of that subarray.

Return the largest sum of the given array after partitioning. Test cases are generated so that the answer fits in a 32-bit integer.



Example 1:

Input: arr = [1,15,7,9,2,5,10], k = 3
Output: 84
Explanation: arr becomes [15,15,15,9,10,10,10]

Example 2:

Input: arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
Output: 83

Example 3:

Input: arr = [1], k = 1
Output: 1



Constraints:

    1 <= arr.length <= 500
    0 <= arr[i] <= 109
    1 <= k <= arr.length
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3));
    System.out.println(solution.maxSumAfterPartitioning(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4));
    System.out.println(solution.maxSumAfterPartitioning(new int[]{1}, 1));
  }

  public int maxSumAfterPartitioning(int[] arr, int k) {
    var partitionMaxSums = new int[arr.length + 1];
    for (int i = 1; i <= arr.length; i++) {
      int max = Integer.MIN_VALUE;
      for (int j = i; j > Math.max(0, i - k); j--) {
        max = Math.max(max, arr[j - 1]);
        partitionMaxSums[i] = Math.max(partitionMaxSums[i], max * (i - j + 1) + partitionMaxSums[j - 1]);
      }
    }
    return partitionMaxSums[arr.length];
  }
}
