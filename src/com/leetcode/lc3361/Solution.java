package com.leetcode.lc3361;

import java.util.HashMap;

/*
3361. Shift Distance Between Two Strings

You are given two strings s and t of the same length, and two integer arrays nextCost and previousCost.

In one operation, you can pick any index i of s, and perform either one of the following actions:

    Shift s[i] to the next letter in the alphabet. If s[i] == 'z', you should replace it with 'a'. This operation costs nextCost[j] where j is the index of s[i] in the alphabet.
    Shift s[i] to the previous letter in the alphabet. If s[i] == 'a', you should replace it with 'z'. This operation costs previousCost[j] where j is the index of s[i] in the alphabet.

The shift distance is the minimum total cost of operations required to transform s into t.

Return the shift distance from s to t.



Example 1:

Input: s = "abab", t = "baba", nextCost = [100,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0], previousCost = [1,100,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]

Output: 2

Explanation:

    We choose index i = 0 and shift s[0] 25 times to the previous character for a total cost of 1.
    We choose index i = 1 and shift s[1] 25 times to the next character for a total cost of 0.
    We choose index i = 2 and shift s[2] 25 times to the previous character for a total cost of 1.
    We choose index i = 3 and shift s[3] 25 times to the next character for a total cost of 0.

Example 2:

Input: s = "leet", t = "code", nextCost = [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1], previousCost = [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]

Output: 31

Explanation:

    We choose index i = 0 and shift s[0] 9 times to the previous character for a total cost of 9.
    We choose index i = 1 and shift s[1] 10 times to the next character for a total cost of 10.
    We choose index i = 2 and shift s[2] 1 time to the previous character for a total cost of 1.
    We choose index i = 3 and shift s[3] 11 times to the next character for a total cost of 11.



Constraints:

    1 <= s.length == t.length <= 105
    s and t consist only of lowercase English letters.
    nextCost.length == previousCost.length == 26
    0 <= nextCost[i], previousCost[i] <= 109
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.shiftDistance("abab", "baba", new int[]{100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new int[]{1, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    System.out.println(solution.shiftDistance("leet", "code", new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
  }

  public long shiftDistance(String s, String t, int[] nextCost, int[] previousCost) {
    var result = 0L;
    var map = new HashMap<String, Long>();
    for (int i = 0; i < s.length(); i++) {
      var key = "" + s.charAt(i) + t.charAt(i);
      if (!map.containsKey(key)) {
        map.put(key, minShiftDistanceChar(s.charAt(i), t.charAt(i), nextCost, previousCost));
      }
      result += map.get(key);
    }
    return result;
  }

  private long minShiftDistanceChar(char s, char t, int[] nextCost, int[] previousCost) {
    if (s == t) return 0;
    var idxS = s - 97;
    var idxT = t - 97;
    var nextSum = 0L;
    var previousSum = 0L;
    if (s < t) {
      for (int i = idxS; i < idxT; i++) nextSum += nextCost[i];
      for (int i = 0; i <= idxS; i++) previousSum += previousCost[i];
      for (int i = idxT + 1; i < previousCost.length; i++) previousSum += previousCost[i];
    } else {
      for (int i = idxT + 1; i <= idxS; i++) previousSum += previousCost[i];
      for (int i = 0; i < idxT; i++) nextSum += nextCost[i];
      for (int i = idxS; i < nextCost.length; i++) nextSum += nextCost[i];
    }
    return Math.min(nextSum, previousSum);
  }
}
