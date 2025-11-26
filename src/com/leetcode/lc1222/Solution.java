package com.leetcode.lc1222;

import java.util.LinkedList;
import java.util.List;

/*
1222. Queens That Can Attack the King

On a 0-indexed 8 x 8 chessboard, there can be multiple black queens and one white king.

You are given a 2D integer array queens where queens[i] = [xQueeni, yQueeni] represents the position of the ith black queen on the chessboard. You are also given an integer array king of length 2 where king = [xKing, yKing] represents the position of the white king.

Return the coordinates of the black queens that can directly attack the king. You may return the answer in any order.



Example 1:

Input: queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]
Output: [[0,1],[1,0],[3,3]]
Explanation: The diagram above shows the three queens that can directly attack the king and the three queens that cannot attack the king (i.e., marked with red dashes).

Example 2:

Input: queens = [[0,0],[1,1],[2,2],[3,4],[3,5],[4,4],[4,5]], king = [3,3]
Output: [[2,2],[3,4],[4,4]]
Explanation: The diagram above shows the three queens that can directly attack the king and the three queens that cannot attack the king (i.e., marked with red dashes).



Constraints:

    1 <= queens.length < 64
    queens[i].length == king.length == 2
    0 <= xQueeni, yQueeni, xKing, yKing < 8
    All the given positions are unique.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.queensAttacktheKing(new int[][]{{0, 1}, {1, 0}, {4, 0}, {0, 4}, {3, 3}, {2, 4}}, new int[]{0, 0}));
    System.out.println(solution.queensAttacktheKing(new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 4}, {3, 5}, {4, 4}, {4, 5}}, new int[]{3, 3}));
  }

  public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
    var result = new LinkedList<List<Integer>>();
    var kingI = king[0];
    var kingJ = king[1];
    var size = 8;
    for (int i = kingI - 1; i >= 0; i--) {
      if (isQueenInQueens(i, kingJ, queens)) {
        addQueen(i, kingJ, result);
        break;
      }
    }
    for (int i = kingI + 1; i < size; i++) {
      if (isQueenInQueens(i, kingJ, queens)) {
        addQueen(i, kingJ, result);
        break;
      }
    }
    for (var j =  kingJ - 1; j >= 0; j--) {
      if (isQueenInQueens(kingI, j, queens)) {
        addQueen(kingI, j, result);
        break;
      }
    }
    for (var j = kingJ + 1; j < size; j++) {
      if (isQueenInQueens(kingI, j, queens)) {
        addQueen(kingI, j, result);
        break;
      }
    }
    for (int i = kingI - 1, j = kingJ - 1; i >= 0 && j >= 0; i--, j--) {
      if (isQueenInQueens(i, j, queens)) {
        addQueen(i, j, result);
        break;
      }
    }
    for (int i = kingI + 1, j = kingJ + 1; i < size && j < size; i++, j++) {
      if (isQueenInQueens(i, j, queens)) {
        addQueen(i, j, result);
        break;
      }
    }
    for (int i = kingI - 1, j = kingJ + 1; i >= 0 && j < size; i--, j++) {
      if (isQueenInQueens(i, j, queens)) {
        addQueen(i, j, result);
        break;
      }
    }
    for (int i = kingI + 1, j = kingJ - 1; i < size && j >= 0; i++, j--) {
      if (isQueenInQueens(i, j, queens)) {
        addQueen(i, j, result);
        break;
      }
    }
    return result;
  }

  private boolean isQueenInQueens(int i, int j, int[][] queens) {
    for (var queen : queens) {
      if (queen[0] == i && queen[1] == j)
        return true;
    }
    return false;
  }

  private void addQueen(int i, int j, List<List<Integer>> queens) {
    var list = new LinkedList<Integer>();
    list.add(i);
    list.add(j);
    queens.add(list);
  }
}
