package com.leetcode.lc953;

import java.util.HashMap;

/*
953. Verifying an Alien Dictionary

In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.



Example 1:

Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.

Example 2:

Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Output: false
Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.

Example 3:

Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
Output: false
Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).



Constraints:

    1 <= words.length <= 100
    1 <= words[i].length <= 20
    order.length == 26
    All characters in words[i] and order are English lowercase letters.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] words;
    String order;

    words = new String[]{"hello", "leetcode"};
    order = "hlabcdefgijkmnopqrstuvwxyz";
    System.out.println(solution.isAlienSorted(words, order)); // true

    words = new String[]{"word", "world", "row"};
    order = "worldabcefghijkmnpqstuvxyz";
    System.out.println(solution.isAlienSorted(words, order)); // false

    words = new String[]{"apple", "app"};
    order = "abcdefghijklmnopqrstuvwxyz";
    getPrintln(solution, words, order); // false
  }

  private static void getPrintln(Solution solution, String[] words, String order) {
    System.out.println(solution.isAlienSorted(words, order));
  }

  public boolean isAlienSorted(String[] words, String order) {
    if (words.length == 1) {
      return true;
    }
    var alphabet = new HashMap<Character, Integer>();
    for (int i = 0; i < order.length(); i++) {
      alphabet.put(order.charAt(i), i);
    }

    String s1;
    String s2;
    int minLen;
    for (int i = 1; i < words.length; i++) {
      s1 = words[i - 1];
      s2 = words[i];
      minLen = Math.min(s1.length(), s2.length());
      for (int j = 0; j < minLen; j++) {
        if (alphabet.get(s1.charAt(j)) < alphabet.get(s2.charAt(j))) {
          break;
        }
        if (alphabet.get(s1.charAt(j)) > alphabet.get(s2.charAt(j))) {
          return false;
        }
        if (j == minLen - 1 && s1.length() > s2.length()) {
          return false;
        }
      }
    }
    return true;
  }
}
