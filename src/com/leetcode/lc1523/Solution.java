package com.leetcode.lc1523;

/*
1523. Count Odd Numbers in an Interval Range

Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).



Example 1:

Input: low = 3, high = 7
Output: 3
Explanation: The odd numbers between 3 and 7 are [3,5,7].

Example 2:

Input: low = 8, high = 10
Output: 1
Explanation: The odd numbers between 8 and 10 are [9].



Constraints:

    0 <= low <= high <= 10^9
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int low;
    int high;

    low = 3;
    high = 7;
    System.out.println(solution.countOdds(low, high)); // 3
    System.out.println(solution.countOdds2(low, high)); // 3

    low = 8;
    high = 10;
    System.out.println(solution.countOdds(low, high)); // 1
    System.out.println(solution.countOdds2(low, high)); // 1

    low = 8;
    high = 9;
    System.out.println(solution.countOdds(low, high)); // 1
    System.out.println(solution.countOdds2(low, high)); // 1

    low = 1;
    high = 1;
    System.out.println(solution.countOdds(low, high)); // 1
    System.out.println(solution.countOdds2(low, high)); // 1

    low = 2;
    high = 2;
    System.out.println(solution.countOdds(low, high)); // 0
    System.out.println(solution.countOdds2(low, high)); // 0
  }

  public int countOdds(int low, int high) {
    if (low % 2 == 1) {
      return 1 + (high - low) / 2;
    } else if (low == high) {
      return 0;
    } else {
      return 1 + (high - low - 1) / 2;
    }
  }

  public int countOdds2(int low, int high) {
    if (low % 2 == 1) {
      low--;
    } else if (low == high) {
      return 0;
    }
    return 1 + (high - low - 1) / 2;
  }
}
