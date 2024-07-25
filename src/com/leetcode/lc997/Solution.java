package com.leetcode.lc997;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
997. Find the Town Judge

In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

    The town judge trusts nobody.
    Everybody (except for the town judge) trusts the town judge.
    There is exactly one person that satisfies properties 1 and 2.

You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi. If a trust relationship does not exist in trust array, then such a trust relationship does not exist.

Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.



Example 1:

Input: n = 2, trust = [[1,2]]
Output: 2

Example 2:

Input: n = 3, trust = [[1,3],[2,3]]
Output: 3

Example 3:

Input: n = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1



Constraints:

    1 <= n <= 1000
    0 <= trust.length <= 104
    trust[i].length == 2
    All the pairs of trust are unique.
    ai != bi
    1 <= ai, bi <= n
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int n;
    int[][] trust;

    n = 2;
    trust = new int[][]{{1, 2}};
    System.out.println(solution.findJudge(n, trust)); // Output: 2

    n = 3;
    trust = new int[][]{{1, 3}, {2, 3}};
    System.out.println(solution.findJudge(n, trust)); // Output: 3

    n = 3;
    trust = new int[][]{{1, 3}, {2, 3}, {3, 1}};
    System.out.println(solution.findJudge(n, trust)); // Output: -1
  }

  public int findJudge(int n, int[][] trust) {
    if (trust.length == 0 && n != 1) {
      return -1;
    }
    if (trust.length == 0 && n == 1) {
      return 1;
    }
    if (trust.length == 1) {
      return trust[0][1];
    }
    var map = new HashMap<Integer, Integer>();
    var set = new HashSet<Integer>();
    for (int i = 0; i < trust.length; i++) {
      map.put(trust[i][1], map.getOrDefault(trust[i][1], 0) + 1);
      set.add(trust[i][0]);
    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == n - 1 && !set.contains(entry.getKey())) {
        return entry.getKey();
      }
    }
    return -1;
  }
}
