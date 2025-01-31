package com.leetcode.lc1861;

import java.util.Arrays;

/*
1861. Rotating the Box

You are given an m x n matrix of characters boxGrid representing a side-view of a box. Each cell of the box is one of the following:

    A stone '#'
    A stationary obstacle '*'
    Empty '.'

The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity. Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box. Gravity does not affect the obstacles' positions, and the inertia from the box's rotation does not affect the stones' horizontal positions.

It is guaranteed that each stone in boxGrid rests on an obstacle, another stone, or the bottom of the box.

Return an n x m matrix representing the box after the rotation described above.



Example 1:

Input: boxGrid = [["#",".","#"]]
Output: [["."],
         ["#"],
         ["#"]]

Example 2:

Input: boxGrid = [["#",".","*","."],
              ["#","#","*","."]]
Output: [["#","."],
         ["#","#"],
         ["*","*"],
         [".","."]]

Example 3:

Input: boxGrid = [["#","#","*",".","*","."],
              ["#","#","#","*",".","."],
              ["#","#","#",".","#","."]]
Output: [[".","#","#"],
         [".","#","#"],
         ["#","#","*"],
         ["#","*","."],
         ["#",".","*"],
         ["#",".","."]]



Constraints:

    m == boxGrid.length
    n == boxGrid[i].length
    1 <= m, n <= 500
    boxGrid[i][j] is either '#', '*', or '.'.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(Arrays.deepToString(solution.rotateTheBox(new char[][] {{'#','.','#'}})));
    System.out.println(Arrays.deepToString(solution.rotateTheBox(new char[][] {{'#','.','*','.'}, {'#','#','*','.'}})));
    System.out.println(Arrays.deepToString(solution.rotateTheBox(new char[][] {{'#','#','*','.','*','.'}, {'#','#','#','*','.','.'}, {'#','#','#','.','#','.'}})));
  }

  public char[][] rotateTheBox(char[][] boxGrid) {
    var result = new char[boxGrid[0].length][boxGrid.length];
    for (char[] chars : boxGrid) {
      shift(chars);
    }
    for (int i = 0; i < boxGrid.length; i++) {
      for (int j = 0; j < boxGrid[i].length; j++) {
        result[j][boxGrid.length - 1 - i] = boxGrid[i][j];
      }
    }
    return result;
  }

  private void shift(char[] arr) {
    var i = arr.length - 1;
    var j = arr.length - 2;
    while (i >= 0 && j >= 0) {
      if (arr[j] == '#' && arr[i] == '.') {
        arr[i] = '#';
        arr[j] = '.';
        i--;
        j--;
      } else if (arr[j] == '*') {
        i = j;
        j--;
      } else if (arr[i] == '.' && arr[j] == '.') {
        j--;
      } else if (arr[i] == '#' || arr[i] == '*') {
        i--;
        j = i - 1;
      } else {
        i--;
        j--;
      }
    }
  }
}
