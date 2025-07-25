package com.leetcode.lc1828;

import java.util.Arrays;

/*
1828. Queries on Number of Points Inside a Circle

You are given an array points where points[i] = [xi, yi] is the coordinates of the ith point on a 2D plane. Multiple points can have the same coordinates.

You are also given an array queries where queries[j] = [xj, yj, rj] describes a circle centered at (xj, yj) with a radius of rj.

For each query queries[j], compute the number of points inside the jth circle. Points on the border of the circle are considered inside.

Return an array answer, where answer[j] is the answer to the jth query.



Example 1:

Input: points = [[1,3],[3,3],[5,3],[2,2]], queries = [[2,3,1],[4,3,1],[1,1,2]]
Output: [3,2,2]
Explanation: The points and circles are shown above.
queries[0] is the green circle, queries[1] is the red circle, and queries[2] is the blue circle.

Example 2:

Input: points = [[1,1],[2,2],[3,3],[4,4],[5,5]], queries = [[1,2,2],[2,2,2],[4,3,2],[4,3,3]]
Output: [2,3,2,4]
Explanation: The points and circles are shown above.
queries[0] is green, queries[1] is red, queries[2] is blue, and queries[3] is purple.



Constraints:

    1 <= points.length <= 500
    points[i].length == 2
    0 <= xi, yi <= 500
    1 <= queries.length <= 500
    queries[j].length == 3
    0 <= xj, yj <= 500
    1 <= rj <= 500
    All coordinates are integers.



Follow up: Could you find the answer for each query in better complexity than O(n)?
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(Arrays.toString(solution.countPoints(new int[][]{{1, 3}, {3, 3}, {5, 3}, {2, 2}}, new int[][]{{2, 3, 1}, {4, 3, 1}, {1, 1, 2}})));
    System.out.println(Arrays.toString(solution.countPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}}, new int[][]{{1, 2, 2}, {2, 2, 2}, {4, 3, 2}, {4, 3, 3}})));
  }

  public int[] countPoints(int[][] points, int[][] queries) {
    var result = new int[queries.length];
    var i = 0;
    for (var query : queries) {
      for (var point : points)
        if (Math.pow(query[0] - point[0], 2) + Math.pow(query[1] - point[1], 2) <= Math.pow(query[2], 2))
          result[i]++;
      i++;
    }
    return result;
  }
}
