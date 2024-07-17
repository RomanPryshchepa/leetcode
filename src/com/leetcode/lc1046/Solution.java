package com.leetcode.lc1046;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
1046. Last Stone Weight

You are given an array of integers stones where stones[i] is the weight of the ith stone.

We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:

    If x == y, both stones are destroyed, and
    If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.

At the end of the game, there is at most one stone left.

Return the weight of the last remaining stone. If there are no stones left, return 0.



Example 1:

Input: stones = [2,7,4,1,8,1]
Output: 1
Explanation:
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.

Example 2:

Input: stones = [1]
Output: 1



Constraints:

    1 <= stones.length <= 30
    1 <= stones[i] <= 1000
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] stones;

    stones = new int[]{2, 7, 4, 1, 8, 1};
    System.out.println(solution.lastStoneWeight(stones)); // 1

    stones = new int[]{1};
    System.out.println(solution.lastStoneWeight(stones)); // 1

    stones = new int[]{1, 1, 1, 1};
    System.out.println(solution.lastStoneWeight(stones)); // 0
  }

  public int lastStoneWeight(int[] stones) {
    var list = new ArrayList<Integer>();
    for (int stone : stones) {
      list.add(stone);
    }
    list.sort((o1, o2) -> o2 - o1);
    while (list.size() > 1) {
      if (list.get(0).equals(list.get(1))) {
        list.remove(0);
        list.remove(0);
      } else {
        int element = list.get(0) - list.get(1);
        list.remove(0);
        list.remove(0);
        list.add(searchInsert(list, element), element);
      }
    }
    if (list.size() == 1) {
      return list.get(0);
    }
    return 0;
  }

  public static int searchInsert(List<Integer> list, int target) {
    int start = 0;
    int end = list.size() - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (list.get(mid) == target) {
        return mid;
      } else if (list.get(mid) > target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return start;
  }
}
