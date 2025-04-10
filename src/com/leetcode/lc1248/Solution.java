package com.leetcode.lc1248;

/*
1248. Count Number of Nice Subarrays

Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.



Example 1:

Input: nums = [2,2,1,1,2,1,1], k = 3
Input: nums = [1,1,2,1,1], k = 3
Output: 2
Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].

Example 2:

Input: nums = [2,4,6], k = 1
Output: 0
Explanation: There are no odd numbers in the array.

Example 3:

Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
Output: 16



Constraints:

    1 <= nums.length <= 50000
    1 <= nums[i] <= 10^5
    1 <= k <= nums.length
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.numberOfSubarrays(new int[]{1,1,2,1,1}, 3));
    System.out.println(solution.numberOfSubarrays(new int[]{2,4,6}, 1));
    System.out.println(solution.numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2}, 2));
    System.out.println(solution.numberOfSubarrays(new int[]{2,2,2,2,2,2,1,1,2,1,1}, 3));
  }

  public int numberOfSubarrays(int[] nums, int k) {
    var prefOddCount = new int[nums.length + 1];
    var cnt = 0;
    prefOddCount[0] = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] % 2 == 1) {
        cnt++;
      }
      prefOddCount[i + 1] = cnt;
    }
    if (cnt < k)
      return 0;
    var result = 0;
    for (int end = prefOddCount.length - 1; end > 0; end--) {
      if (prefOddCount[end] < k)
        break;
      for (int start = 0; start < end; start++) {
        if (prefOddCount[end] - prefOddCount[start] < k)
          break;
        if (prefOddCount[end] - prefOddCount[start] == k)
          result++;
      }
    }
    return result;
  }
}
