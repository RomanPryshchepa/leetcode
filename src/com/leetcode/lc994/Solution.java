package com.leetcode.lc994;

import java.util.Deque;
import java.util.LinkedList;

/*
994. Rotting Oranges

You are given an m x n grid where each cell can have one of three values:

    0 representing an empty cell,
    1 representing a fresh orange, or
    2 representing a rotten orange.

Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.



Example 1:

Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.



Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 10
    grid[i][j] is 0, 1, or 2.
 */
public class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
        System.out.println(solution.orangesRotting(new int[][]{{2,1,1},{0,1,1},{1,0,1}}));
        System.out.println(solution.orangesRotting(new int[][]{{0,2}}));
    }

    public int orangesRotting(int[][] grid) {
        var freshCnt = 0;
        var time = 0;
        Deque<int[]> q = new LinkedList<>();
        for (var i = 0; i < grid.length; i++)
            for (var j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 1)
                    freshCnt++;
                else if (grid[i][j] == 2)
                    q.add(new int[]{i, j});
        if (freshCnt == 0)
            return 0;
        int[] orange;
        var qLen = 0;
        while (!q.isEmpty()) {
            time++;
            qLen = q.size();
            for (var k = 0; k < qLen; k++) {
                orange = q.poll();
                if (orange[0] > 0 && grid[orange[0] - 1][orange[1]] == 1) {
                    grid[orange[0] - 1][orange[1]] = 2;
                    q.add(new int[]{orange[0] - 1, orange[1]});
                    freshCnt--;
                }
                if (freshCnt == 0) break;
                if (orange[0] < grid.length - 1 && grid[orange[0] + 1][orange[1]] == 1) {
                    grid[orange[0] + 1][orange[1]] = 2;
                    q.add(new int[]{orange[0] + 1, orange[1]});
                    freshCnt--;
                }
                if (freshCnt == 0) break;
                if (orange[1] > 0 && grid[orange[0]][orange[1] - 1] == 1) {
                    grid[orange[0]][orange[1] - 1] = 2;
                    q.add(new int[]{orange[0], orange[1] - 1});
                    freshCnt--;
                }
                if (freshCnt == 0) break;
                if (orange[1] < grid[0].length - 1 && grid[orange[0]][orange[1] + 1] == 1) {
                    grid[orange[0]][orange[1] + 1] = 2;
                    q.add(new int[]{orange[0], orange[1] + 1});
                    freshCnt--;
                }
                if (freshCnt == 0) break;
            }
            if (freshCnt == 0) break;
        }
        return freshCnt == 0 ? time : -1;
    }
}
