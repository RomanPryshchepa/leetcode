package com.leetcode.lc821;

import java.util.Arrays;

/*
821. Shortest Distance to a Character

Given a string s and a character c that occurs in s, return an array of integers answer where answer.length == s.length and answer[i] is the distance from index i to the closest occurrence of character c in s.

The distance between two indices i and j is abs(i - j), where abs is the absolute value function.



Example 1:

Input: s = "loveleetcode", c = "e"
Output: [3,2,1,0,1,0,0,1,2,2,1,0]
Explanation: The character 'e' appears at indices 3, 5, 6, and 11 (0-indexed).
The closest occurrence of 'e' for index 0 is at index 3, so the distance is abs(0 - 3) = 3.
The closest occurrence of 'e' for index 1 is at index 3, so the distance is abs(1 - 3) = 2.
For index 4, there is a tie between the 'e' at index 3 and the 'e' at index 5, but the distance is still the same: abs(4 - 3) == abs(4 - 5) = 1.
The closest occurrence of 'e' for index 8 is at index 6, so the distance is abs(8 - 6) = 2.

Example 2:

Input: s = "aaab", c = "b"
Output: [3,2,1,0]



Constraints:

    1 <= s.length <= 104
    s[i] and c are lowercase English letters.
    It is guaranteed that c occurs at least once in s.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(Arrays.toString(solution.shortestToChar("loveleetcode", 'e')));
    System.out.println(Arrays.toString(solution.shortestToChar("aaab", 'b')));
    System.out.println(Arrays.toString(solution.shortestToChar("b", 'b')));
    System.out.println(Arrays.toString(solution.shortestToChar("aaba", 'b')));
  }

  public int[] shortestToChar(String s, char c) {
    var left = -1;
    var right = s.indexOf(c);
    var result = new int[s.length()];
    for (var i = 0; i < s.length(); i++) {
      if (i > left && right == left) {
        result[i] = i - left;
      } else if (i < right && left == -1) {
        result[i] = right - i;
      } else if (i < right) {
        result[i] = Math.min(i - left, right - i);
      } else if (i == right) {
        result[i] = 0;
        left = i;
        right = left + s.substring(i + 1).indexOf(c) + 1;
      }
    }
    return result;
  }

}
