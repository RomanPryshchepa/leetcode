package com.leetcode.lc88;

import java.util.Arrays;

/*
88. Merge Sorted Array

You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.



Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].

Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 */
public class Solution {

  public static void main(String[] args) {
    var solution = new Solution();
    int[] num;
    int[] num2;

    num = new int[]{2, 0};
    solution.merge(num, 1, new int[]{1}, 1);
    System.out.println(Arrays.toString(num));

    num = new int[]{-10, -10, -9, -9, -9, -8, -8, -7, -7, -7, -6, -6, -6, -6, -6, -6, -6, -5, -5,
        -5, -4, -4, -4, -3, -3, -2, -2, -1, -1, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 5, 5, 6, 6, 6, 6,
        7, 7, 7, 7, 8, 9, 9, 9, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    num2 = new int[]{-10, -10, -9, -9, -9, -9, -8, -8, -8, -8, -8, -7, -7, -7, -7, -7, -7, -7, -7,
        -6, -6, -6, -6, -5, -5, -5, -5, -5, -4, -4, -4, -4, -4, -3, -3, -3, -2, -2, -2, -2, -2, -2,
        -2, -1, -1, -1, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4,
        4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9};
    solution.merge(num, 55, num2, 99);
    System.out.println(Arrays.toString(num));

    num = new int[]{1, 2, 4, 5, 6, 0};
    solution.merge(num, 5, new int[]{3}, 1);
    System.out.println(Arrays.toString(num));

    num = new int[]{1, 3, 5, 0, 0, 0};
    solution.merge(num, 3, new int[]{2, 4, 6}, 3);
    System.out.println(Arrays.toString(num));

    num = new int[]{1, 2, 3, 0, 0, 0};
    solution.merge(num, 3, new int[]{2, 5, 6}, 3);
    System.out.println(Arrays.toString(num));

    num = new int[]{1};
    solution.merge(num, 1, new int[]{}, 0);
    System.out.println(Arrays.toString(num));

    num = new int[]{0};
    solution.merge(num, 0, new int[]{1}, 1);
    System.out.println(Arrays.toString(num));
  }

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    var pointer1 = m - 1;
    var pointer2 = n - 1;
    var pointer = m + n - 1;
    while (pointer1 >= 0 && pointer2 >= 0) {
      if (nums1[pointer1] < nums2[pointer2]) {
        nums1[pointer--] = nums2[pointer2--];
      } else {
        nums1[pointer--] = nums1[pointer1--];
      }
    }
    while (pointer1 >= 0) {
      nums1[pointer--] = nums1[pointer1--];
    }
    while (pointer2 >= 0) {
      nums1[pointer--] = nums2[pointer2--];
    }
  }
}
