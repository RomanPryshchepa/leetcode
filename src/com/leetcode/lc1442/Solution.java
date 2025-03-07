package com.leetcode.lc1442;

/*
1442. Count Triplets That Can Form Two Arrays of Equal XOR

Given an array of integers arr.

We want to select three indices i, j and k where (0 <= i < j <= k < arr.length).

Let's define a and b as follows:

    a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
    b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]

Note that ^ denotes the bitwise-xor operation.

Return the number of triplets (i, j and k) Where a == b.



Example 1:

Input: arr = [2,3,1,6,7]
Output: 4
Explanation: The triplets are (0,1,2), (0,2,2), (2,3,4) and (2,4,4)

Example 2:

Input: arr = [1,1,1,1,1]
Output: 10



Constraints:

    1 <= arr.length <= 300
    1 <= arr[i] <= 108
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.countTriplets(new int[]{2, 3, 1, 6, 7}));
    System.out.println(solution.countTriplets(new int[]{1, 1, 1, 1, 1}));
  }

  public int countTriplets(int[] arr) {
    var tmp = new int[arr.length + 1];
    for (int i = 0; i < arr.length; i++) {
      tmp[i + 1] = arr[i] ^ tmp[i];
    }
    var result = 0;
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        for (int k = j; k < arr.length; k++) {
          if ((tmp[i] ^ tmp[j]) == (tmp[j] ^ tmp[k + 1])) {
            result++;
          }
        }
      }
    }
    return result;
  }
}
