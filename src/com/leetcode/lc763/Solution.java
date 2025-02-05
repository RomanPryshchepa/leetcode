package com.leetcode.lc763;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
763. Partition Labels

You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

Return a list of integers representing the size of these parts.



Example 1:

Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.

Example 2:

Input: s = "eccbbbbdec"
Output: [10]



Constraints:

    1 <= s.length <= 500
    s consists of lowercase English letters.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.partitionLabels("ababcbacadefegdehijhklij"));
    System.out.println(solution.partitionLabels("eccbbbbdec"));
    System.out.println(solution.partitionLabels("abc"));
  }

  public List<Integer> partitionLabels(String s) {
    var result = new LinkedList<Integer>();
    var map = new HashMap<Character, Integer>();
    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), s.lastIndexOf(s.charAt(i)));
    }
    var start = 0;
    var i = 0;
    var end = -1;
    while (i < s.length()) {
      end = Math.max(end, map.get(s.charAt(i)));
      if (i == end) {
        result.add(end - start + 1);
        start = i + 1;
      }
      i++;
    }
    return result;
  }
}
