package com.codewars.kata_55f2b110f61eb01779000053;

/*
Given two integers a and b, which can be positive or negative, find the sum of all the integers between and including them and return it. If the two numbers are equal return a or b.

Note: a and b are not ordered!
Examples (a, b) --> output (explanation)

(1, 0) --> 1 (1 + 0 = 1)
(1, 2) --> 3 (1 + 2 = 3)
(0, 1) --> 1 (0 + 1 = 1)
(1, 1) --> 1 (1 since both are same)
(-1, 0) --> -1 (-1 + 0 = -1)
(-1, 2) --> 2 (-1 + 0 + 1 + 2 = 2)

Your function should only return a number, not the explanation about how you get that number.

 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.GetSum(1, 0));
    System.out.println(solution.GetSum(1, 2));
    System.out.println(solution.GetSum(0, 1));
    System.out.println(solution.GetSum(1, 1));
    System.out.println(solution.GetSum(-1, 0));
    System.out.println(solution.GetSum(-1, 2));
  }

  public int GetSum(int a, int b) {
    int result = 0;
    int start = Math.min(a, b);
    int end = Math.max(a, b);
    for (int i = start; i <= end; i++) {
      result += i;
    }
    return result;
  }
}
