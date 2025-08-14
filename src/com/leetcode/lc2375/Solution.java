package com.leetcode.lc2375;

import java.util.ArrayList;

/*
2375. Construct Smallest Number From DI String

You are given a 0-indexed string pattern of length n consisting of the characters 'I' meaning increasing and 'D' meaning decreasing.

A 0-indexed string num of length n + 1 is created using the following conditions:

    num consists of the digits '1' to '9', where each digit is used at most once.
    If pattern[i] == 'I', then num[i] < num[i + 1].
    If pattern[i] == 'D', then num[i] > num[i + 1].

Return the lexicographically smallest possible string num that meets the conditions.



Example 1:

Input: pattern = "IIIDIDDD"
Output: "123549876"
Explanation:
At indices 0, 1, 2, and 4 we must have that num[i] < num[i+1].
At indices 3, 5, 6, and 7 we must have that num[i] > num[i+1].
Some possible values of num are "245639871", "135749862", and "123849765".
It can be proven that "123549876" is the smallest possible num that meets the conditions.
Note that "123414321" is not possible because the digit '1' is used more than once.

Example 2:

Input: pattern = "DDD"
Output: "4321"
Explanation:
Some possible values of num are "9876", "7321", and "8742".
It can be proven that "4321" is the smallest possible num that meets the conditions.



Constraints:

    1 <= pattern.length <= 8
    pattern consists of only the letters 'I' and 'D'.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.smallestNumber("IDIDDD"));
    System.out.println(solution.smallestNumber("DDD"));
    System.out.println(solution.smallestNumber("I"));
    System.out.println(solution.smallestNumber("ID"));
    System.out.println(solution.smallestNumber("IDD"));
    System.out.println(solution.smallestNumber("IIIIIIII"));
    System.out.println(solution.smallestNumber("DDDDDDDD"));
  }

  public String smallestNumber(String pattern) {
    var countD = 0;
    for (var c : pattern.toCharArray()) {
      if (c == 'D')
        countD++;
      else
        break;
    }
    countD++;
    for (int i = countD * (int) Math.pow(10, pattern.length()); i < (int)Math.pow(10, pattern.length() + 1); i++)
      if (SmallestNumberChecker(i, pattern))
        return String.valueOf(i);

    return "error";
  }

  private boolean SmallestNumberChecker(int number, String pattern) {
    var digits = new ArrayList<Integer>();
    var postDigit = number % 10;
    if (postDigit == 0)
      return false;
    digits.add(postDigit);
    number /= 10;
    var i = pattern.length() - 1;
    while (number > 0)
    {
      if (number % 10 == 0 || digits.contains(number % 10))
        return false;
      if ((pattern.charAt(i) == 'D' && postDigit > number % 10) || (pattern.charAt(i) == 'I' && postDigit < number % 10))
        return false;

      digits.add(number % 10);
      postDigit = number % 10;
      number /= 10;
      i--;
    }
    return true;
  }
}
