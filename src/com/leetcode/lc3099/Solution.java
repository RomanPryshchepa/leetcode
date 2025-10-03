package com.leetcode.lc3099;

/*
3099. Harshad Number

An integer divisible by the sum of its digits is said to be a Harshad number. You are given an integer x. Return the sum of the digits of x if x is a Harshad number, otherwise, return -1.



Example 1:

Input: x = 18

Output: 9

Explanation:

The sum of digits of x is 9. 18 is divisible by 9. So 18 is a Harshad number and the answer is 9.

Example 2:

Input: x = 23

Output: -1

Explanation:

The sum of digits of x is 5. 23 is not divisible by 5. So 23 is not a Harshad number and the answer is -1.



Constraints:

    1 <= x <= 100
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.sumOfTheDigitsOfHarshadNumber(18));
    System.out.println(solution.sumOfTheDigitsOfHarshadNumber(23));
    System.out.println(solution.sumOfTheDigitsOfHarshadNumber(100));
    System.out.println(solution.sumOfTheDigitsOfHarshadNumber(30));
    System.out.println(solution.sumOfTheDigitsOfHarshadNumber(45));
    System.out.println(solution.sumOfTheDigitsOfHarshadNumber(55));
  }

  public int sumOfTheDigitsOfHarshadNumber(int x) {
    if (x % sumOfDigits(x) == 0) {
      return sumOfDigits(x);
    } else {
      return -1;
    }
  }

  private int sumOfDigits(int x) {
    int sum = 0;
    while (x > 0) {
      sum += x % 10;
      x /= 10;
    }
    return sum;
  }
}
