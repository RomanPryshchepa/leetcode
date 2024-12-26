package com.leetcode.lc1582;

/*
1582. Special Positions in a Binary Matrix

Given an m x n binary matrix mat, return the number of special positions in mat.

A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).



Example 1:

Input: mat = [[1,0,0],[0,0,1],[1,0,0]]
Output: 1
Explanation: (1, 2) is a special position because mat[1][2] == 1 and all other elements in row 1 and column 2 are 0.

Example 2:

Input: mat = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
Explanation: (0, 0), (1, 1) and (2, 2) are special positions.



Constraints:

    m == mat.length
    n == mat[i].length
    1 <= m, n <= 100
    mat[i][j] is either 0 or 1.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.numSpecial(new int[][]{
        {1, 0, 0},
        {0, 0, 1},
        {1, 0, 0}
    })); // 1

    System.out.println(solution.numSpecial(new int[][]{
        {1, 0, 0},
        {0, 1, 0},
        {0, 0, 1}
    })); // 3

    System.out.println(solution.numSpecial(new int[][]{
        {0, 0, 0},
        {0, 0, 0},
        {0, 0, 0}
    })); // 0

    System.out.println(solution.numSpecial(new int[][]{
        {1, 0, 0},
        {1, 1, 0},
        {0, 1, 0}
    })); // 0

    System.out.println(solution.numSpecial(new int[][]{
        {1, 0, 0},
        {1, 1, 0},
        {0, 1, 0},
        {0, 0, 1}
    })); // 1

    System.out.println(solution.numSpecial(new int[][]{
        {0, 0, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 1, 0, 0, 1},
        {0, 0, 0, 0, 1, 0, 0, 0},
        {1, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 1, 1, 0, 0, 0, 0}
    })); // 1

    System.out.println(solution.numSpecial(new int[][]{
        {0, 0, 0, 0},
        {0, 1, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 1, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 1, 1, 0}
    })); // 0
  }

  public int numSpecial(int[][] mat) {
    var iSums = new int[mat.length];
    var jSums = new int[mat[0].length];
    var res = 0;
    for (int i = 0; i < mat.length; i++) {
      var tmpSum = 0;
      for (int j = 0; j < mat[i].length; j++) {
        tmpSum += mat[i][j];
      }
      iSums[i] = tmpSum;
    }

    for (int j = 0; j < mat[0].length; j++) {
      var tmpSum = 0;
      for (int i = 0; i < mat.length; i++) {
        tmpSum += mat[i][j];
      }
      jSums[j] = tmpSum;
    }

    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        if (mat[i][j] == 1 && iSums[i] == 1 && jSums[j] == 1) {
          res++;
        }
      }
    }
    return res;
  }

  public int numSpecial1(int[][] mat) {
    var iSums = new int[mat.length];
    var res = 0;
    for (int i = 0; i < mat.length; i++) {
      var tmpSum = 0;
      for (int j = 0; j < mat[i].length; j++) {
        tmpSum += mat[i][j];
      }
      iSums[i] = tmpSum;
    }

    for (int j = 0; j < mat[0].length; j++) {
      var correct1Sum = 0;
      var incorrect1Sum = 0;
      for (int i = 0; i < mat.length; i++) {
        if (mat[i][j] == 1 && iSums[i] == 1) {
          correct1Sum++;
        } else if (mat[i][j] == 1) {
          incorrect1Sum++;
        }
      }
      if (correct1Sum == 1 && incorrect1Sum == 0) {
        res++;
      }
    }
    return res;
  }
}
