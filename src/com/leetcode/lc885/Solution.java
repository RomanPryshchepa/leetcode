package com.leetcode.lc885;

import java.util.Arrays;

/*
885. Spiral Matrix III

You start at the cell (rStart, cStart) of an rows x cols grid facing east. The northwest corner is at the first row and column in the grid, and the southeast corner is at the last row and column.

You will walk in a clockwise spiral shape to visit every position in this grid. Whenever you move outside the grid's boundary, we continue our walk outside the grid (but may return to the grid boundary later.). Eventually, we reach all rows * cols spaces of the grid.

Return an array of coordinates representing the positions of the grid in the order you visited them.



Example 1:

Input: rows = 1, cols = 4, rStart = 0, cStart = 0
Output: [[0,0],[0,1],[0,2],[0,3]]

Example 2:

Input: rows = 5, cols = 6, rStart = 1, cStart = 4
Output: [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]



Constraints:

    1 <= rows, cols <= 100
    0 <= rStart < rows
    0 <= cStart < cols
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(Arrays.deepToString(solution.spiralMatrixIII(1, 4, 0, 0)));
    System.out.println(Arrays.deepToString(solution.spiralMatrixIII(5, 6, 1, 4)));
  }

  public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
    var result = new int[rows * cols][2];
    var k = 0;
    result[k++] = new int[] { rStart, cStart };
    var direction = 'R'; // R (right), D (down), L (left), U (up)
    var steps = 1;
    var step = 0;
    while (k < rows * cols) {
      switch (direction) {
        case 'R':
          cStart++;
          step++;
          if (step == steps) {
            step = 0;
            direction = 'D';
          }
          break;
        case 'D':
          rStart++;
          step++;
          if (step == steps) {
            step = 0;
            steps++;
            direction = 'L';
          }
          break;
        case 'L':
          cStart--;
          step++;
          if (step == steps) {
            step = 0;
            direction = 'U';
          }
          break;
        case 'U':
          rStart--;
          step++;
          if (step == steps) {
            step = 0;
            steps++;
            direction = 'R';
          }
          break;
      }
      if (cStart >= 0 && cStart < cols && rStart >= 0 && rStart < rows)
        result[k++] = new int[] { rStart, cStart };
    }
    return result;
  }
}
