package com.leetcode.lc13;

/*
13. Roman to Integer

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer.



Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.

Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.



Constraints:

    1 <= s.length <= 15
    s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
    It is guaranteed that s is a valid roman numeral in the range [1, 3999].


 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    String s;

    s = "III";
    System.out.println(solution.romanToInt(s)); // 3

    s = "LVIII";
    System.out.println(solution.romanToInt(s)); // 58

    s = "MCMXCIV";
    System.out.println(solution.romanToInt(s)); // 1994
  }

  public int romanToInt(String s) {
    char[] charArray = s.toCharArray();
    int res = 0;
    int i = 0;
    while (i < charArray.length) {
      if (i < charArray.length - 1) {
        if (charArray[i] == 'I' && charArray[i + 1] == 'V') {
          res += 4;
          i += 2;
        } else if (charArray[i] == 'I' && charArray[i + 1] == 'X') {
          res += 9;
          i += 2;
        } else if (charArray[i] == 'X' && charArray[i + 1] == 'L') {
          res += 40;
          i += 2;
        } else if (charArray[i] == 'X' && charArray[i + 1] == 'C') {
          res += 90;
          i += 2;
        } else if (charArray[i] == 'C' && charArray[i + 1] == 'D') {
          res += 400;
          i += 2;
        } else if (charArray[i] == 'C' && charArray[i + 1] == 'M') {
          res += 900;
          i += 2;
        } else if (charArray[i] == 'I') {
          res += 1;
          i++;
        } else if (charArray[i] == 'V') {
          res += 5;
          i++;
        } else if (charArray[i] == 'X') {
          res += 10;
          i++;
        } else if (charArray[i] == 'L') {
          res += 50;
          i++;
        } else if (charArray[i] == 'C') {
          res += 100;
          i++;
        } else if (charArray[i] == 'D') {
          res += 500;
          i++;
        } else if (charArray[i] == 'M') {
          res += 1000;
          i++;
        }
      } else {
        if (charArray[i] == 'I') {
          res += 1;
        } else if (charArray[i] == 'V') {
          res += 5;
        } else if (charArray[i] == 'X') {
          res += 10;
        } else if (charArray[i] == 'L') {
          res += 50;
        } else if (charArray[i] == 'C') {
          res += 100;
        } else if (charArray[i] == 'D') {
          res += 500;
        } else if (charArray[i] == 'M') {
          res += 1000;
        }
        break;
      }
    }
    return res;
  }
}
