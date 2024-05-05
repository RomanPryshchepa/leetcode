package com.leetcode.lc73;

import java.util.Arrays;
import java.util.HashSet;

/*
73. Set Matrix Zeroes

Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.



Example 1:

Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Example 2:

Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]



Constraints:

    m == matrix.length
    n == matrix[0].length
    1 <= m, n <= 200
    -231 <= matrix[i][j] <= 231 - 1



Follow up:

    A straightforward solution using O(mn) space is probably a bad idea.
    A simple improvement uses O(m + n) space, but still not the best solution.
    Could you devise a constant space solution?
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[][] matrix;

    matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
    solution.setZeroes(matrix);
    for (int i = 0; i < matrix.length; i++) {
      System.out.println(Arrays.toString(matrix[i]));
    }

    System.out.println();

    matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
    solution.setZeroes(matrix);
    for (int i = 0; i < matrix.length; i++) {
      System.out.println(Arrays.toString(matrix[i]));
    }
  }

  public void setZeroes(int[][] matrix) {
    HashSet<Integer> iSet = new HashSet<>();
    HashSet<Integer> jSet = new HashSet<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          iSet.add(i);
          jSet.add(j);
        }
      }
    }
    for (Integer i : iSet) {
      for (int j = 0; j < matrix[0].length; j++) {
        matrix[i][j] = 0;
      }
    }
    for (Integer j : jSet) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][j] = 0;
      }
    }
  }
}
