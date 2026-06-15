package com.leetcode.lc286;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
286. Islands and Treasure

You are given a m×nm×n 2D grid initialized with these three possible values:

    -1 - A water cell that can not be traversed.
    0 - A treasure chest.
    INF - A land cell that can be traversed. We use the integer 2^31 - 1 = 2147483647 to represent INF.

Fill each land cell with the distance to its nearest treasure chest. If a land cell cannot reach a treasure chest then the value should remain INF.

Assume the grid can only be traversed up, down, left, or right.

Modify the grid in-place.

Example 1:

Input: [
  [2147483647,-1,0,2147483647],
  [2147483647,2147483647,2147483647,-1],
  [2147483647,-1,2147483647,-1],
  [0,-1,2147483647,2147483647]
]

Output: [
  [3,-1,0,1],
  [2,2,1,-1],
  [1,-1,2,-1],
  [0,-1,3,4]
]

Example 2:

Input: [
  [0,-1],
  [2147483647,2147483647]
]

Output: [
  [0,-1],
  [1,2]
]

Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 100
    grid[i][j] is one of {-1, 0, 2147483647}
 */
public class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        var grid = new int[][]
                {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        solution.islandsAndTreasure(grid);
        System.out.println(Arrays.deepToString(grid));
        System.out.println();

        grid = new int[][] {{0,-1},{2147483647,2147483647}};
        solution.islandsAndTreasure(grid);
        System.out.println(Arrays.deepToString(grid));
    }

    public void islandsAndTreasure(int[][] grid) {
        Deque<int[]> queue = new LinkedList<>();
        for (var i = 0; i < grid.length; i++)
            for (var j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 0)
                    queue.add(new int[]{i, j});
        var dist = 0;
        var inf = 2147483647;
        int[] point;
        while (!queue.isEmpty()) {
            dist++;
            var qLen = queue.size();
            for (var q = 0; q < qLen; q++) {
                point = queue.poll();
                if (point[0] > 0 && grid[point[0] - 1][point[1]] == inf) {
                    grid[point[0] - 1][point[1]] = dist;
                    queue.add(new int[]{point[0] - 1, point[1]});
                }
                if (point[0] < grid.length - 1 && grid[point[0] + 1][point[1]] == inf) {
                    grid[point[0] + 1][point[1]] = dist;
                    queue.add(new int[]{point[0] + 1, point[1]});
                }
                if (point[1] > 0 && grid[point[0]][point[1] - 1] == inf) {
                    grid[point[0]][point[1] - 1] = dist;
                    queue.add(new int[]{point[0], point[1] - 1});
                }
                if (point[1] < grid[0].length - 1 && grid[point[0]][point[1] + 1] == inf) {
                    grid[point[0]][point[1] + 1] = dist;
                    queue.add(new int[]{point[0], point[1] + 1});
                }
            }
        }
    }
}
