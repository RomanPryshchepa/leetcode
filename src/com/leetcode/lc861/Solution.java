package com.leetcode.lc861;

/*
861. Score After Flipping Matrix

You are given an m x n binary matrix grid.

A move consists of choosing any row or column and toggling each value in that row or column (i.e., changing all 0's to 1's, and all 1's to 0's).

Every row of the matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.

Return the highest possible score after making any number of moves (including zero moves).



Example 1:

Input: grid = [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
Output: 39
Explanation: 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39

Example 2:

Input: grid = [[0]]
Output: 1



Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 20
    grid[i][j] is either 0 or 1.
 */
public class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.matrixScore(new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0},{1, 1, 0, 0}}));
        System.out.println(solution.matrixScore(new int[][]{{0}}));
    }

    public int matrixScore(int[][] grid) {
        for (var i = 0; i < grid.length; i++)
            if (grid[i][0] == 0)
                toggleRow(grid, i);
        for (var j = 0; j < grid[0].length; j++)
            if (sumColumn(grid, j) < (grid.length + 1) / 2)
                toggleColumn(grid, j);
        var result = 0;
        for (int[] ints : grid) result += rowToScore(ints);
        return result;
    }

    private void toggleRow(int[][] grid, int i) {
        for (var j = 0; j < grid[i].length; j++)
            grid[i][j] = 1 - grid[i][j];
    }

    private void toggleColumn(int[][] grid, int j) {
        for (var i = 0; i < grid.length; i++)
            grid[i][j] = 1 - grid[i][j];
    }

    private int sumColumn(int[][] grid, int j) {
        var sum = 0;
        for (int[] ints : grid) sum += ints[j];
        return sum;
    }

    private int rowToScore(int[] row) {
        var result = 0;
        for (var i = 0; i < row.length; i++)
            result += row[i] * (1 << row.length - i - 1);
        return result;
    }
}
