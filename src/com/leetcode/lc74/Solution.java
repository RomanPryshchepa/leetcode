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

    matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
    target = 60;
    System.out.println(searchMatrix(matrix, target)); // true

    matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
    target = 13;
    System.out.println(searchMatrix(matrix, target)); // false

    matrix = new int[][]{{1}, {2}};
    target = 2;
    System.out.println(searchMatrix(matrix, target)); // true
  }

  public static boolean searchMatrix(int[][] matrix, int target) {
    var start = 0;
    var end = matrix.length * matrix[0].length - 1;
    var mid = 0;
    var i = 0;
    var j = 0;
    while (start <= end) {
      mid = (start + end) >> 1;
      i = mid / matrix[0].length;
      j = mid % matrix[0].length;
      if (matrix[i][j] == target) {
        return true;
      }
      if (matrix[i][j] < target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return false;
  }
}
