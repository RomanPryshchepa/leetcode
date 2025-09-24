package com.leetcode.lc1859;

import java.util.TreeMap;

/*
1859. Sorting the Sentence

A sentence is a list of words that are separated by a single space with no leading or trailing spaces. Each word consists of lowercase and uppercase English letters.

A sentence can be shuffled by appending the 1-indexed word position to each word then rearranging the words in the sentence.

    For example, the sentence "This is a sentence" can be shuffled as "sentence4 a3 is2 This1" or "is2 sentence4 This1 a3".

Given a shuffled sentence s containing no more than 9 words, reconstruct and return the original sentence.



Example 1:

Input: s = "is2 sentence4 This1 a3"
Output: "This is a sentence"
Explanation: Sort the words in s to their original positions "This1 is2 a3 sentence4", then remove the numbers.

Example 2:

Input: s = "Myself2 Me1 I4 and3"
Output: "Me Myself and I"
Explanation: Sort the words in s to their original positions "Me1 Myself2 and3 I4", then remove the numbers.



Constraints:

    2 <= s.length <= 200
    s consists of lowercase and uppercase English letters, spaces, and digits from 1 to 9.
    The number of words in s is between 1 and 9.
    The words in s are separated by a single space.
    s contains no leading or trailing spaces.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.sortSentence("is2 sentence4 This1 a3"));
    System.out.println(solution.sortSentence("Myself2 Me1 I4 and3"));
  }

  public String sortSentence(String s) {
    var map = new TreeMap<Integer, String>();
    for (var item : s.split(" "))
      map.put(Integer.parseInt(item.substring(item.length() - 1)), item.substring(0, item.length() - 1));
    var sb = new StringBuilder();
    var delim = "";
    for (String value : map.values()) {
      sb.append(delim);
      sb.append(value);
      delim = " ";
    }
    return sb.toString();
  }
}
