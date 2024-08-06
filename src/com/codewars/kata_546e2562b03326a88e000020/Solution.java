package com.codewars.kata_546e2562b03326a88e000020;

/*
Welcome. In this kata, you are asked to square every digit of a number and concatenate them.

For example, if we run 9119 through the function, 811181 will come out, because 92 is 81 and 12 is 1. (81-1-1-81)

Example #2: An input of 765 will/should return 493625 because 72 is 49, 62 is 36, and 52 is 25. (49-36-25)

Note: The function accepts an integer and returns an integer.

Happy Coding!
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.squareDigits(9119)); // 811181
    System.out.println(solution.squareDigits(0)); // 0
    System.out.println(solution.squareDigits(765)); // 493625
    System.out.println(solution.squareDigits(7605)); // 4936025
  }

  public int squareDigits(int n) {
    int result = 0;
    int mult = 1;
    while (n > 0) {
      int sqr = (n % 10) * (n % 10);
      result += sqr * mult;
      mult = sqr / 10 > 0 ? mult * 100 : mult * 10;
      n /= 10;
    }
    return result;
  }
}
