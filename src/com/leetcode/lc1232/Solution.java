package com.leetcode.lc1232;

/*
1232. Check If It Is a Straight Line

You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.





Example 1:

Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true

Example 2:

Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false



Constraints:

    2 <= coordinates.length <= 1000
    coordinates[i].length == 2
    -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
    coordinates contains no duplicate point.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(
        solution.checkStraightLine(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    System.out.println(
        solution.checkStraightLine(new int[][]{{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}}));
    System.out.println(
        solution.checkStraightLine(new int[][]{{1, 1}, {1, 2}, {1, 3}, {1, 4}, {1, 5}, {1, 6}}));
    System.out.println(
        solution.checkStraightLine(new int[][]{{1, 1}, {2, 1}, {3, 1}, {4, 1}, {5, 1}, {6, 1}}));
    System.out.println(
        solution.checkStraightLine(new int[][]{{1, 1}, {2, 1}, {3, 1}, {4, 1}, {5, 2}, {6, 1}}));
    System.out.println(
        solution.checkStraightLine(new int[][]{{1, 1}, {2, 1}}));
  }

  public boolean checkStraightLine(int[][] coordinates) {
    var x1 = coordinates[0][0];
    var y1 = coordinates[0][1];
    var x2 = coordinates[1][0];
    var y2 = coordinates[1][1];
    for (int i = 2; i < coordinates.length; i++) {
      int x = coordinates[i][0];
      int y = coordinates[i][1];
      if (x1 == x2 || y1 == y2) {
        if (x1 == x2 && x != x1) {
          return false;
        }
        if (y1 == y2 && y != y1) {
          return false;
        }
      } else if (((x - x1) / (x2 - x1)) != ((y - y1) / (y2 - y1))) {
        return false;
      }
    }
    return true;
  }
}
