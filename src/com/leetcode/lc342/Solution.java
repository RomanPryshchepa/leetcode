package com.leetcode.lc342;

/*
342. Power of Four

Given an integer n, return true if it is a power of four. Otherwise, return false.

An integer n is a power of four, if there exists an integer x such that n == 4x.



Example 1:

Input: n = 16
Output: true

Example 2:

Input: n = 5
Output: false

Example 3:

Input: n = 1
Output: true



Constraints:

    -231 <= n <= 231 - 1


Follow up: Could you solve it without loops/recursion?
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.isPowerOfFour(16)); // true
    System.out.println(solution.isPowerOfFour(5)); // false
    System.out.println(solution.isPowerOfFour(1)); // true
    System.out.println(solution.isPowerOfFour(0)); // false
    System.out.println(solution.isPowerOfFour(-16)); // false
    System.out.println(solution.isPowerOfFour(-1)); // false
    System.out.println(solution.isPowerOfFour(2)); // false
  }

  public boolean isPowerOfFour(int n) {
    return n != 0 && Math.pow(4, (int) (Math.log(n) / Math.log(4))) == n;
  }
}
