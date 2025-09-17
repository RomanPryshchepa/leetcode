package com.leetcode.lc3300;

/*
3300. Minimum Element After Replacement With Digit Sum

You are given an integer array nums.

You replace each element in nums with the sum of its digits.

Return the minimum element in nums after all replacements.



Example 1:

Input: nums = [10,12,13,14]

Output: 1

Explanation:

nums becomes [1, 3, 4, 5] after all replacements, with minimum element 1.

Example 2:

Input: nums = [1,2,3,4]

Output: 1

Explanation:

nums becomes [1, 2, 3, 4] after all replacements, with minimum element 1.

Example 3:

Input: nums = [999,19,199]

Output: 10

Explanation:

nums becomes [27, 10, 19] after all replacements, with minimum element 10.



Constraints:

    1 <= nums.length <= 100
    1 <= nums[i] <= 104
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.minElement(new int[]{10, 12, 13, 14}));
    System.out.println(solution.minElement(new int[]{1, 2, 3, 4}));
    System.out.println(solution.minElement(new int[]{999, 19, 199}));
  }

  public int minElement(int[] nums) {
    var result = Integer.MAX_VALUE;
    for (var n : nums)
      if (digitSum(n) < result)
        result = digitSum(n);
    return result;
  }

  private int digitSum(int num) {
    int sum = 0;
    while (num > 0) {
      sum += num % 10;
      num /= 10;
    }
    return sum;
  }
}
