package com.leetcode.lc207;

import java.util.*;

/*
207. Course Schedule

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.

Return true if you can finish all courses. Otherwise, return false.



Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.

Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.



Constraints:

    1 <= numCourses <= 2000
    0 <= prerequisites.length <= 5000
    prerequisites[i].length == 2
    0 <= ai, bi < numCourses
    All the pairs prerequisites[i] are unique.
 */
public class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.canFinish(2, new int[][]{{1, 0}}));
        System.out.println(solution.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var prevCourseCnt = new int[numCourses];
        var courses = new HashMap<Integer, List<Integer>>();
        for (int[] prerequisite : prerequisites) {
            prevCourseCnt[prerequisite[0]]++;
            if (!courses.containsKey(prerequisite[1]))
                courses.put(prerequisite[1], new ArrayList<>());
            courses.get(prerequisite[1]).add(prerequisite[0]);
        }
        var hasZeroPrevCourses = true;
        while (hasZeroPrevCourses) {
            hasZeroPrevCourses = false;
            for (int i = 0; i < prevCourseCnt.length; i++) {
                if (prevCourseCnt[i] == 0) {
                    hasZeroPrevCourses = true;
                    prevCourseCnt[i] = -1;
                    if (courses.containsKey(i)) {
                        for (Integer course : courses.get(i)) {
                            prevCourseCnt[course]--;
                        }
                        courses.remove(i);
                    }
                }
            }
        }
        return courses.isEmpty();
    }
}
