package com.leetcode.lc205;

import java.util.HashMap;
import java.util.HashSet;

/*
205. Isomorphic Strings

Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.



Example 1:

Input: s = "egg", t = "add"
Output: true

Example 2:

Input: s = "foo", t = "bar"
Output: false

Example 3:

Input: s = "paper", t = "title"
Output: true



Constraints:

    1 <= s.length <= 5 * 104
    t.length == s.length
    s and t consist of any valid ascii character.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    String s;
    String t;

    s = "egg";
    t = "add";
    System.out.println(solution.isIsomorphic(s, t));

    s = "foo";
    t = "bar";
    System.out.println(solution.isIsomorphic(s, t));

    s = "paper";
    t = "title";
    System.out.println(solution.isIsomorphic(s, t));

    s = "badc";
    t = "baba";
    System.out.println(solution.isIsomorphic(s, t));
  }

  public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    HashMap<Character, Character> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char sChar = s.charAt(i);
      char tChar = t.charAt(i);
      if (map.containsKey(sChar) && !map.get(sChar).equals(tChar)) {
        return false;
      } else if (!map.containsKey(sChar)) {
        map.put(sChar, tChar);
      }
    }
    return new HashSet<>(map.values()).size() == map.size();
  }
}
