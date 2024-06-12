package com.leetcode.lc1941;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/*
1941. Check if All Characters Have Equal Number of Occurrences

Given a string s, return true if s is a good string, or false otherwise.

A string s is good if all the characters that appear in s have the same number of occurrences (i.e., the same frequency).



Example 1:

Input: s = "abacbc"
Output: true
Explanation: The characters that appear in s are 'a', 'b', and 'c'. All characters occur 2 times in s.

Example 2:

Input: s = "aaabb"
Output: false
Explanation: The characters that appear in s are 'a' and 'b'.
'a' occurs 3 times while 'b' occurs 2 times, which is not the same number of times.



Constraints:

    1 <= s.length <= 1000
    s consists of lowercase English letters.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    String s;

    s = "abacbc";
    System.out.println(solution.areOccurrencesEqual(s));

    s = "aaabb";
    System.out.println(solution.areOccurrencesEqual(s));
  }

  public boolean areOccurrencesEqual(String s) {
    if (s.isEmpty()) {
      return true;
    }
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, Optional.ofNullable(map.get(c)).orElse(0) + 1);
    }

    Collection<Integer> values = map.values();
    Integer firstValue = values.iterator().next();
    for (Integer value : values) {
      if (!value.equals(firstValue)) {
        return false;
      }
    }
    return true;
  }

}
