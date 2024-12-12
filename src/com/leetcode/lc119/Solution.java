package com.leetcode.lc119;

import java.util.ArrayList;
import java.util.List;

/*
119. Pascal's Triangle II

Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:



Example 1:

Input: rowIndex = 3
Output: [1,3,3,1]

Example 2:

Input: rowIndex = 0
Output: [1]

Example 3:

Input: rowIndex = 1
Output: [1,1]



Constraints:

    0 <= rowIndex <= 33



Follow up: Could you optimize your algorithm to use only O(rowIndex) extra space?
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.getRow(3));
    System.out.println(solution.getRow(0));
    System.out.println(solution.getRow(1));
  }

  public List<Integer> getRow(int rowIndex) {
    var result = new ArrayList<ArrayList<Integer>>();
    var list = new ArrayList<Integer>();
    list.add(1);
    result.add(new ArrayList<>(list));
    if (rowIndex == 0) {
      return list;
    }
    for (int i = 1; i <= rowIndex; i++) {
      list.clear();
      list.add(1);
      for (int j = 1; j < i; j++) {
        list.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
      }
      list.add(1);
      result.add(new ArrayList<>(list));
    }
    return result.get(result.size() - 1);
  }
}
