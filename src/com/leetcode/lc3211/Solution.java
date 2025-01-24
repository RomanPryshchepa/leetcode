package com.leetcode.lc3211;

import java.util.ArrayList;
import java.util.List;

/*
3211. Generate Binary Strings Without Adjacent Zeros

You are given a positive integer n.

A binary string x is valid if all
substrings
of x of length 2 contain at least one "1".

Return all valid strings with length n, in any order.



Example 1:

Input: n = 3

Output: ["010","011","101","110","111"]

Explanation:

The valid strings of length 3 are: "010", "011", "101", "110", and "111".

Example 2:

Input: n = 1

Output: ["0","1"]

Explanation:

The valid strings of length 1 are: "0" and "1".



Constraints:

    1 <= n <= 18
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.validStrings(3));
    System.out.println(solution.validStrings(1));
  }

  public List<String> validStrings(int n) {
    var result = new ArrayList<String>();
    result.add("0");
    result.add("1");
    if (n == 1) {
      return result;
    }
    while (result.get(0).length() < n) {
      var count = result.size();
      for (int i = 0; i < count; i++) {
        if (result.get(0).endsWith("1")) {
          result.add(result.get(0) + "0");
        }
        result.add(result.get(0) + "1");
        result.remove(result.get(0));
      }
    }
    return result;
  }
}
