package com.leetcode.lc1863;

import java.util.ArrayList;
import java.util.List;

/*
1863. Sum of All Subset XOR Totals

The XOR total of an array is defined as the bitwise XOR of all its elements, or 0 if the array is empty.

    For example, the XOR total of the array [2,5,6] is 2 XOR 5 XOR 6 = 1.

Given an array nums, return the sum of all XOR totals for every subset of nums.

Note: Subsets with the same elements should be counted multiple times.

An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b.



Example 1:

Input: nums = [1,3]
Output: 6
Explanation: The 4 subsets of [1,3] are:
- The empty subset has an XOR total of 0.
- [1] has an XOR total of 1.
- [3] has an XOR total of 3.
- [1,3] has an XOR total of 1 XOR 3 = 2.
0 + 1 + 3 + 2 = 6

Example 2:

Input: nums = [5,1,6]
Output: 28
Explanation: The 8 subsets of [5,1,6] are:
- The empty subset has an XOR total of 0.
- [5] has an XOR total of 5.
- [1] has an XOR total of 1.
- [6] has an XOR total of 6.
- [5,1] has an XOR total of 5 XOR 1 = 4.
- [5,6] has an XOR total of 5 XOR 6 = 3.
- [1,6] has an XOR total of 1 XOR 6 = 7.
- [5,1,6] has an XOR total of 5 XOR 1 XOR 6 = 2.
0 + 5 + 1 + 6 + 4 + 3 + 7 + 2 = 28

Example 3:

Input: nums = [3,4,5,6,7,8]
Output: 480
Explanation: The sum of all XOR totals for every subset is 480.



Constraints:

    1 <= nums.length <= 12
    1 <= nums[i] <= 20
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums;

    nums = new int[]{1, 3};
    System.out.println(solution.subsetXORSum(nums)); // 6
    System.out.println(solution.subsetXORSum2(nums)); // 6

    nums = new int[]{5, 1, 6};
    System.out.println(solution.subsetXORSum(nums)); // 28
    System.out.println(solution.subsetXORSum2(nums)); // 28 34???

    nums = new int[]{3, 4, 5, 6, 7, 8};
    System.out.println(solution.subsetXORSum(nums)); // 480
    System.out.println(solution.subsetXORSum2(nums)); // 480 514???
  }

  private int XORSum = 0;

  public int subsetXORSum2(int[] nums) {
    step(nums, 0, 0);
    return XORSum;
  }

  private void step(int[] nums, int index, int sum) {
    XORSum += sum;
    for (int i = index; i < nums.length; i++) {
      sum ^= nums[i];
      step(nums, i + 1, sum);
      sum ^= nums[i];
    }
  }

  public int subsetXORSum(int[] nums) {
    int res = 0;
    List<int[]> ints = kSubsets(nums);
    for (int[] anInt : ints) {
      int xor = 0;
      for (int i : anInt) {
        xor ^= i;
      }
      res += xor;
    }
    return res;
  }

  private static List<int[]> kSubsets(int[] nums) {
    List<int[]> subsets = new ArrayList<>();
    for (int k = 1; k <= nums.length; k++) {

      int[] s = new int[k];                  // here we'll keep indices
      // pointing to elements in input array
      // first index sequence: 0, 1, 2, ...
      for (int i = 0; (s[i] = i) < k - 1; i++)
        ;
      subsets.add(getSubset(nums, s));
      for (; ; ) {
        int i;
        // find position of item that can be incremented
        for (i = k - 1; i >= 0 && s[i] == nums.length - k + i; i--)
          ;
        if (i < 0) {
          break;
        }
        s[i]++;                    // increment this item
        for (++i; i < k; i++) {    // fill up remaining items
          s[i] = s[i - 1] + 1;
        }
        subsets.add(getSubset(nums, s));
      }
    }
    return subsets;
  }

  // generate actual subset by index sequence
  private static int[] getSubset(int[] input, int[] subset) {
    int[] result = new int[subset.length];
    for (int i = 0; i < subset.length; i++) {
      result[i] = input[subset[i]];
    }
    return result;
  }

}


