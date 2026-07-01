package com.leetcode.lc323;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
323. Number of Connected Components in an Undirected Graph

You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [aᵢ, bᵢ] indicates that there is an edge between aᵢ and bᵢ in the graph.

Return the number of connected components in the graph.

Example 1:

Input:
n = 5, edges = [[0,1],[1,2],[3,4]]

Output: 2

Example 2:

Input:
n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]

Output: 1

Constraints:

    1 <= n <= 2000
    1 <= edges.length <= 5000
    edges[i].length == 2
    0 <= aᵢ <= bᵢ < n
    aᵢ != bᵢ
    There are no repeated edges.
 */
public class Solution {
    private List<Integer>[] nodes;
    private boolean[] visited;

    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.countComponents(5, new int[][]{{0,1},{1,2},{3,4}}));
        System.out.println(solution.countComponents(5, new int[][]{{0,1},{1,2},{2,3},{3,4}}));
    }

    public int countComponents(int n, int[][] edges) {
        nodes = new List[n];
        visited = new boolean[n];
        Arrays.setAll(nodes, idx -> new LinkedList<>());
        for (var edge : edges) {
            nodes[edge[0]].add(edge[1]);
            nodes[edge[1]].add(edge[0]);
        }
        var res = 0;
        for (int i = 0; i < n; i++)
            res += dfs(i);
        return res;
    }

    private int dfs(int node) {
        if (visited[node])
            return 0;
        visited[node] = true;
        for (var child : nodes[node])
            dfs(child);
        return 1;
    }
}
