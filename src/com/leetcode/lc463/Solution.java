package com.leetcode.lc463;

/*
463. Island Perimeter

You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.



Example 1:

Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image above.

Example 2:

Input: grid = [[1]]
Output: 4

Example 3:

Input: grid = [[1,0]]
Output: 4



Constraints:

    row == grid.length
    col == grid[i].length
    1 <= row, col <= 100
    grid[i][j] is 0 or 1.
    There is exactly one island in grid.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[][] grid;

    grid = new int[][] {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
    System.out.println(solution.islandPerimeter(grid)); //16

    grid = new int[][] {{1}};
    System.out.println(solution.islandPerimeter(grid)); //4

    grid = new int[][] {{1,0}};
    System.out.println(solution.islandPerimeter(grid)); //4
  }

  public int islandPerimeter(int[][] grid) {
    int result = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1) result += countEmptyNeighbors(grid, i, j);
      }
    }
    return result;
  }

  public static int countNeighbors(int[][] arr, int i, int j) {
    int count = 0;
    if (i > 0 && arr[i-1][j] == 1) count++;
    if (j > 0 && arr[i][j-1] == 1) count++;
    if (i < arr.length - 1 && arr[i+1][j] == 1) count++;
    if (j < arr[0].length - 1 && arr[i][j+1] == 1) count++;
    return count;
  }

  public static int countEmptyNeighbors(int[][] arr, int i, int j) {
    int count = 0;
    if (i > 0 && arr[i-1][j] == 0 || i == 0) count++;
    if (j > 0 && arr[i][j-1] == 0 || j == 0) count++;
    if (i < arr.length - 1 && arr[i+1][j] == 0 || i == arr.length - 1) count++;
    if (j < arr[0].length - 1 && arr[i][j+1] == 0 || j == arr[0].length - 1) count++;
    return count;
  }
}
