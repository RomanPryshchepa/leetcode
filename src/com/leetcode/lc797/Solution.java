package com.leetcode.lc797;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
797. All Paths From Source to Target

Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).



Example 1:

Input: graph = [[1,2],[3],[3],[]]
Output: [[0,1,3],[0,2,3]]
Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.

Example 2:

Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]



Constraints:

    n == graph.length
    2 <= n <= 15
    0 <= graph[i][j] < n
    graph[i][j] != i (i.e., there will be no self-loops).
    All the elements of graph[i] are unique.
    The input graph is guaranteed to be a DAG.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[][] graph;

    graph = new int[][]{{1, 2}, {3}, {3}, {}};
    System.out.println(solution.allPathsSourceTarget(graph));

    graph = new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
    System.out.println(solution.allPathsSourceTarget(graph));
  }

  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    var result = new ArrayList<List<Integer>>();
    var queue = new LinkedList<List<Integer>>();
    queue.add(new ArrayList<>() {{
      add(0);
    }});
    while (!queue.isEmpty()) {
      var path = queue.poll();
      if (path.get(path.size() - 1) == graph.length - 1) {
        result.add(path);
      }

      for (var node : graph[path.get(path.size() - 1)]) {
        var newPath = new ArrayList<>(path);
        newPath.add(node);
        queue.add(newPath);
      }
    }
    return result;
  }
}
