package com.leetcode.lc22;

import java.util.ArrayList;
import java.util.List;

/*
22. Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:

Input: n = 1
Output: ["()"]



Constraints:

    1 <= n <= 8
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.generateParenthesis(3));
  }

  public List<String> generateParenthesis(int n) {
    var list = new ArrayList<String>();
    ParenthesisGenerator(list, "", 0, 0, n);
    return list;
  }

  private void ParenthesisGenerator(List<String> list, String str, int open, int close, int n) {
    if (close == n) {
      list.add(str);
    } else {
      if (open > close) {
        ParenthesisGenerator(list, str + ")", open, close + 1, n);
      }
      if (open < n) {
        ParenthesisGenerator(list, str + "(", open + 1, close, n);
      }
    }
  }
}
