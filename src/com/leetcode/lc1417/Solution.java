package com.leetcode.lc1417;

import java.util.LinkedList;

/*
1417. Reformat The String

You are given an alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).

You have to find a permutation of the string where no letter is followed by another letter and no digit is followed by another digit. That is, no two adjacent characters have the same type.

Return the reformatted string or return an empty string if it is impossible to reformat the string.



Example 1:

Input: s = "a0b1c2"
Output: "0a1b2c"
Explanation: No two adjacent characters have the same type in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also valid permutations.

Example 2:

Input: s = "leetcode"
Output: ""
Explanation: "leetcode" has only characters so we cannot separate them by digits.

Example 3:

Input: s = "1229857369"
Output: ""
Explanation: "1229857369" has only digits so we cannot separate them by characters.



Constraints:

    1 <= s.length <= 500
    s consists of only lowercase English letters and/or digits.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.reformat("a0b1c2"));
    System.out.println(solution.reformat("leetcode"));
    System.out.println(solution.reformat("1229857369"));
    System.out.println(solution.reformat("1ff22kj985ret73fd69"));
  }

  public String reformat(String s) {
    var letters = new LinkedList<Character>();
    var digits = new LinkedList<Character>();
    for (char c : s.toCharArray()) {
      if (Character.isDigit(c)) {
        digits.add(c);
      } else {
        letters.add(c);
      }
    }
    if (Math.abs(digits.size() - letters.size()) > 1) {
      return "";
    }
    var result = new StringBuilder();
    if (digits.size() > letters.size()) {
      while (!letters.isEmpty()) {
        result.append(digits.pop());
        result.append(letters.pop());
      }
      result.append(digits.pop());
    } else {
      while (!digits.isEmpty()) {
        result.append(letters.pop());
        result.append(digits.pop());
      }
      if (!letters.isEmpty()) {
        result.append(letters.pop());
      }
    }
    return result.toString();
  }
}
