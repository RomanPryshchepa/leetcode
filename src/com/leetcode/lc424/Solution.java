package com.leetcode.lc424;

import java.util.HashMap;

/*
424. Longest Repeating Character Replacement

You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.



Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.

Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.



Constraints:

    1 <= s.length <= 105
    s consists of only uppercase English letters.
    0 <= k <= s.length
 */
public class Solution {

  public static void main(String[] args) {
    String s;
    int k;
    //Example 1:
    //
    //Input: s = "ABAB", k = 2
    //Output: 4
    //Explanation: Replace the two 'A's with two 'B's or vice versa.
    s = "ABAB";
    k = 2;
    System.out.println(characterReplacement(s, k));

    //Example 2:
    //
    //Input: s = "AABABBA", k = 1
    //Output: 4
    //Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
    //The substring "BBBB" has the longest repeating letters, which is 4.
    //There may exists other ways to achieve this answer too.
    s = "AABABBA";
    k = 1;
    System.out.println(characterReplacement(s, k));

    //Example 3:
    //
    //Input: s = "AABABBA", k = 0
    //Output: 3
    //Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
    //The substring "BBBB" has the longest repeating letters, which is 4.
    //There may exists other ways to achieve this answer too.
    s = "ABAA";
    k = 0;
    System.out.println(characterReplacement(s, k));
  }

  public static int characterReplacement(String s, int k) {
    int leftInd = 0;
    var letterDict = new HashMap<Character, Integer>();
    int res = 0;
    for (int rightInd = 0; rightInd < s.length(); rightInd++) {
      if (letterDict.containsKey(s.charAt(rightInd))) {
        letterDict.put(s.charAt(rightInd), letterDict.get(s.charAt(rightInd)) + 1);
      } else {
        letterDict.put(s.charAt(rightInd), 1);
      }

      while (letterDict.values().stream().reduce(0, Integer::sum) - letterDict.values().stream()
          .max(Integer::compareTo).get() > k) {
        if (letterDict.containsKey(s.charAt(leftInd))) {
          letterDict.put(s.charAt(leftInd), letterDict.get(s.charAt(leftInd)) - 1);
          if (letterDict.get(s.charAt(leftInd)) == 0) {
            letterDict.remove(s.charAt(leftInd));
          }
        }
        leftInd++;
      }
      var valSum = letterDict.values().stream().reduce(0, Integer::sum);
      res = valSum > res ? valSum : res;
    }
    return res;
  }
}
