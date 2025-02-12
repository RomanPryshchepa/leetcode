package com.leetcode.lc1552;

import java.util.Arrays;

/*
1552. Magnetic Force Between Two Balls

In the universe Earth C-137, Rick discovered a special form of magnetic force between two balls if they are put in his new invented basket. Rick has n empty baskets, the ith basket is at position[i], Morty has m balls and needs to distribute the balls into the baskets such that the minimum magnetic force between any two balls is maximum.

Rick stated that magnetic force between two different balls at positions x and y is |x - y|.

Given the integer array position and the integer m. Return the required force.



Example 1:

Input: position = [1,2,3,4,7], m = 3
Output: 3
Explanation: Distributing the 3 balls into baskets 1, 4 and 7 will make the magnetic force between ball pairs [3, 3, 6]. The minimum magnetic force is 3. We cannot achieve a larger minimum magnetic force than 3.

Example 2:

Input: position = [5,4,3,2,1,1000000000], m = 2
Output: 999999999
Explanation: We can use baskets 1 and 1000000000.



Constraints:

    n == position.length
    2 <= n <= 105
    1 <= position[i] <= 109
    All integers in position are distinct.
    2 <= m <= position.length
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.maxDistance(new int[]{1, 2, 3, 4, 7}, 3)); //3
    System.out.println(solution.maxDistance(new int[]{5, 4, 3, 2, 1, 1000000000}, 2)); //999999999
    System.out.println(solution.maxDistance(new int[]{79, 74, 57, 22}, 4)); //5
    System.out.println(solution.maxDistance(new int[]{1, 1000, 1010, 1012}, 3)); //12
  }

  public int maxDistance(int[] position, int m) {
    Arrays.sort(position);
    var minPos = 1;
    var maxPos = position[position.length - 1] - position[0];
    var result = (minPos + maxPos) / 2;
    while (minPos <= maxPos) {
      if (check(position, result, m) && !check(position, result + 1, m))
        return result;
      else if (check(position, result, m) && check(position, result + 1, m))
        minPos = result + 1;
      else
        maxPos = result - 1;
      result = (minPos + maxPos) / 2;
    }
    return result;
  }

  private boolean check(int[] array, int distance, int m) {
    var next = array[0] + distance;
    m--;
    for (int i : array) {
      if (i >= next) {
        next = i + distance;
        m--;
      }
      if (m == 0)
        return true;
    }
    return false;
  }
}
