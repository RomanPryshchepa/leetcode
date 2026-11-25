package com.leetcode.lc57;

import java.util.ArrayList;
import java.util.Arrays;

/*
57. Insert Interval

You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Two intervals are considered overlapping if they share at least one point.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Note that you don't need to modify intervals in-place. You can make a new array and return it.



Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].



Constraints:

    0 <= intervals.length <= 104
    intervals[i].length == 2
    0 <= starti <= endi <= 105
    intervals is sorted by starti in ascending order.
    newInterval.length == 2
    0 <= start <= end <= 105
 */
public class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(Arrays.deepToString(solution.insert(new int[][]{{1,3},{6,9}}, new int[]{2,5})));
        System.out.println(Arrays.deepToString(solution.insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8})));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0 || newInterval[0] <= intervals[0][0] && newInterval[1] >= intervals[intervals.length - 1][1])
            return new int[][]{newInterval};
        var list = new ArrayList<Integer>();
        for (var interval : intervals) {
            if (list.isEmpty()) {
                if (newInterval[0] <= interval[0]) {
                    list.add(newInterval[0]);
                    if (newInterval[1] < interval[0]) {
                        list.add(newInterval[1]);
                        list.add(interval[0]);
                        list.add(interval[1]);
                    } else list.add(Math.max(newInterval[1], interval[1]));
                } else {
                    list.add(interval[0]);
                    list.add(interval[1]);
                }
            } else {
                if (newInterval[0] <= interval[0]) {
                    if (newInterval[0] <= list.getLast() && newInterval[1] > list.getLast()) {
                        list.removeLast();
                        list.add(newInterval[1]);
                    } else if (newInterval[0] > list.getLast()) {
                        list.add(newInterval[0]);
                        list.add(newInterval[1]);
                    }
                }
                if (interval[0] <= list.getLast() && interval[1] > list.getLast()) {
                    list.removeLast();
                    list.add(interval[1]);
                } else if (interval[0] > list.getLast()) {
                    list.add(interval[0]);
                    list.add(interval[1]);
                }
            }
        }
        if (newInterval[0] > intervals[intervals.length - 1][1]) {
            list.add(newInterval[0]);
            list.add(newInterval[1]);
        } else if (newInterval[0] >= intervals[intervals.length - 1][0] && newInterval[1] > intervals[intervals.length - 1][1]) {
            list.removeLast();
            list.add(newInterval[1]);
        }
        var result = new int[list.size()/2][2];
        for (var i = 0; i < list.size(); i++)
            result[i / 2][i % 2] = list.get(i);
        return result;
    }
}
