package com.leetcode.lc39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
39. Combination Sum

Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.



Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:

Input: candidates = [2], target = 1
Output: []



Constraints:

    1 <= candidates.length <= 30
    2 <= candidates[i] <= 40
    All elements of candidates are distinct.
    1 <= target <= 40
 */
class Solution {

    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(solution.combinationSum(new int[]{2, 3, 5}, 8));
        System.out.println(solution.combinationSum(new int[]{2}, 1));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        var currentCombination = new ArrayList<Integer>();
        var result = new ArrayList<List<Integer>>();
        dfs(0, target, candidates, currentCombination, result);
        return result;
    }

    private void dfs(int startIndex, int remainingTarget, int[] candidates, List<Integer> currentCombination, List<List<Integer>> result) {
        if (remainingTarget == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }
        if (remainingTarget < candidates[startIndex])
            return;
        for (int i = startIndex; i < candidates.length; ++i) {
            currentCombination.add(candidates[i]);
            dfs(i, remainingTarget - candidates[i], candidates, currentCombination, result);
            currentCombination.removeLast();
        }
    }
}