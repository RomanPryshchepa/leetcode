package com.leetcode.lc402;

import java.util.Deque;
import java.util.LinkedList;

/*
402. Remove K Digits

Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.



Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.



Constraints:

    1 <= k <= num.length <= 105
    num consists of only digits.
    num does not have any leading zeros except for the zero itself.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.removeKdigits("1234567890", 9)); //"0"
    System.out.println(solution.removeKdigits("1173", 2)); //"11"
    System.out.println(solution.removeKdigits("1432219", 3)); //"1219"
    System.out.println(solution.removeKdigits("14325219", 3)); //"12219"
    System.out.println(solution.removeKdigits("10200", 1)); // "200"
    System.out.println(solution.removeKdigits("10", 2)); // "0"
    System.out.println(solution.removeKdigits("112", 1)); // "11"
    System.out.println(solution.removeKdigits("10001", 4)); // "0"
  }

  public String removeKdigits(String num, int k) {
    if (num.length() == k) {
      return "0";
    }

    var resLen = num.length() - k;
    Deque<Character> stack = new LinkedList<>();

    for (int i = 0; i < num.length(); i++) {
      while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
        stack.pop();
        k--;
      }
      stack.push(num.charAt(i));
    }

    while (stack.size() > resLen) {
      stack.pop();
    }

    var sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.insert(0, stack.pop());
    }
    var res = sb.toString().replaceAll("^0+", "");

    return res.isEmpty() ? "0" : res;
  }

}
