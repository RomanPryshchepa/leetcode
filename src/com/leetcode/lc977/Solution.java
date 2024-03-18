package com.leetcode.lc977;

import java.util.Arrays;

/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
Example 1:
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:
Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
Constraints:
    1 <= nums.length <= 104
    -104 <= nums[i] <= 104
    nums is sorted in non-decreasing order.
Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] nums;

    nums = new int[]{-4, -1, 0, 3, 10};
    System.out.println(Arrays.toString(nums));
    System.out.println(Arrays.toString(solution.sortedSquares(nums))); // [0,1,9,16,100]

    nums = new int[]{-7, -3, 2, 3, 11};
    System.out.println(Arrays.toString(nums));
    System.out.println(Arrays.toString(solution.sortedSquares(nums))); // [4,9,9,49,121]

    nums = new int[]{0};
    System.out.println(Arrays.toString(nums));
    System.out.println(Arrays.toString(solution.sortedSquares(nums))); // [9,9,49,121]
  }

  public int[] sortedSquares(int[] nums) {
    int[] squares = new int[nums.length];
    int leftP = 0;
    int rightP = nums.length - 1;
    int squaresIdx = squares.length - 1;
    while (leftP <= rightP) {
      if (nums[leftP] * nums[leftP] >= nums[rightP] * nums[rightP]) {
        squares[squaresIdx--] = nums[leftP] * nums[leftP];
        leftP++;
      } else {
        squares[squaresIdx--] = nums[rightP] * nums[rightP];
        rightP--;
      }
    }
    return squares;
  }
}
