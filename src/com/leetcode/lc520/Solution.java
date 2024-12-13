package com.leetcode.lc520;

/*
520. Detect Capital

We define the usage of capitals in a word to be right when one of the following cases holds:

    All letters in this word are capitals, like "USA".
    All letters in this word are not capitals, like "leetcode".
    Only the first letter in this word is capital, like "Google".

Given a string word, return true if the usage of capitals in it is right.



Example 1:

Input: word = "USA"
Output: true

Example 2:

Input: word = "FlaG"
Output: false



Constraints:

    1 <= word.length <= 100
    word consists of lowercase and uppercase English letters.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.detectCapitalUse("USA"));
    System.out.println(solution.detectCapitalUse("FlaG"));
  }

  public boolean detectCapitalUse(String word) {
    return isAllCapital(word) || isAllLower(word) || (Character.isUpperCase(word.charAt(0)) && isAllLower(word.substring(1)));
  }

  private boolean isAllCapital(String word) {
    return word.toUpperCase().equals(word);
  }

  private boolean isAllLower(String word) {
    return word.toLowerCase().equals(word);
  }
}
