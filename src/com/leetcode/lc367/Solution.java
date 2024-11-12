package com.leetcode.lc367;

/*
367. Valid Perfect Square

Given a positive integer num, return true if num is a perfect square or false otherwise.

A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer with itself.

You must not use any built-in library function, such as sqrt.



Example 1:

Input: num = 16
Output: true
Explanation: We return true because 4 * 4 = 16 and 4 is an integer.

Example 2:

Input: num = 14
Output: false
Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer.



Constraints:

    1 <= num <= 231 - 1
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.isPerfectSquare(16));
    System.out.println(solution.isPerfectSquare(14));
    System.out.println(solution.isPerfectSquare(9));
    System.out.println(solution.isPerfectSquare(1));
    System.out.println(solution.isPerfectSquare(0));
    System.out.println(solution.isPerfectSquare(Integer.MAX_VALUE));
    System.out.println(solution.isPerfectSquare(2_147_395_600));
  }

  public boolean isPerfectSquare(int num) {
    var start = 0;
    var end = num / 2 + 1;
    var mid = 0;
    while (start <= end) {
      mid = start + (end - start) / 2;
      if (mid * mid == num) {
        return true;
      }
      if (1L * mid * mid < num) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return false;
  }
}
