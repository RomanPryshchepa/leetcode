package com.leetcode.lc79;

/*
79. Word Search

Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.



Example 1:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false



Constraints:

    m == board.length
    n = board[i].length
    1 <= m, n <= 6
    1 <= word.length <= 15
    board and word consists of only lowercase and uppercase English letters.



Follow up: Could you use search pruning to make your solution faster with a larger board?
 */
public class Solution {
    private int rows;
    private int cols;
    private String targetWord;
    private char[][] grid;

    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
        System.out.println(solution.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE"));
        System.out.println(solution.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB"));
    }

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        this.targetWord = word;
        this.grid = board;
        for (var row = 0; row < rows; row++)
            for (var col = 0; col < cols; col++)
                if (dfs(row, col, 0))
                    return true;
        return false;
    }

    private boolean dfs(int row, int col, int charIndex) {
        if (charIndex == targetWord.length() - 1)
            return grid[row][col] == targetWord.charAt(charIndex);
        if (grid[row][col] != targetWord.charAt(charIndex))
            return false;
        char originalChar = grid[row][col];
        grid[row][col] = '0';
        int[] directions = {-1, 0, 1, 0, -1};
        for (var dir = 0; dir < 4; dir++) {
            int nextRow = row + directions[dir];
            int nextCol = col + directions[dir + 1];
            if (nextRow >= 0 && nextRow < rows &&
                    nextCol >= 0 && nextCol < cols &&
                    grid[nextRow][nextCol] != '0' &&
                    dfs(nextRow, nextCol, charIndex + 1))
                return true;
        }
        grid[row][col] = originalChar;
        return false;
    }
}
