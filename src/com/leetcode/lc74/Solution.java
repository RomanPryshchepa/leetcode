package com.leetcode.lc74;

/*
74. Search a 2D Matrix

You are given an m x n integer matrix matrix with the following two properties:

    Each row is sorted in non-decreasing order.
    The first integer of each row is greater than the last integer of the previous row.

Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.



Example 1:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false



Constraints:

    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 100
    -104 <= matrix[i][j], target <= 104

 */
public class Solution {

  public static void main(String[] args) {
    int[][] matrix;
    int target;
    //Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
    //Output: true
    matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
    target = 60;
    System.out.println(searchMatrix(matrix, target));
    //Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
    //Output: false
    matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
    target = 13;
//    System.out.println(searchMatrix(matrix, target));

    matrix = new int[][]{{1}, {2}};
    target = 2;
//    System.out.println(searchMatrix(matrix, target));
//    getIJ(5, 3);
  }

  public static boolean searchMatrix(int[][] matrix, int target) {
    int n = matrix.length;
    int m = matrix[0].length;
    int leftI = 0;
    int rightI = n * m - 1;
    do {
      int centerI = leftI + (rightI - leftI) / 2;
      int center = matrix[centerI / m][centerI % m];
      int left = matrix[leftI / m][leftI % m];
      int right = matrix[rightI / m][rightI % m];
      if (target == center || target == left || target == right) {
        return true;
      }
      if (target < center) {
        rightI = centerI;
      } else {
        leftI = centerI;
      }
    } while (rightI - leftI > 1);
    return false;
  }

  public static void getIJ(int m, int n) {
//    int o = Math.max(m, n);
    for (int k = 1; k <= m * n; k++) {
      int i = (k - 1) / m;
      int j = (k - 1) % m;
      System.out.println("k = %d [i, j] = [%d, %d]".formatted(k, i, j));
    }
  }
}
