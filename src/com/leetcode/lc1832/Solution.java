package com.leetcode.lc1832;

import java.util.HashSet;

/*
1832. Check if the Sentence Is Pangram

A pangram is a sentence where every letter of the English alphabet appears at least once.

Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.



Example 1:

Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English alphabet.

Example 2:

Input: sentence = "leetcode"
Output: false



Constraints:

    1 <= sentence.length <= 1000
    sentence consists of lowercase English letters.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
    System.out.println(solution.checkIfPangram("leetcode"));
  }

  public boolean checkIfPangram(String sentence) {
    var set = new HashSet<Character>();
    for (char c : sentence.toCharArray())
      set.add(c);
    return set.size() == 26;
  }
}
