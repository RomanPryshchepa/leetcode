package com.leetcode.lc451;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/*
451. Sort Characters By Frequency

Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.



Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:

Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:

Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.



Constraints:

    1 <= s.length <= 5 * 105
    s consists of uppercase and lowercase English letters and digits.
 */
public class Solution {

  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.frequencySort("tree"));
    System.out.println(sol.frequencySort("cccaaa"));
    System.out.println(sol.frequencySort("Aabb"));
  }

  public String frequencySort(String s) {
    var map = new HashMap<Character, Integer>();
    for (char c : s.toCharArray()) {
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      } else {
        map.put(c, 1);
      }
    }
    List<Entry<Character, Integer>> myList = new ArrayList<>(map.entrySet());
    myList.sort((pair1, pair2) -> pair2.getValue() - pair1.getValue());
    var sb = new StringBuilder();
    for (var pair : myList) {
      var cnt = pair.getValue();
      while (cnt > 0) {
        sb.append(pair.getKey());
        cnt--;
      }
    }
    return sb.toString();
  }
}
