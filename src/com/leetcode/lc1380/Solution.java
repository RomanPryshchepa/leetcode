package com.leetcode.lc1380;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
1380. Lucky Numbers in a Matrix

Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.



Example 1:

Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.

Example 2:

Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.

Example 3:

Input: matrix = [[7,8],[1,2]]
Output: [7]
Explanation: 7 is the only lucky number since it is the minimum in its row and the maximum in its column.



Constraints:

    m == mat.length
    n == mat[i].length
    1 <= n, m <= 50
    1 <= matrix[i][j] <= 105.
    All elements in the matrix are distinct.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.luckyNumbers(new int[][]{{3, 7, 8}, {9, 11, 13}, {15, 16, 17}}));
    System.out.println(solution.luckyNumbers(new int[][]{{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}}));
    System.out.println(solution.luckyNumbers(new int[][]{{7, 8}, {1, 2}}));
  }

  public List<Integer> luckyNumbers(int[][] matrix) {
    var result = new ArrayList<Integer>();
    var set = new HashSet<Integer>();
    var max = 1;
    var idxI = -1;
    var idxJ = -1;
    for (var j = 0; j < matrix[0].length; j++) {
      for (var i = 0; i < matrix.length; i++) {
        if (matrix[i][j] > max) {
          max = matrix[i][j];
          idxI = i;
          idxJ = j;
        }
      }
      set.add(idxI * 100 + idxJ);
      max = 1;
    }

    var min = Integer.MAX_VALUE;
    idxI = -1;
    idxJ = -1;
    for (var i = 0; i < matrix.length; i++) {
      for (var j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] < min) {
          min = matrix[i][j];
          idxI = i;
          idxJ = j;
        }
      }
      if (set.contains(idxI * 100 + idxJ)) {
        result.add(matrix[idxI][idxJ]);
      }
      min = Integer.MAX_VALUE;
    }
    return result;
  }
}
