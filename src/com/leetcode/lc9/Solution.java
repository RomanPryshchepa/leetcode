package com.leetcode.lc9;

import java.util.ArrayList;
import java.util.List;

/*
9. Palindrome Number

Given an integer x, return true if x is a
palindrome
, and false otherwise.



Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.



Constraints:

    -231 <= x <= 231 - 1


Follow up: Could you solve it without converting the integer to a string?
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int x;

    x = 121;
    System.out.println(solution.isPalindrome(x)); // true

    x = -121;
    System.out.println(solution.isPalindrome(x)); // false

    x = 10;
    System.out.println(solution.isPalindrome(x)); // false

    x = 5;
    System.out.println(solution.isPalindrome(x)); // false

    x = 1387667831;
    System.out.println(solution.isPalindrome(x)); // false

    x = 513575315;
    System.out.println(solution.isPalindrome(x)); // false
  }

  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    }
    if (x / 10 == 0) {
      return true;
    }
    List<Integer> digits = new ArrayList<>();
    while (x > 0) {
      digits.add(x % 10);
      x = x / 10;
    }
    for (int i = 0; i < (digits.size() + 1) / 2; i++) {
      if (!digits.get(i).equals(digits.get(digits.size() - 1 - i))) {
        return false;
      }
    }
    return true;
  }
}
