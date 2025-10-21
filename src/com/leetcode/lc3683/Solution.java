package com.leetcode.lc3683;

/*
3683. Earliest Time to Finish One Task

You are given a 2D integer array tasks where tasks[i] = [si, ti].

Each [si, ti] in tasks represents a task with start time si that takes ti units of time to finish.

Return the earliest time at which at least one task is finished.



Example 1:

Input: tasks = [[1,6],[2,3]]

Output: 5

Explanation:

The first task starts at time t = 1 and finishes at time 1 + 6 = 7. The second task finishes at time 2 + 3 = 5. You can finish one task at time 5.

Example 2:

Input: tasks = [[100,100],[100,100],[100,100]]

Output: 200

Explanation:

All three tasks finish at time 100 + 100 = 200.



Constraints:

    1 <= tasks.length <= 100
    tasks[i] = [si, ti]
    1 <= si, ti <= 100
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.earliestTime(new int[][]{{1, 6}, {2, 3}}));
    System.out.println(solution.earliestTime(new int[][]{{100, 100}, {100, 100}, {100, 100}}));
  }

  public int earliestTime(int[][] tasks) {
    var res = tasks[0][0] + tasks[0][1];
    for (int i = 1; i < tasks.length; i++) {
      res = Math.min(res, tasks[i][0] + tasks[i][1]);
    }
    return res;
  }
}
