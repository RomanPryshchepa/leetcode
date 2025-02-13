package com.leetcode.lc2389;

import java.util.Arrays;

/*
2389. Longest Subsequence With Limited Sum

You are given an integer array nums of length n, and an integer array queries of length m.

Return an array answer of length m where answer[i] is the maximum size of a subsequence that you can take from nums such that the sum of its elements is less than or equal to queries[i].

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.



Example 1:

Input: nums = [4,5,2,1], queries = [3,10,21]
Output: [2,3,4]
Explanation: We answer the queries as follows:
- The subsequence [2,1] has a sum less than or equal to 3. It can be proven that 2 is the maximum size of such a subsequence, so answer[0] = 2.
- The subsequence [4,5,1] has a sum less than or equal to 10. It can be proven that 3 is the maximum size of such a subsequence, so answer[1] = 3.
- The subsequence [4,5,2,1] has a sum less than or equal to 21. It can be proven that 4 is the maximum size of such a subsequence, so answer[2] = 4.

Example 2:

Input: nums = [2,3,4,5], queries = [1]
Output: [0]
Explanation: The empty subsequence is the only subsequence that has a sum less than or equal to 1, so answer[0] = 0.



Constraints:

    n == nums.length
    m == queries.length
    1 <= n, m <= 1000
    1 <= nums[i], queries[i] <= 106
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(
        Arrays.toString(solution.answerQueries(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21})));
    System.out.println(
        Arrays.toString(solution.answerQueries(new int[]{2, 3, 4, 5}, new int[]{1})));
  }

  public int[] answerQueries(int[] nums, int[] queries) {
    Arrays.sort(nums);
    var sums = new int[nums.length];
    sums[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      sums[i] = sums[i - 1] + nums[i];
    }
    var result = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      result[i] = binarySearch(sums, queries[i]) + 1;
    }
    return result;
  }

  private int binarySearch(int[] arr, int elem) {
    var start = 0;
    var end = arr.length - 1;
    var mid = 0;
    while (start <= end) {
      mid = (start + end) / 2;
      if (arr[mid] == elem) {
        return mid;
      }
      if (arr[mid] > elem) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return end;
  }
}
