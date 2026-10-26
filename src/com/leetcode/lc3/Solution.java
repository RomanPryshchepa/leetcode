package com.leetcode.lc3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
3. Longest Substring Without Repeating Characters

Given a string s, find the length of the longest
substring
without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.



Constraints:

    0 <= s.length <= 5 * 104
    s consists of English letters, digits, symbols and spaces.

 */

public class Solution {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.lengthOfLongestSubstring("abcabcbb")); //3
    System.out.println(solution.lengthOfLongestSubstring2("abcabcbb")); //3

    System.out.println(solution.lengthOfLongestSubstring("bbbbb")); //1
    System.out.println(solution.lengthOfLongestSubstring2("bbbbb")); //1

    System.out.println(solution.lengthOfLongestSubstring("pwwkew")); //3
    System.out.println(solution.lengthOfLongestSubstring2("pwwkew")); //3

    System.out.println(solution.lengthOfLongestSubstring("")); //0
    System.out.println(solution.lengthOfLongestSubstring2("")); //0

    System.out.println(solution.lengthOfLongestSubstring("q")); //1
    System.out.println(solution.lengthOfLongestSubstring2("q")); //1

    System.out.println(solution.lengthOfLongestSubstring("qwertyuiop")); //10
    System.out.println(solution.lengthOfLongestSubstring2("qwertyuiop")); //10

    System.out.println(solution.lengthOfLongestSubstring("aab")); //2
    System.out.println(solution.lengthOfLongestSubstring2("aab")); //2

    System.out.println(solution.lengthOfLongestSubstring("dvdf")); //3
    System.out.println(solution.lengthOfLongestSubstring2("dvdf")); //3

    System.out.println(solution.lengthOfLongestSubstring("ccbbcc")); //2
    System.out.println(solution.lengthOfLongestSubstring2("ccbbcc")); //2
  }

  public int lengthOfLongestSubstring(String s) {
    char[] charArray = s.toCharArray();
    int maxLen = 0;
    List<Character> uniqChars = new ArrayList<>();
    int i = 0;
    while (i < charArray.length) {
      char current = charArray[i];
      while (!uniqChars.contains(current)) {
        uniqChars.add(current);
        i++;
        if (i >= charArray.length) {
          break;
        }
        current = charArray[i];
      }
      maxLen = Math.max(maxLen, uniqChars.size());
      char c;
      do {
        c = uniqChars.removeFirst();
      } while (c != current);
      uniqChars.add(current);
      i++;
    }
    maxLen = Math.max(maxLen, uniqChars.size());
    return maxLen;
  }

  public int lengthOfLongestSubstring2(String s) {
    var lp = -1;
    var result = 0;
    var map = new HashMap<Character, Integer>();
    var rp = 0;
    for (; rp < s.length(); rp++) {
      if (map.containsKey(s.charAt(rp))) {
        result = Math.max(result, rp - lp - 1);
        lp = Math.max(lp, map.get(s.charAt(rp)));
      }
      map.put(s.charAt(rp), rp);
    }
    return Math.max(result, rp - lp - 1);
  }
}
