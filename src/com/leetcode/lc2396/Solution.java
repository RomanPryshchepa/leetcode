package com.leetcode.lc2396;

/*
2396. Strictly Palindromic Number

An integer n is strictly palindromic if, for every base b between 2 and n - 2 (inclusive), the string representation of the integer n in base b is palindromic.

Given an integer n, return true if n is strictly palindromic and false otherwise.

A string is palindromic if it reads the same forward and backward.



Example 1:

Input: n = 9
Output: false
Explanation: In base 2: 9 = 1001 (base 2), which is palindromic.
In base 3: 9 = 100 (base 3), which is not palindromic.
Therefore, 9 is not strictly palindromic so we return false.
Note that in bases 4, 5, 6, and 7, n = 9 is also not palindromic.

Example 2:

Input: n = 4
Output: false
Explanation: We only consider base 2: 4 = 100 (base 2), which is not palindromic.
Therefore, we return false.



Constraints:

    4 <= n <= 105
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.isStrictlyPalindromic(9));
    System.out.println(solution.isStrictlyPalindromic(4));
  }

  public boolean isStrictlyPalindromic(int n) {
    // The number n in base (n - 2) is always 12 -> not palindromic.
    return false;
  }
}
