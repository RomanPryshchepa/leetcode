package com.leetcode.lc2652;

/*
2652. Sum Multiples

Given a positive integer n, find the sum of all integers in the range [1, n] inclusive that are divisible by 3, 5, or 7.

Return an integer denoting the sum of all numbers in the given range satisfying the constraint.



Example 1:

Input: n = 7
Output: 21
Explanation: Numbers in the range [1, 7] that are divisible by 3, 5, or 7 are 3, 5, 6, 7. The sum of these numbers is 21.

Example 2:

Input: n = 10
Output: 40
Explanation: Numbers in the range [1, 10] that are divisible by 3, 5, or 7 are 3, 5, 6, 7, 9, 10. The sum of these numbers is 40.

Example 3:

Input: n = 9
Output: 30
Explanation: Numbers in the range [1, 9] that are divisible by 3, 5, or 7 are 3, 5, 6, 7, 9. The sum of these numbers is 30.



Constraints:

    1 <= n <= 103
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.sumOfMultiples(7));
    System.out.println(solution.sumOfMultiples(10));
    System.out.println(solution.sumOfMultiples(9));
    System.out.println(solution.sumOfMultiples(1000));
  }

  public int sumOfMultiples(int n) {
    var result = 0;
    for (int i = 3; i <= n; i += 3) {
      result += i;
    }
    for (int i = 5; i <= n; i += 5) {
      if (i % 3 != 0)
        result += i;
    }
    for (int i = 7; i <= n; i += 7) {
      if (i % 3 != 0 && i % 5 != 0)
        result += i;
    }
    return result;
  }
}
