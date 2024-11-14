package com.leetcode.lc1011;

/*
1011. Capacity To Ship Packages Within D Days

A conveyor belt has packages that must be shipped from one port to another within days days.

The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.



Example 1:

Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
Output: 15
Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.

Example 2:

Input: weights = [3,2,2,4,1,4], days = 3
Output: 6
Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
1st day: 3, 2
2nd day: 2, 4
3rd day: 1, 4

Example 3:

Input: weights = [1,2,3,1,1], days = 4
Output: 3
Explanation:
1st day: 1
2nd day: 2
3rd day: 3
4th day: 1, 1



Constraints:

    1 <= days <= weights.length <= 5 * 104
    1 <= weights[i] <= 500
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5)); // 15
    System.out.println(solution.shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3)); // 6
    System.out.println(solution.shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4)); // 3
    System.out.println(solution.shipWithinDays(new int[]{1, 1, 1, 1, 1}, 5)); // 1
    System.out.println(solution.shipWithinDays(new int[]{10, 1, 10, 10, 10}, 2)); // 21
    System.out.println(solution.shipWithinDays(new int[]{1}, 1)); // 1
    System.out.println(solution.shipWithinDays(new int[]{1}, 2)); // 1
    System.out.println(solution.shipWithinDays(new int[]{5}, 2)); // 5
    System.out.println(solution.shipWithinDays(new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, 8)); // 10
  }

  public int shipWithinDays(int[] weights, int days) {
    var sum = 0;
    var max = Integer.MIN_VALUE;
    for (int weight : weights) {
      sum += weight;
      max = Math.max(max, weight);
    }
    var start = Math.max(max, sum / days);
    if (check(weights, days, start)) {
      return start;
    }
    var end = sum;
    var mid = 0;
    while (start <= end) {
      mid = start + (end - start) / 2;
      if (!check(weights, days, mid - 1) && check(weights, days, mid)) {
        return mid;
      }
      if (check(weights, days, mid - 1) && check(weights, days, mid)) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return -1;
  }

  private boolean check(int[] weights, int days, int capacity) {
    int sum = 0;
    int count = 0;
    for (int weight : weights) {
      sum += weight;
      if (sum > capacity) {
        sum = weight;
        count++;
      }
      if (count > days) {
        return false;
      }
    }
    return ++count <= days;
  }
}
