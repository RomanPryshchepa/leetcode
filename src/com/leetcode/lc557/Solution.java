package com.leetcode.lc557;

/*
557. Reverse Words in a String III

Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.



Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Example 2:

Input: s = "Mr Ding"
Output: "rM gniD"



Constraints:

    1 <= s.length <= 5 * 104
    s contains printable ASCII characters.
    s does not contain any leading or trailing spaces.
    There is at least one word in s.
    All the words in s are separated by a single space.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.reverseWords("Let's take LeetCode contest"));
    System.out.println(solution.reverseWords("Mr Ding"));
  }

  public String reverseWords(String s) {
    var words = s.split(" ");
    for (int i = 0; i < words.length; i++)
      words[i] = reverseWord(words[i]);
    return String.join(" ", words);
  }

  private String reverseWord(String s) {
    return new StringBuilder(s).reverse().toString();
  }
}
