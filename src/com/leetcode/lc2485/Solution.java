package com.leetcode.lc2485;

/*
2485. Find the Pivot Integer

Given a positive integer n, find the pivot integer x such that:

    The sum of all elements between 1 and x inclusively equals the sum of all elements between x and n inclusively.

Return the pivot integer x. If no such integer exists, return -1. It is guaranteed that there will be at most one pivot index for the given input.



Example 1:

Input: n = 8
Output: 6
Explanation: 6 is the pivot integer since: 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8 = 21.

Example 2:

Input: n = 1
Output: 1
Explanation: 1 is the pivot integer since: 1 = 1.

Example 3:

Input: n = 4
Output: -1
Explanation: It can be proved that no such integer exist.



Constraints:

    1 <= n <= 1000
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(solution.pivotInteger(8)); // 6
//    1 + 2 + 3 + 4 + 5 + 6 == 6 + 7 + 8
    System.out.println(solution.pivotInteger(1)); // 1
    System.out.println(solution.pivotInteger(4)); // -1
  }

  public int pivotInteger(int n) {
    int leftPointer = 1;
    int rightPointer = n;
    int leftSum = leftPointer;
    int rightSum = rightPointer;
    while (leftPointer < rightPointer) {
      if (leftSum < rightSum) {
        leftPointer++;
        leftSum += leftPointer;
      } else if (rightSum < leftSum) {
        rightPointer--;
        rightSum += rightPointer;
      } else {
        leftPointer++;
        leftSum += leftPointer;
        rightPointer--;
        rightSum += rightPointer;
      }
    }
    return leftSum == rightSum && leftPointer == rightPointer ? leftPointer : -1;
  }

  public int pivotInteger2(int n) {
    for (var i = 1; i <= n; i++) {
      if (2 * i * i == n * (n + 1)) // ((1 + i) * i / 2 == (1 + n) * n / 2 - (1 + i) * i / 2 + i)
        return i;
    }
    return -1;
  }
}
