package com.leetcode.lc695;

import java.util.concurrent.atomic.AtomicInteger;

/*
695. Max Area of Island

You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.



Example 1:

Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.

Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0



Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 50
    grid[i][j] is either 0 or 1.
 */
class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.maxAreaOfIsland(new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}}));
        System.out.println(solution.maxAreaOfIsland(new int[][]{{0,0,0,0,0,0,0,0}}));
    }

    public int maxAreaOfIsland(int[][] grid) {
        var result = 0;
        var area = new AtomicInteger(0);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    area = new AtomicInteger(0);
                    calculateArea(grid, i, j, area);
                    result = Math.max(result, area.get());
                }
            }
        }
        return result;
    }

    private void calculateArea(int[][] grid, int i, int j, AtomicInteger area) {
        if (grid[i][j] == 0)
            return;
        area.incrementAndGet();
        grid[i][j] = 0;
        if (i > 0 && grid[i - 1][j] == 1)
            calculateArea(grid, i - 1, j, area);
        if (i < grid.length - 1 && grid[i + 1][j] == 1)
            calculateArea(grid, i + 1, j, area);
        if (j > 0 && grid[i][j - 1] == 1)
            calculateArea(grid, i, j - 1, area);
        if (j < grid[0].length - 1 && grid[i][j + 1] == 1)
            calculateArea(grid, i, j + 1, area);
    }
}