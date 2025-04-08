package com.leetcode.lc1652;

import java.util.Arrays;

/*
1652. Defuse the Bomb

You have a bomb to defuse, and your time is running out! Your informer will provide you with a circular array code of length of n and a key k.

To decrypt the code, you must replace every number. All the numbers are replaced simultaneously.

    If k > 0, replace the ith number with the sum of the next k numbers.
    If k < 0, replace the ith number with the sum of the previous k numbers.
    If k == 0, replace the ith number with 0.

As code is circular, the next element of code[n-1] is code[0], and the previous element of code[0] is code[n-1].

Given the circular array code and an integer key k, return the decrypted code to defuse the bomb!



Example 1:

Input: code = [5,7,1,4], k = 3
Output: [12,10,16,13]
Explanation: Each number is replaced by the sum of the next 3 numbers. The decrypted code is [7+1+4, 1+4+5, 4+5+7, 5+7+1]. Notice that the numbers wrap around.

Example 2:

Input: code = [1,2,3,4], k = 0
Output: [0,0,0,0]
Explanation: When k is zero, the numbers are replaced by 0.

Example 3:

Input: code = [2,4,9,3], k = -2
Output: [12,5,6,13]
Explanation: The decrypted code is [3+9, 2+3, 4+2, 9+4]. Notice that the numbers wrap around again. If k is negative, the sum is of the previous numbers.



Constraints:

    n == code.length
    1 <= n <= 100
    1 <= code[i] <= 100
    -(n - 1) <= k <= n - 1
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(Arrays.toString(solution.decrypt(new int[]{5, 7, 1, 4}, 3)));
    System.out.println(Arrays.toString(solution.decrypt(new int[]{1, 2, 3, 4}, 0)));
    System.out.println(Arrays.toString(solution.decrypt(new int[]{2, 4, 9, 3}, -2)));
  }

  public int[] decrypt(int[] code, int k) {
    var result = new int[code.length];
    if (k == 0) {
      return result;
    }
    var prefSum = new int[code.length];
    prefSum[0] = code[0];
    for (int i = 1; i < code.length; i++) {
      prefSum[i] = prefSum[i - 1] + code[i];
    }
    if (k < 0) {
      for (int i = 0; i < code.length; i++) {
        result[i] = getSum(prefSum, i + k, i - 1);
      }
    } else {
      for (int i = 0; i < code.length; i++) {
        result[i] = getSum(prefSum, i + 1, i + k);
      }
    }
    return result;
  }

  private int getSum(int[] prefSum, int from, int to) {
    if (to < 0) {
      return prefSum[prefSum.length + to] - prefSum[prefSum.length + from - 1];
    }
    if (to >= prefSum.length) {
      return prefSum[prefSum.length - 1] - prefSum[from - 1] + prefSum[to - prefSum.length];
    }
    if (from <= 0) {
      return prefSum[to] + prefSum[prefSum.length - 1] - prefSum[prefSum.length + from - 1];
    }
    return prefSum[to] - prefSum[from - 1];
  }
}
