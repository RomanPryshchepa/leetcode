package com.leetcode.lc1588;

import java.util.HashMap;

/*
1588. Sum of All Odd Length Subarrays

Given an array of positive integers arr, return the sum of all possible odd-length subarrays of arr.

A subarray is a contiguous subsequence of the array.



Example 1:

Input: arr = [1,4,2,5,3]
Output: 58
Explanation: The odd-length subarrays of arr and their sums are:
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[1,4,2,5,3] = 15
If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58

Example 2:

Input: arr = [1,2]
Output: 3
Explanation: There are only 2 subarrays of odd length, [1] and [2]. Their sum is 3.

Example 3:

Input: arr = [10,11,12]
Output: 66



Constraints:

    1 <= arr.length <= 100
    1 <= arr[i] <= 1000



Follow up:

Could you solve this problem in O(n) time complexity?
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.sumOddLengthSubarrays(new int[]{1,4,2,5,3}));     // 58
    System.out.println(solution.sumOddLengthSubarrays(new int[]{1,2}));           // 3
    System.out.println(solution.sumOddLengthSubarrays(new int[]{10,11,12}));      // 66
    System.out.println(solution.sumOddLengthSubarrays(new int[]{1,4,2,5,3,6,7})); // 172
    System.out.println(solution.sumOddLengthSubarrays(new int[]{15,41,22,56,39,67,74,14,54,63,47,85,21,38,96})); // 17090
    System.out.println(solution.sumOddLengthSubarrays2(new int[]{15,41,22,56,39,67,74,14,54,63,47,85,21,38,96})); // 17090
    System.out.println(solution.sumOddLengthSubarrays(new int[]{15})); // 15
    System.out.println(solution.sumOddLengthSubarrays2(new int[]{15})); // 15
  }

  public int sumOddLengthSubarrays(int[] arr) {
    var sum = 0;
    var d = (arr.length + 1) / 2;
    var count = d;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i] * count;
      if (arr.length % 2 == 0) d--;
      else if (i % 2 == 0) d -= 2;
      count += d;
    }
    return sum;
  }

  public int sumOddLengthSubarrays2(int[] arr) {
    var oddLens = arr.length % 2 == 0 ? arr.length - 1 : arr.length; // 5
    var sum = 0;
    for (int oddLen = 1; oddLen <= oddLens; oddLen += 2) { // 1, 3, 5
      for (int k = 0; k <= arr.length - oddLen; k++) { // 0,1,2,3,4
        for (int i = k; i < k + oddLen; i++) {
          sum += arr[i];
        }
      }
    }
    return sum;
  }

  public void elemsOddLengthSubarrays(int len) {
    var oddLens = len % 2 == 0 ? len - 1 : len; // 5
    var result = new HashMap<Integer, Integer>();
    for (int oddLen = 1; oddLen <= oddLens; oddLen += 2) { // 1, 3, 5
      for (int k = 0; k <= len - oddLen; k++) { // 0,1,2,3,4
        for (int i = k; i < k + oddLen; i++) {
          if (result.containsKey(i)) result.put(i, result.get(i) + 1);
          else result.put(i, 1);
        }
      }
    }
    result.forEach((k, v) -> System.out.print(v + " "));
    System.out.println();
  }
}
