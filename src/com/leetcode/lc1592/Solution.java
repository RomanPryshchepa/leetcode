package com.leetcode.lc1592;

/*
1592. Rearrange Spaces Between Words

You are given a string text of words that are placed among some number of spaces. Each word consists of one or more lowercase English letters and are separated by at least one space. It's guaranteed that text contains at least one word.

Rearrange the spaces so that there is an equal number of spaces between every pair of adjacent words and that number is maximized. If you cannot redistribute all the spaces equally, place the extra spaces at the end, meaning the returned string should be the same length as text.

Return the string after rearranging the spaces.



Example 1:

Input: text = "  this   is  a sentence "
Output: "this   is   a   sentence"
Explanation: There are a total of 9 spaces and 4 words. We can evenly divide the 9 spaces between the words: 9 / (4-1) = 3 spaces.

Example 2:

Input: text = " practice   makes   perfect"
Output: "practice   makes   perfect "
Explanation: There are a total of 7 spaces and 3 words. 7 / (3-1) = 3 spaces plus 1 extra space. We place this extra space at the end of the string.



Constraints:

    1 <= text.length <= 100
    text consists of lowercase English letters and ' '.
    text contains at least one word.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.printf("|%s|%n", solution.reorderSpaces("  this   is  a sentence "));
    System.out.printf("|%s|%n", solution.reorderSpaces(" practice   makes   perfect"));
    System.out.printf("|%s|%n", solution.reorderSpaces("a"));
    System.out.printf("|%s|%n", solution.reorderSpaces("a "));
    System.out.printf("|%s|%n", solution.reorderSpaces(" a "));
  }

  public String reorderSpaces(String text) {
    var spaceCount = text.length() - text.replaceAll(" ", "").length();
    var words = text.trim().split(" +");
    if (words.length == 0) {
      return text;
    }
    if (words.length == 1) {
      return words[0] + text.replace(words[0], "");
    }
    var spacesBetweenWordsCount = spaceCount / (words.length - 1);
    var spacesBetweenWords = new StringBuilder();
    while (spacesBetweenWordsCount > 0) {
      spacesBetweenWordsCount--;
      spacesBetweenWords.append(" ");
    }
    var leadingSpaces = spaceCount % (words.length - 1);
    var result = new StringBuilder();
    var divisor = new StringBuilder();
    for (var word : words) {
      if (!word.isEmpty()) {
        result.append(divisor);
        result.append(word);
        divisor = spacesBetweenWords;
      }
    }
    while (leadingSpaces > 0) {
      result.append(" ");
      leadingSpaces--;
    }
    return result.toString();
  }
}
