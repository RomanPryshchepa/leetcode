package com.leetcode.lc1408;

import java.util.ArrayList;
import java.util.List;

/*
1408. String Matching in an Array
Easy
Topics
Companies
Hint

Given an array of string words, return all strings in words that is a substring of another word. You can return the answer in any order.

A substring is a contiguous sequence of characters within a string



Example 1:

Input: words = ["mass","as","hero","superhero"]
Output: ["as","hero"]
Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
["hero","as"] is also a valid answer.

Example 2:

Input: words = ["leetcode","et","code"]
Output: ["et","code"]
Explanation: "et", "code" are substring of "leetcode".

Example 3:

Input: words = ["blue","green","bu"]
Output: []
Explanation: No string of words is substring of another string.



Constraints:

    1 <= words.length <= 100
    1 <= words[i].length <= 30
    words[i] contains only lowercase English letters.
    All the strings of words are unique.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] words;

    words = new String[]{"mass", "as", "hero", "superhero"};
    System.out.println(solution.stringMatching(words)); // ["as","hero"]

    words = new String[]{"leetcode", "et", "code"};
    System.out.println(solution.stringMatching(words)); // ["et","code"]

    words = new String[]{"blue", "green", "bu"};
    System.out.println(solution.stringMatching(words)); // []

    words = new String[]{"leetcoder","leetcode","od","hamlet","am"};
    System.out.println(solution.stringMatching(words)); // ["leetcode","od","am"]
  }

  public List<String> stringMatching(String[] words) {
    List<String> result = new ArrayList<>();
    for (int i = 0; i < words.length; i++) {
      for (int j = 0; j < words.length; j++) {
        if (words[i].contains(words[j]) && words[j].length() < words[i].length() && !result.contains(words[j])) {
          result.add(words[j]);
        }
      }
    }
    return result;
  }
}
