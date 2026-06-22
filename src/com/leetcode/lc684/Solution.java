package com.leetcode.lc684;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
684. Redundant Connection

In this problem, a tree is an undirected graph that is connected and has no cycles.

You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.

Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.



Example 1:

Input: edges = [[1,2],[1,3],[2,3]]
Output: [2,3]

Example 2:

Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
Output: [1,4]



Constraints:

    n == edges.length
    3 <= n <= 1000
    edges[i].length == 2
    1 <= ai < bi <= edges.length
    ai != bi
    There are no repeated edges.
    The given graph is connected.
 */
public class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(Arrays.toString(solution.findRedundantConnection(new int[][]{{1,2},{1,3},{2,3}})));
        System.out.println(Arrays.toString(solution.findRedundantConnection(new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}})));
    }

    public int[] findRedundantConnection(int[][] edges) {
        var listOfSets = new LinkedList<Set<Integer>>();
        listOfSets.add(new HashSet<>());
        Set<Integer> set1 = null;
        Set<Integer> set2 = null;
        for (int[] edge : edges) {
            for (Set<Integer> set : listOfSets) {
                if (set.contains(edge[0]) && set.contains(edge[1]))
                    return edge;
                if (set.contains(edge[0]))
                    set1 = set;
                if (set.contains(edge[1]))
                    set2 = set;
            }
            if (set1 == null && set2 == null) {
                listOfSets.add(new HashSet<>(){{add(edge[0]); add(edge[1]);}});
            } else if (set1 == null) {
                set2.add(edge[0]);
            } else if (set2 == null) {
                set1.add(edge[1]);
            } else {
                set1.addAll(set2);
                listOfSets.remove(set2);
            }
            set1 = null;
            set2 = null;
        }
        return null;
    }
}
