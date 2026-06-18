package com.leetcode.lc210;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
210. Course Schedule II

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.

Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].

Example 2:

Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].

Example 3:

Input: numCourses = 1, prerequisites = []
Output: [0]



Constraints:

    1 <= numCourses <= 2000
    0 <= prerequisites.length <= numCourses * (numCourses - 1)
    prerequisites[i].length == 2
    0 <= ai, bi < numCourses
    ai != bi
    All the pairs [ai, bi] are distinct.
 */
public class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(Arrays.toString(solution.findOrder(2, new int[][]{{1, 0}})));
        System.out.println(Arrays.toString(solution.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
        System.out.println(Arrays.toString(solution.findOrder(1, new int[][]{})));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        var list = new LinkedList<Integer>();
        var prevCoursesCnt = new int[numCourses];
        var courses = new HashMap<Integer, List<Integer>>();
        for (var pr : prerequisites) {
            prevCoursesCnt[pr[0]]++;
            if (!courses.containsKey(pr[1]))
                courses.put(pr[1], new LinkedList<>());
            courses.get(pr[1]).add(pr[0]);
        }
        var hasPrev = true;
        while (hasPrev) {
            hasPrev = false;
            for (var i = 0; i < prevCoursesCnt.length; i++) {
                if (prevCoursesCnt[i] == 0) {
                    hasPrev = true;
                    list.add(i);
                    prevCoursesCnt[i] = -1;
                    if (courses.containsKey(i)) {
                        for (var course : courses.get(i))
                            prevCoursesCnt[course]--;
                        courses.remove(i);
                    }
                }
            }
        }
        if (!courses.isEmpty())
            return new int[0];
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }
}
