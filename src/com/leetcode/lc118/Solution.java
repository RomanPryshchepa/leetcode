package com.leetcode.lc118;

import java.util.ArrayList;
import java.util.List;

/*
118. Pascal's Triangle

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:



Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:

Input: numRows = 1
Output: [[1]]



Constraints:

    1 <= numRows <= 30
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();

    var list = solution.generate(5);
    System.out.println(list);

    list = solution.generate(1);
    System.out.println(list);
  }

  public List<List<Integer>> generate(int numRows) {
    var result = new ArrayList<List<Integer>>();
    var list = new ArrayList<Integer>();
    list.add(1);
    result.add(new ArrayList<>(list));
    if (numRows == 1) {
      return result;
    }
    for (int i = 1; i < numRows; i++) {
      list.clear();
      list.add(1);
      for (int j = 1; j < i; j++) {
        list.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
      }
      list.add(1);
      result.add(new ArrayList<>(list));
    }
    return result;
  }
}
