package com.leetcode.lc37;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
37. Sudoku Solver

Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

    Each of the digits 1-9 must occur exactly once in each row.
    Each of the digits 1-9 must occur exactly once in each column.
    Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.

The '.' character indicates empty cells.



Example 1:

Input: board = [["5","3",".",".","7",".",".",".","."}, {"6",".",".","1","9","5",".",".","."}, {".","9","8",".",".",".",".","6","."}, {"8",".",".",".","6",".",".",".","3"}, {"4",".",".","8",".","3",".",".","1"}, {"7",".",".",".","2",".",".",".","6"}, {".","6",".",".",".",".","2","8","."}, {".",".",".","4","1","9",".",".","5"}, {".",".",".",".","8",".",".","7","9"]]
Output: [["5","3","4","6","7","8","9","1","2"}, {"6","7","2","1","9","5","3","4","8"}, {"1","9","8","3","4","2","5","6","7"}, {"8","5","9","7","6","1","4","2","3"}, {"4","2","6","8","5","3","7","9","1"}, {"7","1","3","9","2","4","8","5","6"}, {"9","6","1","5","3","7","2","8","4"}, {"2","8","7","4","1","9","6","3","5"}, {"3","4","5","2","8","6","1","7","9"]]
Explanation: The input board is shown above and the only valid solution is shown below:




Constraints:

    board.length == 9
    board[i].length == 9
    board[i][j] is a digit or '.'.
    It is guaranteed that the input board has only one solution.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    var board = new char[][] {
        {'5','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}
    };
    solution.solveSudoku(board);
    System.out.println(Arrays.deepToString(board));
  }

  private final boolean[][] rows = new boolean[9][9];
  private final boolean[][] cols = new boolean[9][9];
  private final boolean[][][] boxes = new boolean[3][3][9];
  private final List<Integer> emptyCells = new ArrayList<>();
  private boolean isSolution;

  public void solveSudoku(char[][] board) {
    for (int row = 0; row < 9; row++) {
      for (int col = 0; col < 9; col++) {
        if (board[row][col] == '.') {
          emptyCells.add(row * 9 + col);
        } else {
          int digit = board[row][col] - '1';
          rows[row][digit] = true;
          cols[col][digit] = true;
          boxes[row / 3][col / 3][digit] = true;
        }
      }
    }
    dfs(board,0);
  }

  private void dfs(char[][] board, int emptyCellIndex) {
    if (emptyCellIndex == emptyCells.size()) {
      isSolution = true;
      return;
    }
    int position = emptyCells.get(emptyCellIndex);
    int row = position / 9;
    int col = position % 9;
    for (int digit = 0; digit < 9; digit++) {
      if (!rows[row][digit] && !cols[col][digit] && !boxes[row / 3][col / 3][digit]) {
        rows[row][digit] = true;
        cols[col][digit] = true;
        boxes[row / 3][col / 3][digit] = true;
        board[row][col] = (char) (digit + '1');
        dfs(board,emptyCellIndex + 1);
        rows[row][digit] = false;
        cols[col][digit] = false;
        boxes[row / 3][col / 3][digit] = false;
      }
      if (isSolution) {
        return;
      }
    }
  }
}
