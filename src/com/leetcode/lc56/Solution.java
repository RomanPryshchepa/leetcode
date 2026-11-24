package com.leetcode.lc56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
56. Merge Intervals

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.



Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

Example 3:

Input: intervals = [[4,7],[1,4]]
Output: [[1,7]]
Explanation: Intervals [1,4] and [4,7] are considered overlapping.



Constraints:

    1 <= intervals.length <= 104
    intervals[i].length == 2
    0 <= starti <= endi <= 104
 */
public class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(Arrays.deepToString(solution.merge(new int[][]{{1,3}, {2,6}, {8,10}, {15,18}})));
        System.out.println(Arrays.deepToString(solution.merge(new int[][]{{1,4}, {4,5}})));
        System.out.println(Arrays.deepToString(solution.merge(new int[][]{{4,7}, {1,4}})));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1)
            return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        var list = new ArrayList<Integer>();
        for (var interval : intervals) {
            if (list.isEmpty() || interval[0] > list.getLast()) {
                list.add(interval[0]);
                list.add(interval[1]);
            } else if (interval[0] <= list.getLast() && interval[1] >= list.getLast()) {
                list.removeLast();
                list.add(interval[1]);
            }
        }
        var result = new int[list.size()/2][2];
        for (var i = 0; i < list.size(); i++) {
            result[i / 2][i % 2] = list.get(i);
        }
        return result;
    }
}
