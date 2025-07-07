package com.leetcode.lc1282;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
1282. Group the People Given the Group Size They Belong To

There are n people that are split into some unknown number of groups. Each person is labeled with a unique ID from 0 to n - 1.

You are given an integer array groupSizes, where groupSizes[i] is the size of the group that person i is in. For example, if groupSizes[1] = 3, then person 1 must be in a group of size 3.

Return a list of groups such that each person i is in a group of size groupSizes[i].

Each person should appear in exactly one group, and every person must be in a group. If there are multiple answers, return any of them. It is guaranteed that there will be at least one valid solution for the given input.



Example 1:

Input: groupSizes = [3,3,3,3,3,1,3]
Output: [[5],[0,1,2],[3,4,6]]
Explanation:
The first group is [5]. The size is 1, and groupSizes[5] = 1.
The second group is [0,1,2]. The size is 3, and groupSizes[0] = groupSizes[1] = groupSizes[2] = 3.
The third group is [3,4,6]. The size is 3, and groupSizes[3] = groupSizes[4] = groupSizes[6] = 3.
Other possible solutions are [[2,1,6],[5],[0,4,3]] and [[5],[0,6,2],[4,3,1]].

Example 2:

Input: groupSizes = [2,1,3,3,3,2]
Output: [[1],[0,5],[2,3,4]]



Constraints:

    groupSizes.length == n
    1 <= n <= 500
    1 <= groupSizes[i] <= n
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3}));
    System.out.println(solution.groupThePeople(new int[]{2, 1, 3, 3, 3, 2}));
  }

  public List<List<Integer>> groupThePeople(int[] groupSizes) {
    var list = new ArrayList<List<Integer>>();
    var groups = new HashMap<Integer, List<Integer>>();
    for (int i = 0; i < groupSizes.length; i++) {
      if (!groups.containsKey(groupSizes[i]))
        groups.put(groupSizes[i], new ArrayList<>());
      groups.get(groupSizes[i]).add(i);
    }
    for (Integer key : groups.keySet()) {
      var group = new ArrayList<Integer>();
      for (int i = 0; i < groups.get(key).size(); i++) {
        group.add(groups.get(key).get(i));
        if (group.size() == key) {
          list.add(group);
          group = new ArrayList<>();
        }
      }
    }
    return list;
  }
}
