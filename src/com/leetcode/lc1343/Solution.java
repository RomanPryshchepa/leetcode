package com.leetcode.lc1343;

import java.util.Arrays;

/*
1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold

Given an array of integers arr and two integers k and threshold, return the number of sub-arrays of size k and average greater than or equal to threshold.



Example 1:

Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
Output: 3
Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 respectively. All other sub-arrays of size 3 have averages less than 4 (the threshold).

Example 2:

Input: arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5
Output: 6
Explanation: The first 6 sub-arrays of size 3 have averages greater than 5. Note that averages are not integers.



Constraints:

    1 <= arr.length <= 105
    1 <= arr[i] <= 104
    1 <= k <= arr.length
    0 <= threshold <= 104
 */
public class Solution {

  public static void main(String[] args) {
    var solution = new Solution();
    System.out.println(solution.numOfSubarrays(new int[]{2, 2, 2, 2, 5, 5, 5, 8}, 3, 4));
    System.out.println(solution.numOfSubarrays(new int[]{11, 13, 17, 23, 29, 31, 7, 5, 2, 3}, 3, 5));
  }

  public int numOfSubarrays(int[] arr, int k, int threshold) {
    if (k > arr.length) {
      return 0;
    }
    int result = 0;
    double avg = Arrays.stream(arr).limit(k).average().getAsDouble();
    if (avg >= threshold) {
      result++;
    }
    for (int i = k; i < arr.length; i++) {
      avg = avg + (double) (arr[i] - arr[i - k]) / k;
      if (avg >= threshold) {
        result++;
      }
    }
    return result;
  }
}
