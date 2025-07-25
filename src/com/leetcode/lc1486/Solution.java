package com.leetcode.lc1486;

/*
1486. XOR Operation in an Array

You are given an integer n and an integer start.

Define an array nums where nums[i] = start + 2 * i (0-indexed) and n == nums.length.

Return the bitwise XOR of all elements of nums.



Example 1:

Input: n = 5, start = 0
Output: 8
Explanation: Array nums is equal to [0, 2, 4, 6, 8] where (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8.
Where "^" corresponds to bitwise XOR operator.

Example 2:

Input: n = 4, start = 3
Output: 8
Explanation: Array nums is equal to [3, 5, 7, 9] where (3 ^ 5 ^ 7 ^ 9) = 8.



Constraints:

    1 <= n <= 1000
    0 <= start <= 1000
    n == nums.length
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.xorOperation(5, 0));
    System.out.println(solution.xorOperation(4, 3));
  }

  public int xorOperation(int n, int start) {
    var result = start;
    for (int i = 1; i < n; i++)
      result ^= start + 2 * i;
    return result;
  }
}
