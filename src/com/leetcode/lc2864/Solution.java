package com.leetcode.lc2864;

/*
2864. Maximum Odd Binary Number

You are given a binary string s that contains at least one '1'.

You have to rearrange the bits in such a way that the resulting binary number is the maximum odd binary number that can be created from this combination.

Return a string representing the maximum odd binary number that can be created from the given combination.

Note that the resulting string can have leading zeros.



Example 1:

Input: s = "010"
Output: "001"
Explanation: Because there is just one '1', it must be in the last position. So the answer is "001".

Example 2:

Input: s = "0101"
Output: "1001"
Explanation: One of the '1's must be in the last position. The maximum number that can be made with the remaining digits is "100". So the answer is "1001".



Constraints:

    1 <= s.length <= 100
    s consists only of '0' and '1'.
    s contains at least one '1'.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.maximumOddBinaryNumber("010"));
    System.out.println(solution.maximumOddBinaryNumber2("010"));
    System.out.println(solution.maximumOddBinaryNumber("0101"));
    System.out.println(solution.maximumOddBinaryNumber2("0101"));
  }

  public String maximumOddBinaryNumber(String s) {
    var cnt = (int) s.chars().filter(c -> c == '1').count();
    return "1".repeat(cnt - 1) + "0".repeat(s.length() - cnt) + "1";
  }

  public String maximumOddBinaryNumber2(String s) {
    var charArr = new char[s.length()];
    var i0 = s.length() - 1;
    var i1 = 0;
    for (char c : s.toCharArray()) {
      if (c == '1')
        charArr[i1++] = '1';
      else
        charArr[i0--] = '0';
    }
    charArr[--i1] = '0';
    charArr[s.length() - 1] = '1';
    return new String(charArr);
  }

}
