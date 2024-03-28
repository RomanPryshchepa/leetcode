package com.leetcode.lc3;

import java.util.ArrayList;
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
    String s;
    //Example 1:
    //
    //Input: s = "abcabcbb"
    //Output: 3
    //Explanation: The answer is "abc", with the length of 3.
    s = "abcabcbb";
    System.out.println(lengthOfLongestSubstring(s));

    //Example 2:
    //
    //Input: s = "bbbbb"
    //Output: 1
    //Explanation: The answer is "b", with the length of 1.
    s = "bbbbb";
    System.out.println(lengthOfLongestSubstring(s));

    //Example 3:
    //
    //Input: s = "pwwkew"
    //Output: 3
    //Explanation: The answer is "wke", with the length of 3.
    //Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
    s = "pwwkew";
    System.out.println(lengthOfLongestSubstring(s));

    //Example 4:
    //
    //Input: s = ""
    //Output: 0
    //Explanation: The answer is "wke", with the length of 3.
    //Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
    s = "";
    System.out.println(lengthOfLongestSubstring(s));

    //Example 4:
    //
    //Input: s = "q"
    //Output: 1
    //Explanation: The answer is "wke", with the length of 3.
    //Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
    s = "q";
    System.out.println(lengthOfLongestSubstring(s));

    //Example 5:
    //
    //Input: s = "qwertyuiop"
    //Output: 10
    //Explanation: The answer is "wke", with the length of 3.
    //Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
    s = "qwertyuiop";
    System.out.println(lengthOfLongestSubstring(s));

    //Input: s = "aab"
    //Output: 1
    //Expected: 2
    s = "aab";
    System.out.println(lengthOfLongestSubstring(s));

    //Input: s = "dvdf"
    //Output: 2
    //Expected: 3
    s = "dvdf";
    System.out.println(lengthOfLongestSubstring(s));
  }

  public static int lengthOfLongestSubstring(String s) {
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
        c = uniqChars.remove(0);
      } while (c != current);
      uniqChars.add(current);
      i++;
    }
    maxLen = Math.max(maxLen, uniqChars.size());
    return maxLen;
  }
}
