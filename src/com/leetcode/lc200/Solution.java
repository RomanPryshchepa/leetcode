package com.leetcode.lc200;

/*
200. Number of Islands

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.



Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3



Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 300
    grid[i][j] is '0' or '1'.
 */
public class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        var grid = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(solution.numIslands(grid));

        grid = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(solution.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        var cnt = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == '1') {
                    isIsland(grid, i, j);
                    cnt++;
                }
        return cnt;
    }

    private void isIsland(char[][] grid, int row, int col) {
        if (grid[row][col] == '0')
            return;
        grid[row][col] = '0';
        if (row > 0)
            isIsland(grid, row - 1, col);
        if (row < grid.length - 1)
            isIsland(grid, row + 1, col);
        if (col > 0) {
            isIsland(grid, row, col - 1);
        }
        if (col < grid[0].length - 1)
            isIsland(grid, row, col + 1);
    }
}
