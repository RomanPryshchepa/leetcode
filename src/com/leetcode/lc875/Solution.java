package com.leetcode.lc875;

import java.util.Arrays;

/*
875. Koko Eating Bananas

Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.



Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4

Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30

Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23



Constraints:

    1 <= piles.length <= 104
    piles.length <= h <= 109
    1 <= piles[i] <= 109
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] piles;
    int h;
    //Example 1:
    //
    //Input: piles = [3,6,7,11], h = 8
    //Output: 4
    piles = new int[]{3, 6, 7, 11};
    h = 8;
    System.out.println(solution.minEatingSpeed(piles, h));
    //Example 2:
    //
    //Input: piles = [30,11,23,4,20], h = 5
    //Output: 30
    piles = new int[]{30, 11, 23, 4, 20};
    h = 5;
    System.out.println(solution.minEatingSpeed(piles, h));

    //Example 3:
    //
    //Input: piles = [30,11,23,4,20], h = 6
    //Output: 23
    piles = new int[]{30, 11, 23, 4, 20};
    h = 6;
    System.out.println(solution.minEatingSpeed(piles, h));

    //Example 4:
    //
    //Input: piles = [20], h = 6
    //Output: 4
    piles = new int[]{20};
    h = 6;
    System.out.println(solution.minEatingSpeed(piles, h));

    //Example 5:
    //
    //Input: piles = [11,20], h = 6
    //Output: 6
    piles = new int[]{11, 20};
    h = 6;
    System.out.println(solution.minEatingSpeed(piles, h));

    //Example 6:
    //
    //Input: piles = [5,7], h = 3
    //Output: 5
    piles = new int[]{5, 7};
    h = 3;
    System.out.println(solution.minEatingSpeed(piles, h));

    //Input: piles = [332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184]
    //h = 823855818
    //Output: -1
    //Expected: 14
    piles = new int[]{332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673,
        679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887,
        718203285, 629455728, 941802184};
    h = 823855818;
    System.out.println(solution.minEatingSpeed(piles, h));
  }

  public int minEatingSpeed(int[] piles, int h) {
    var start = 1;
    var end = Arrays.stream(piles).max().getAsInt();
    while (start <= end) {
      int mid = (start + end) / 2;
      if (getHours(piles, mid) <= h && getHours(piles, mid - 1) > h) {
        return mid;
      }
      if (getHours(piles, mid) > h) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return 0;
  }

  private int getHours(int[] piles, int speed) {
    int sum = 0;
    for (int pile : piles) {
      sum += Math.ceil(pile * 1.0 / speed);
    }
    return sum;
  }
}
