package com.leetcode.lc1128;

import java.util.HashMap;

/*
1128. Number of Equivalent Domino Pairs

Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a == c and b == d), or (a == d and b == c) - that is, one domino can be rotated to be equal to another domino.

Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].



Example 1:

Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
Output: 1

Example 2:

Input: dominoes = [[1,2],[1,2],[1,1],[1,2],[2,2]]
Output: 3



Constraints:

    1 <= dominoes.length <= 4 * 104
    dominoes[i].length == 2
    1 <= dominoes[i][j] <= 9
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.numEquivDominoPairs(new int[][]{{1, 2}, {2, 1}, {3, 4}, {5, 6}}));
    System.out.println(
        solution.numEquivDominoPairs(new int[][]{{1, 2}, {1, 2}, {1, 1}, {1, 2}, {2, 2}}));
    System.out.println(
        solution.numEquivDominoPairs(new int[][]{{1, 2}, {1, 2}, {1, 1}, {1, 2}, {2, 2}, {1, 2}}));
  }

  public int numEquivDominoPairs(int[][] dominoes) {
    var hashMap = new HashMap<Integer, Integer>();
    for (int[] domino : dominoes) {
      if (hashMap.containsKey(domino[0] * 10 + domino[1])) {
        hashMap.put(domino[0] * 10 + domino[1], hashMap.get(domino[0] * 10 + domino[1]) + 1);
      } else if (hashMap.containsKey(domino[1] * 10 + domino[0])) {
        hashMap.put(domino[1] * 10 + domino[0], hashMap.get(domino[1] * 10 + domino[0]) + 1);
      } else {
        hashMap.put(domino[0] * 10 + domino[1], 1);
      }
    }
    var res = 0;
    for (Integer value : hashMap.values()) {
      if (value > 1) {
        res += value * (value - 1) / 2;
      }
    }
    return res;
  }
}
