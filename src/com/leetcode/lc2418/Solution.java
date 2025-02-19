package com.leetcode.lc2418;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/*
2418. Sort the People

You are given an array of strings names, and an array heights that consists of distinct positive integers. Both arrays are of length n.

For each index i, names[i] and heights[i] denote the name and height of the ith person.

Return names sorted in descending order by the people's heights.



Example 1:

Input: names = ["Mary","John","Emma"], heights = [180,165,170]
Output: ["Mary","Emma","John"]
Explanation: Mary is the tallest, followed by Emma and John.

Example 2:

Input: names = ["Alice","Bob","Bob"], heights = [155,185,150]
Output: ["Bob","Alice","Bob"]
Explanation: The first Bob is the tallest, followed by Alice and the second Bob.



Constraints:

    n == names.length == heights.length
    1 <= n <= 103
    1 <= names[i].length <= 20
    1 <= heights[i] <= 105
    names[i] consists of lower and upper case English letters.
    All the values of heights are distinct.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(Arrays.toString(
        solution.sortPeople(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170})));
    System.out.println(Arrays.toString(
        solution.sortPeople(new String[]{"Alice", "Bob", "Bob"}, new int[]{155, 185, 150})));
  }

  public String[] sortPeople(String[] names, int[] heights) {
    var treeMap = new TreeMap<Integer, String>(Comparator.reverseOrder());
    for (int i = 0; i < heights.length; i++) {
      treeMap.put(heights[i], names[i]);
    }
    return treeMap.values().toArray(new String[0]);
  }
}
