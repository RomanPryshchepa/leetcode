package com.leetcode.lc2300;

import java.util.Arrays;

/*
2300. Successful Pairs of Spells and Potions

You are given two positive integer arrays spells and potions, of length n and m respectively, where spells[i] represents the strength of the ith spell and potions[j] represents the strength of the jth potion.

You are also given an integer success. A spell and potion pair is considered successful if the product of their strengths is at least success.

Return an integer array pairs of length n where pairs[i] is the number of potions that will form a successful pair with the ith spell.



Example 1:

Input: spells = [5,1,3], potions = [1,2,3,4,5], success = 7
Output: [4,0,3]
Explanation:
- 0th spell: 5 * [1,2,3,4,5] = [5,10,15,20,25]. 4 pairs are successful.
- 1st spell: 1 * [1,2,3,4,5] = [1,2,3,4,5]. 0 pairs are successful.
- 2nd spell: 3 * [1,2,3,4,5] = [3,6,9,12,15]. 3 pairs are successful.
Thus, [4,0,3] is returned.

Example 2:

Input: spells = [3,1,2], potions = [8,5,8], success = 16
Output: [2,0,2]
Explanation:
- 0th spell: 3 * [8,5,8] = [24,15,24]. 2 pairs are successful.
- 1st spell: 1 * [8,5,8] = [8,5,8]. 0 pairs are successful.
- 2nd spell: 2 * [8,5,8] = [16,10,16]. 2 pairs are successful.
Thus, [2,0,2] is returned.



Constraints:

    n == spells.length
    m == potions.length
    1 <= n, m <= 105
    1 <= spells[i], potions[i] <= 105
    1 <= success <= 1010
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(Arrays.toString(
        solution.successfulPairs(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7))); // [4,0,3]
    System.out.println(Arrays.toString(
        solution.successfulPairs(new int[]{3, 1, 2}, new int[]{8, 5, 8}, 16))); // [2,0,2]
  }

  public int[] successfulPairs(int[] spells, int[] potions, long success) {
    var res = new int[spells.length];
    Arrays.sort(potions);
    for (int i = 0; i < spells.length; i++) {
      if (potions[0] * 1L * spells[i] >= success) {
        res[i] = potions.length;
      } else if (potions[potions.length - 1] * 1L * spells[i] < success) {
        res[i] = 0;
      } else {
        res[i] = successfulPairsCount(potions, spells[i], success);
      }
    }
    return res;
  }

  private int successfulPairsCount(int[] sortedPotions, int spell, long success) {
    var start = 0;
    var end = sortedPotions.length - 1;
    var mid = 0;
    while (start <= end) {
      mid = (start + end) >> 1;
      if (sortedPotions[mid] * 1L * spell < success
          && sortedPotions[mid + 1] * 1L * spell >= success) {
        return sortedPotions.length - 1 - mid;
      }
      if (sortedPotions[mid] * 1L * spell < success) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return 0;
  }
}
