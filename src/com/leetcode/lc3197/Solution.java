package com.leetcode.lc3197;

/*
3197. Find the Minimum Area to Cover All Ones II

You are given a 2D binary array grid. You need to find 3 non-overlapping rectangles having non-zero areas with horizontal and vertical sides such that all the 1's in grid lie inside these rectangles.

Return the minimum possible sum of the area of these rectangles.

Note that the rectangles are allowed to touch.



Example 1:

Input: grid = [[1,0,1],[1,1,1]]

Output: 5

Explanation:

    The 1's at (0, 0) and (1, 0) are covered by a rectangle of area 2.
    The 1's at (0, 2) and (1, 2) are covered by a rectangle of area 2.
    The 1 at (1, 1) is covered by a rectangle of area 1.

Example 2:

Input: grid = [[1,0,1,0],[0,1,0,1]]

Output: 5

Explanation:

    The 1's at (0, 0) and (0, 2) are covered by a rectangle of area 3.
    The 1 at (1, 1) is covered by a rectangle of area 1.
    The 1 at (1, 3) is covered by a rectangle of area 1.



Constraints:

    1 <= grid.length, grid[i].length <= 30
    grid[i][j] is either 0 or 1.
    The input is generated such that there are at least three 1's in grid.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.minimumSum(new int[][]{{1, 0, 1}, {1, 1, 1}}));
    System.out.println(solution.minimumSum(new int[][]{{1, 0, 1, 0}, {0, 1, 0, 1}}));
    System.out.println(solution.minimumSum(new int[][]{{1, 0, 1, 0, 1}, {0, 1, 0, 1, 0}, {1, 0, 1, 0, 1}, {0, 1, 0, 1, 0}, {1, 0, 1, 0, 1}}));
  }

  public int minimumSum(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    int minArea = rows * cols;
    for (int div1 = 0; div1 < rows - 1; div1++) {
      for (int div2 = div1 + 1; div2 < rows - 1; div2++) {
        int top = getMinArea(grid, 0, 0, div1, cols - 1);
        int middle = getMinArea(grid, div1 + 1, 0, div2, cols - 1);
        int bottom = getMinArea(grid, div2 + 1, 0, rows - 1, cols - 1);
        minArea = Math.min(minArea, top + middle + bottom);
      }
    }

    for (int div1 = 0; div1 < cols - 1; div1++) {
      for (int div2 = div1 + 1; div2 < cols - 1; div2++) {
        int left = getMinArea(grid, 0, 0, rows - 1, div1);
        int middle = getMinArea(grid, 0, div1 + 1, rows - 1, div2);
        int right = getMinArea(grid, 0, div2 + 1, rows - 1, cols - 1);
        minArea = Math.min(minArea, left + middle + right);
      }
    }

    for (int divI = 0; divI < rows - 1; divI++) {
      for (int divJ = 0; divJ < cols - 1; divJ++) {
        int topL = getMinArea(grid, 0, 0, divI, divJ);
        int topR = getMinArea(grid, 0, divJ + 1, divI, cols - 1);
        int bottom = getMinArea(grid, divI + 1, 0, rows - 1, cols - 1);
        minArea = Math.min(minArea, topL + topR + bottom);

        int top = getMinArea(grid, 0, 0, divI, cols - 1);
        int bottomL = getMinArea(grid, divI + 1, 0, rows - 1, divJ);
        int bottomR = getMinArea(grid, divI + 1, divJ + 1, rows - 1, cols - 1);
        minArea = Math.min(minArea, top + bottomL + bottomR);

        topL = getMinArea(grid, 0, 0, divI, divJ);
        bottomL = getMinArea(grid, divI + 1, 0, rows - 1, divJ);
        int right = getMinArea(grid, 0, divJ + 1, rows - 1, cols - 1);
        minArea = Math.min(minArea, topL + bottomL + right);

        int left = getMinArea(grid, 0, 0, rows - 1, divJ);
        topR = getMinArea(grid, 0, divJ + 1, divI, cols - 1);
        bottomR = getMinArea(grid, divI + 1, divJ + 1, rows - 1, cols - 1);
        minArea = Math.min(minArea, left + topR + bottomR);
      }
    }
    return minArea;
  }

  private int getMinArea(int[][] grid, int i1, int j1, int i2, int j2) {
    var minI = Integer.MAX_VALUE;
    var maxI = Integer.MIN_VALUE;
    var minJ = Integer.MAX_VALUE;
    var maxJ = Integer.MIN_VALUE;

    for (int row = i1; row <= i2; row++) {
      for (int col = j1; col <= j2; col++) {
        if (grid[row][col] == 1) {
          minI = Math.min(minI, row);
          minJ = Math.min(minJ, col);
          maxI = Math.max(maxI, row);
          maxJ = Math.max(maxJ, col);
        }
      }
    }
    return (maxI - minI + 1) * (maxJ - minJ + 1);
  }
}
