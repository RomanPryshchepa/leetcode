package com.leetcode.lc771;

import java.util.HashMap;

/*
771. Jewels and Stones

You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.

Letters are case sensitive, so "a" is considered a different type of stone from "A".



Example 1:

Input: jewels = "aA", stones = "aAAbbbb"
Output: 3

Example 2:

Input: jewels = "z", stones = "ZZ"
Output: 0



Constraints:

    1 <= jewels.length, stones.length <= 50
    jewels and stones consist of only English letters.
    All the characters of jewels are unique.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.numJewelsInStones("aA", "aAAbbbb"));
    System.out.println(solution.numJewelsInStones("z", "ZZ"));
  }

  public int numJewelsInStones(String jewels, String stones) {
    var result = 0;
    var map = new HashMap<Character, Integer>();
    for (var stone : stones.toCharArray()) {
      if (map.containsKey(stone))
        map.put(stone, map.get(stone) + 1);
      else
        map.put(stone, 1);
    }
    for (var jewel : jewels.toCharArray()) {
      if (map.containsKey(jewel))
        result += map.get(jewel);
    }
    return result;
  }
}
