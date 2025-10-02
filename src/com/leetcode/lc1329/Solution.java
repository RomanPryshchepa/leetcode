package com.leetcode.lc1329;

import java.util.ArrayList;
import java.util.Arrays;

/*
1329. Sort the Matrix Diagonally

A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost column and going in the bottom-right direction until reaching the matrix's end. For example, the matrix diagonal starting from mat[2][0], where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and mat[4][2].

Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.



Example 1:

Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]

Example 2:

Input: mat = [[11,25,66,1,69,7],[23,55,17,45,15,52],[75,31,36,44,58,8],[22,27,33,25,68,4],[84,28,14,11,5,50]]
Output: [[5,17,4,1,52,7],[11,11,25,45,8,69],[14,23,25,44,58,15],[22,27,31,36,50,66],[84,28,75,33,55,68]]



Constraints:

    m == mat.length
    n == mat[i].length
    1 <= m, n <= 100
    1 <= mat[i][j] <= 100
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(Arrays.deepToString(solution.diagonalSort(new int[][] { { 3, 3, 1, 1 }, { 2, 2, 1, 2 }, { 1, 1, 1, 2 } })));
    System.out.println(Arrays.deepToString(solution.diagonalSort(new int[][] { { 11, 25, 66, 1, 69, 7 }, { 23, 55, 17, 45, 15, 52 }, { 75, 31, 36, 44, 58, 8 }, { 22, 27, 33, 25, 68, 4 }, { 84, 28, 14, 11, 5, 50 } })));
  }

  public int[][] diagonalSort(int[][] mat) {
    var result = new int[mat.length][];
    for (var k = 0; k < mat.length; k++)
      result[k] = new int[mat[k].length];
    var list = new ArrayList<Integer>();
    int i;
    int j;
    for (int startJ = mat[0].length - 1; startJ > 0; startJ--) {
      list.clear();
      i = 0;
      j = startJ;
      while (i < mat.length && j < mat[0].length) {
        list.add(mat[i][j]);
        i++;
        j++;
      }
      list.sort(Integer::compareTo);
      i = 0;
      j = startJ;
      while (i < mat.length && j < mat[0].length) {
        result[i][j] = list.get(i);
        i++;
        j++;
      }
    }
    for (int startI = 0; startI < mat.length; startI++) {
      list.clear();
      i = startI;
      j = 0;
      while (i < mat.length && j < mat[0].length) {
        list.add(mat[i][j]);
        i++;
        j++;
      }
      list.sort(Integer::compareTo);
      i = startI;
      j = 0;
      while (i < mat.length && j < mat[0].length) {
        result[i][j] = list.get(j);
        i++;
        j++;
      }
    }
    return result;
  }
}
