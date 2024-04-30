package com.leetcode.lc54;

import java.util.ArrayList;
import java.util.List;

/*
54. Spiral Matrix

Given an m x n matrix, return all elements of the matrix in spiral order.



Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:

Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]



Constraints:

    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 10
    -100 <= matrix[i][j] <= 100


 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[][] matrix;

    matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    System.out.println(solution.spiralOrder(matrix)); // [1,2,3,6,9,8,7,4,5]

    matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    System.out.println(solution.spiralOrder(matrix)); // [1,2,3,4,8,12,11,10,9,5,6,7]

    matrix = new int[][]{{1, 2, 3}};
    System.out.println(solution.spiralOrder(matrix)); // [1,2,3]

    matrix = new int[][]{{1}, {2}, {3}};
    System.out.println(solution.spiralOrder(matrix)); // [1,2,3]
  }

  public List<Integer> spiralOrder(int[][] matrix) {
    int i = 0;
    int j = 0;
    int iS = i;
    int iF = matrix.length - 1;
    int jS = j;
    int jF = matrix[0].length - 1;
    List<Integer> list = new ArrayList<>();
    do {
      for (j = jS; j <= jF && list.size() < matrix.length * matrix[0].length; j++) {
        list.add(matrix[iS][j]);
      }
      iS++;
      for (i = iS; i <= iF && list.size() < matrix.length * matrix[0].length; i++) {
        list.add(matrix[i][jF]);
      }
      jF--;
      for (j = jF; j >= jS && list.size() < matrix.length * matrix[0].length; j--) {
        list.add(matrix[iF][j]);
      }
      iF--;
      for (i = iF; i >= iS && list.size() < matrix.length * matrix[0].length; i--) {
        list.add(matrix[i][jS]);
      }
      jS++;
    } while (list.size() < matrix.length * matrix[0].length);
    return list;
  }
}
