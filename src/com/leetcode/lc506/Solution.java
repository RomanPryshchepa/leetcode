package com.leetcode.lc506;

import java.util.Arrays;

/*
506. Relative Ranks
Easy
Topics
Companies

You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. All the scores are guaranteed to be unique.

The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:

    The 1st place athlete's rank is "Gold Medal".
    The 2nd place athlete's rank is "Silver Medal".
    The 3rd place athlete's rank is "Bronze Medal".
    For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").

Return an array answer of size n where answer[i] is the rank of the ith athlete.



Example 1:

Input: score = [5,4,3,2,1]
Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].

Example 2:

Input: score = [10,3,8,9,4]
Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
Explanation: The placements are [1st, 5th, 3rd, 2nd, 4th].



Constraints:

    n == score.length
    1 <= n <= 104
    0 <= score[i] <= 106
    All the values in score are unique.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();

    var score = new int[] {10,3,8,9,4};
    System.out.println(Arrays.toString(solution.findRelativeRanks(score)));

    score = new int[] {1,2,3,4,5};
    System.out.println(Arrays.toString(solution.findRelativeRanks(score)));

    score = new int[] {5,4,3,2,1};
    System.out.println(Arrays.toString(solution.findRelativeRanks(score)));
  }

  public String[] findRelativeRanks(int[] score) {
    var idxs = new Integer[score.length];
    for (int i = 0; i < idxs.length; i++) {
      idxs[i] = i;
    }
    Arrays.sort(idxs, (a,b) -> score[b] - score[a]);
    var res = new String[idxs.length];
    for (int i = 0; i < idxs.length; i++) {
      if (i == 0)
        res[idxs[i]] = "Gold Medal";
      else if (i == 1)
        res[idxs[i]] = "Silver Medal";
      else if (i == 2)
        res[idxs[i]] = "Bronze Medal";
      else
        res[idxs[i]] = String.valueOf(i+1);
    }
    return res;
  }
}
