package com.leetcode.lc888;

import java.util.Arrays;

/*
888. Fair Candy Swap

Alice and Bob have a different total number of candies. You are given two integer arrays aliceSizes and bobSizes where aliceSizes[i] is the number of candies of the ith box of candy that Alice has and bobSizes[j] is the number of candies of the jth box of candy that Bob has.

Since they are friends, they would like to exchange one candy box each so that after the exchange, they both have the same total amount of candy. The total amount of candy a person has is the sum of the number of candies in each box they have.

Return an integer array answer where answer[0] is the number of candies in the box that Alice must exchange, and answer[1] is the number of candies in the box that Bob must exchange. If there are multiple answers, you may return any one of them. It is guaranteed that at least one answer exists.



Example 1:

Input: aliceSizes = [1,1], bobSizes = [2,2]
Output: [1,2]

Example 2:

Input: aliceSizes = [1,2], bobSizes = [2,3]
Output: [1,2]

Example 3:

Input: aliceSizes = [2], bobSizes = [1,3]
Output: [2,3]



Constraints:

    1 <= aliceSizes.length, bobSizes.length <= 104
    1 <= aliceSizes[i], bobSizes[j] <= 105
    Alice and Bob have a different total number of candies.
    There will be at least one valid answer for the given input.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(Arrays.toString(solution.fairCandySwap(new int[]{1, 1}, new int[]{2, 2})));
    System.out.println(Arrays.toString(solution.fairCandySwap(new int[]{1, 2}, new int[]{2, 3})));
    System.out.println(Arrays.toString(solution.fairCandySwap(new int[]{2},new int[]{1, 3})));
    System.out.println(Arrays.toString(solution.fairCandySwap(new int[]{1, 3, 5}, new int[]{1})));
  }

  public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
    var aliceSum = Arrays.stream(aliceSizes).sum();
    var bobSum = Arrays.stream(bobSizes).sum();
    var diff = (aliceSum - bobSum) / 2;
    if (aliceSizes.length < bobSizes.length) {
      Arrays.sort(bobSizes);
      for (var aliceElem : aliceSizes) {
        var bobIdx = BinarySearch(bobSizes, aliceElem - diff);
        if (bobIdx != -1) {
          return new int[]{aliceElem, bobSizes[bobIdx]};
        }
      }
    } else {
      Arrays.sort(aliceSizes);
      for (var bobElem : bobSizes) {
        var aliceIdx = BinarySearch(aliceSizes, bobElem + diff);
        if (aliceIdx != -1) {
          return new int[]{aliceSizes[aliceIdx], bobElem};
        }
      }
    }

    return new int[]{};
  }

  private int BinarySearch(int[] arr, int elem) {
    var start = 0;
    var end = arr.length - 1;
    var mid = 0;
    while (start <= end) {
      mid = (start + end) / 2;
      if (arr[mid] == elem) {
        return mid;
      }
      if (arr[mid] > elem) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return -1;
  }
}
