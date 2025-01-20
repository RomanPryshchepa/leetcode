package com.leetcode.lc2785;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/*
2785. Sort Vowels in a String

Given a 0-indexed string s, permute s to get a new string t such that:

    All consonants remain in their original places. More formally, if there is an index i with 0 <= i < s.length such that s[i] is a consonant, then t[i] = s[i].
    The vowels must be sorted in the nondecreasing order of their ASCII values. More formally, for pairs of indices i, j with 0 <= i < j < s.length such that s[i] and s[j] are vowels, then t[i] must not have a higher ASCII value than t[j].

Return the resulting string.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in lowercase or uppercase. Consonants comprise all letters that are not vowels.



Example 1:

Input: s = "lEetcOde"
Output: "lEOtcede"
Explanation: 'E', 'O', and 'e' are the vowels in s; 'l', 't', 'c', and 'd' are all consonants. The vowels are sorted according to their ASCII values, and the consonants remain in the same places.

Example 2:

Input: s = "lYmpH"
Output: "lYmpH"
Explanation: There are no vowels in s (all characters in s are consonants), so we return "lYmpH".



Constraints:

    1 <= s.length <= 105
    s consists only of letters of the English alphabet in uppercase and lowercase.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.sortVowels("lEetcOde")); // "lEOtcede"
    System.out.println(solution.sortVowels("lYmpH")); // "lYmpH"
    System.out.println(solution.sortVowels2("lEetcOde")); // "lEOtcede"
    System.out.println(solution.sortVowels2("lYmpH")); // "lYmpH"
  }

  public String sortVowels(String s) {
    var chars = s.toCharArray();
    var vovelCount = 0;
    for (var currentChar : chars) {
      if (isVowel(currentChar)) {
        vovelCount++;
      }
    }
    var sortedVovels = new char[vovelCount];
    var j = 0;
    for (var currentChar : chars) {
      if (isVowel(currentChar)) {
          sortedVovels[j++] = currentChar;
      }
    }
    Arrays.sort(sortedVovels);
    j = 0;
    for (var i = 0; i < chars.length; i++) {
      if (isVowel(chars[i])) {
        chars[i] = sortedVovels[j++];
      }
    }
    return new String(chars);
  }

  private boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
  }

  public String sortVowels2(String s) {
    var chars = new Character[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
    var vowels = new HashSet<Character>();
    Collections.addAll(vowels, chars);
    var sortedVovels = new ArrayList<Character>();
    var j = 0;
    for (int i = 0; i < s.length(); i++) {
      char currentChar = s.charAt(i);
      if (vowels.contains(currentChar)) {
        if (sortedVovels.isEmpty() || currentChar >= sortedVovels.get(sortedVovels.size() - 1)) {
          sortedVovels.add(currentChar);
        } else {
          j = 0;
          while (currentChar > sortedVovels.get(j)) {
            j++;
          }
          sortedVovels.add(j, currentChar);
        }
      }
    }
    var result = new StringBuilder();
    j = 0;
    for (int i = 0; i < s.length(); i++) {
      if (vowels.contains(s.charAt(i))) {
        result.append(sortedVovels.get(j++));
      } else {
        result.append(s.charAt(i));
      }
    }
    return result.toString();
  }
}
