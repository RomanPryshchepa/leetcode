package com.leetcode.lc1275;

/*
1275. Find Winner on a Tic Tac Toe Game

Tic-tac-toe is played by two players A and B on a 3 x 3 grid. The rules of Tic-Tac-Toe are:

    Players take turns placing characters into empty squares ' '.
    The first player A always places 'X' characters, while the second player B always places 'O' characters.
    'X' and 'O' characters are always placed into empty squares, never on filled ones.
    The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
    The game also ends if all squares are non-empty.
    No more moves can be played if the game is over.

Given a 2D integer array moves where moves[i] = [rowi, coli] indicates that the ith move will be played on grid[rowi][coli]. return the winner of the game if it exists (A or B). In case the game ends in a draw return "Draw". If there are still movements to play return "Pending".

You can assume that moves is valid (i.e., it follows the rules of Tic-Tac-Toe), the grid is initially empty, and A will play first.



Example 1:

Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
Output: "A"
Explanation: A wins, they always play first.

Example 2:

Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
Output: "B"
Explanation: B wins.

Example 3:

Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
Output: "Draw"
Explanation: The game ends in a draw since there are no moves to make.

 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[][] moves;

    moves = new int[][]{{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}};
    System.out.println(solution.tictactoe(moves)); // "A"

    moves = new int[][]{{0, 0}, {1, 1}, {0, 1}, {0, 2}, {1, 0}, {2, 0}};
    System.out.println(solution.tictactoe(moves)); // "B"

    moves = new int[][]{{0, 0}, {1, 1}, {2, 0}, {1, 0}, {1, 2}, {2, 1}, {0, 1}, {0, 2}, {2, 2}};
    System.out.println(solution.tictactoe(moves)); // "Draw"
  }

  public String tictactoe(int[][] moves) {
    int[][] field = new int[3][3];
    for (int i = 0; i < moves.length; i++) {
      if (i % 2 == 0) {
        field[moves[i][0]][moves[i][1]] = 1;
      } else {
        field[moves[i][0]][moves[i][1]] = 2;
      }
    }

    for (int i = 0; i < field.length; i++) {
      if (field[i][0] == 1 && field[i][1] == 1 && field[i][2] == 1) {
        return "A";
      }
      if (field[i][0] == 2 && field[i][1] == 2 && field[i][2] == 2) {
        return "B";
      }
      if (field[0][i] == 1 && field[1][i] == 1 && field[2][i] == 1) {
        return "A";
      }
      if (field[0][i] == 2 && field[1][i] == 2 && field[2][i] == 2) {
        return "B";
      }
    }
    if (field[0][0] == 1 && field[1][1] == 1 && field[2][2] == 1) {
      return "A";
    }
    if (field[0][0] == 2 && field[1][1] == 2 && field[2][2] == 2) {
      return "B";
    }
    if (field[0][2] == 1 && field[1][1] == 1 && field[2][0] == 1) {
      return "A";
    }
    if (field[0][2] == 2 && field[1][1] == 2 && field[2][0] == 2) {
      return "B";
    }
    if (moves.length < 9) {
      return "Pending";
    } else {
      return "Draw";
    }
  }
}
