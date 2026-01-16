package com.leetcode.lc2000;

/*
2000. Reverse Prefix of Word

Given a 0-indexed string word and a character ch, reverse the segment of word that starts at index 0 and ends at the index of the first occurrence of ch (inclusive). If the character ch does not exist in word, do nothing.

    For example, if word = "abcdefd" and ch = "d", then you should reverse the segment that starts at 0 and ends at 3 (inclusive). The resulting string will be "dcbaefd".

Return the resulting string.



Example 1:

Input: word = "abcdefd", ch = "d"
Output: "dcbaefd"
Explanation: The first occurrence of "d" is at index 3.
Reverse the part of word from 0 to 3 (inclusive), the resulting string is "dcbaefd".

Example 2:

Input: word = "xyxzxe", ch = "z"
Output: "zxyxxe"
Explanation: The first and only occurrence of "z" is at index 3.
Reverse the part of word from 0 to 3 (inclusive), the resulting string is "zxyxxe".

Example 3:

Input: word = "abcd", ch = "z"
Output: "abcd"
Explanation: "z" does not exist in word.
You should not do any reverse operation, the resulting string is "abcd".



Constraints:

    1 <= word.length <= 250
    word consists of lowercase English letters.
    ch is a lowercase English letter.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.reversePrefix("abcdefd", 'd'));
    System.out.println(solution.reversePrefix2("abcdefd", 'd'));
    System.out.println(solution.reversePrefix("xyxzxe", 'z'));
    System.out.println(solution.reversePrefix2("xyxzxe", 'z'));
    System.out.println(solution.reversePrefix("abcd", 'z'));
    System.out.println(solution.reversePrefix2("abcd", 'z'));
  }

  public String reversePrefix(String word, char ch) {
    var chIdx = word.indexOf(ch);
    if (chIdx == -1) {
      return word;
    }
    var res = new StringBuilder(word.substring(0, chIdx + 1)).reverse();
    res.append(word.substring(chIdx + 1));
    return res.toString();
  }

  public String reversePrefix2(String word, char ch) {
    var posCh = word.indexOf(ch);
    if (posCh <= 0)
      return word;
    var sb = new StringBuilder();
    for (var i = posCh; i >= 0; i--)
      sb.append(word.charAt(i));
    sb.append(word.substring(posCh + 1));
    return sb.toString();
  }
}
