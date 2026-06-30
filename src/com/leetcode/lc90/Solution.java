package com.leetcode.lc90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
90. Subsets II

Given an integer array nums that may contain duplicates, return all possible (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Example 2:

Input: nums = [0]
Output: [[],[0]]



Constraints:

    1 <= nums.length <= 10
    -10 <= nums[i] <= 10
 */
class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.subsetsWithDup(new int[]{1, 2, 2}));
        System.out.println(solution.subsetsWithDup(new int[]{0}));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        var currentSubset = new ArrayList<Integer>();
        var result = new ArrayList<List<Integer>>();
        backtrack(0, nums, currentSubset, result);
        return result;
    }

    private void backtrack(int index, int[] nums, List<Integer> currentSubset, List<List<Integer>> result) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(currentSubset));
            return;
        }
        currentSubset.add(nums[index]);
        backtrack(index + 1, nums, currentSubset, result);
        var removedElement = currentSubset.removeLast();
        while (index + 1 < nums.length && nums[index + 1] == removedElement)
            index++;
        backtrack(index + 1, nums, currentSubset, result);
    }
}