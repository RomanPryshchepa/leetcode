package com.leetcode.lc1539;

/*
1539. Kth Missing Positive Number

Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Return the kth positive integer that is missing from this array.



Example 1:

Input: arr = [2,3,4,7,11], k = 5
Output: 9
Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.

Example 2:

Input: arr = [1,2,3,4], k = 2
Output: 6
Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.



Constraints:

    1 <= arr.length <= 1000
    1 <= arr[i] <= 1000
    1 <= k <= 1000
    arr[i] < arr[j] for 1 <= i < j <= arr.length



Follow up:

Could you solve this problem in less than O(n) complexity?
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));
    System.out.println(solution.findKthPositive2(new int[]{2, 3, 4, 7, 11}, 5));
    System.out.println(solution.findKthPositive(new int[]{1, 2, 3, 4}, 2));
    System.out.println(solution.findKthPositive2(new int[]{1, 2, 3, 4}, 2));
    System.out.println(solution.findKthPositive(new int[]{1}, 1000));
    System.out.println(solution.findKthPositive2(new int[]{1}, 1000));
    System.out.println(solution.findKthPositive(new int[]{1, 1000}, 1000));
    System.out.println(solution.findKthPositive2(new int[]{1, 1000}, 1000));
  }

  public int findKthPositive(int[] arr, int k) {
    var i = 0;
    var j = 1;
    while (i < arr.length && k > 0) {
      if (arr[i] != j) {
        k--;
      } else {
        i++;
      }
      j++;
    }
    return --j + k;
  }

  public int findKthPositive2(int[] arr, int k) {
    var i = 0;
    var cnt = 0;
    while (k > 0) {
      cnt++;
      if (i < arr.length && arr[i] == cnt)
        i++;
      else
        k--;
    }
    return cnt;
  }
}
