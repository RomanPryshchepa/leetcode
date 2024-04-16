package com.leetcode.lc1768;

/*
1768. Merge Strings Alternately

You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

Return the merged string.



Example 1:

Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r

Example 2:

Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b
word2:    p   q   r   s
merged: a p b q   r   s

Example 3:

Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q
merged: a p b q c   d



Constraints:

    1 <= word1.length, word2.length <= 100
    word1 and word2 consist of lowercase English letters.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    String word1;
    String word2;

    word1 = "abc";
    word2 = "pqr";
    System.out.println(solution.mergeAlternately(word1, word2)); // apbqcr

    word1 = "ab";
    word2 = "pqrs";
    System.out.println(solution.mergeAlternately(word1, word2)); // apbqrs

    word1 = "abcd";
    word2 = "pq";
    System.out.println(solution.mergeAlternately(word1, word2)); // apbqcd

    word1 = "a";
    word2 = "";
    System.out.println(solution.mergeAlternately(word1, word2)); // ap
  }

  public String mergeAlternately1(String word1, String word2) {
    int word1Idx = 0;
    int word2Idx = 0;
    StringBuilder sb = new StringBuilder();
    while (word1Idx < word1.length() && word2Idx < word2.length()) {
      sb.append(word1.charAt(word1Idx++));
      sb.append(word2.charAt(word2Idx++));
    }
    while (word1Idx < word1.length()) {
      sb.append(word1.charAt(word1Idx++));
    }
    while (word2Idx < word2.length()) {
      sb.append(word2.charAt(word2Idx++));
    }
    return sb.toString();
  }

  public String mergeAlternately(String word1, String word2) {
    int idx = 0;
    StringBuilder sb = new StringBuilder();
    while (idx < word1.length() || idx < word2.length()) {
      if (idx < word1.length()) {
        sb.append(word1.charAt(idx));
      }
      if (idx < word2.length()) {
        sb.append(word2.charAt(idx));
      }
      idx++;
    }
    return sb.toString();
  }
}
