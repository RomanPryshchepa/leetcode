package com.leetcode.lc942;

import java.util.Arrays;

/*
942. DI String Match

A permutation perm of n + 1 integers of all the integers in the range [0, n] can be represented as a string s of length n where:

    s[i] == 'I' if perm[i] < perm[i + 1], and
    s[i] == 'D' if perm[i] > perm[i + 1].

Given a string s, reconstruct the permutation perm and return it. If there are multiple valid permutations perm, return any of them.



Example 1:

Input: s = "IDID"
Output: [0,4,1,3,2]

Example 2:

Input: s = "III"
Output: [0,1,2,3]

Example 3:

Input: s = "DDI"
Output: [3,2,0,1]



Constraints:

    1 <= s.length <= 105
    s[i] is either 'I' or 'D'.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(Arrays.toString(solution.diStringMatch("IDID")));
    System.out.println(Arrays.toString(solution.diStringMatch("III")));
    System.out.println(Arrays.toString(solution.diStringMatch("DDI")));
    System.out.println(Arrays.toString(solution.diStringMatch("I")));
    System.out.println(Arrays.toString(solution.diStringMatch("D")));
    System.out.println(Arrays.toString(solution.diStringMatch("DIDI")));
  }

  public int[] diStringMatch(String s) {
    var start = 0;
    var end = s.length();
    var result = new int[s.length() + 1];
    for (var i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'I') {
        result[i] = start++;
      } else if (s.charAt(i) == 'D') {
        result[i] = end--;
      }
    }
    if (s.charAt(s.length() - 1) == 'I') {
      result[s.length()] = start;
    } else if (s.charAt(s.length() - 1) == 'D') {
      result[s.length()] = end;
    }
    return result;
  }

}
