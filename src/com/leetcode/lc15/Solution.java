package com.leetcode.lc15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
15. 3Sum

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.



Constraints:

    3 <= nums.length <= 3000
    -105 <= nums[i] <= 105

 */
public class Solution {

  public static void main(String[] args) {
    int[] nums;
    //Example 1:
    //
    //Input: nums = [-1,0,1,2,-1,-4]
    //Output: [[-1,-1,2],[-1,0,1]]
    //Explanation:
    //nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
    //nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
    //nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
    //The distinct triplets are [-1,0,1] and [-1,-1,2].
    //Notice that the order of the output and the order of the triplets does not matter.
    nums = new int[]{-1, 0, 1, 2, -1, -4};
    System.out.println(threeSum(nums));

    //Example 2:
    //
    //Input: nums = [0,1,1]
    //Output: []
    //Explanation: The only possible triplet does not sum up to 0.
    nums = new int[]{0, 1, 1};
    System.out.println(threeSum(nums));

    //Example 3:
    //
    //Input: nums = [0,0,0]
    //Output: [[0,0,0]]
    //Explanation: The only possible triplet sums up to 0.
    nums = new int[]{0, 0, 0};
    System.out.println(threeSum(nums));

    //Input: nums = [1,1,1]
    //Output: []
    nums = new int[]{1, 1, 1};
    System.out.println(threeSum(nums));

    //Input
    //nums =
    //[-2,0,1,1,2]
    //Use Testcase
    //Output
    //[[-2,0,2]]
    //Expected
    //[[-2,0,2],[-2,1,1]]
    nums = new int[]{-2, 0, 1, 1, 2};
    System.out.println(threeSum(nums));

    //Input
    //nums =
    //[-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6]
    //Use Testcase
    //Output
    //[[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],[-2,-2,4],[-2,0,2],[-2,-2,4],[-2,0,2]]
    //Expected
    //[[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],[-2,-2,4],[-2,0,2]]
    nums = new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
    System.out.println(threeSum(nums));

    //Input
    //nums =
    //[-1,0,1,2,-1,-4,-2,-3,3,0,4]
    //Use Testcase
    //Output
    //[[-4,0,4],[-4,1,3],[-3,-1,4],[-3,0,3],[-3,1,2],[-2,-1,3],[-2,0,2],[-1,0,1]]
    //Expected
    //[[-4,0,4],[-4,1,3],[-3,-1,4],[-3,0,3],[-3,1,2],[-2,-1,3],[-2,0,2],[-1,-1,2],[-1,0,1]]
    nums = new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
    System.out.println(threeSum(nums));
  }

  public static List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int j = i + 1;
      int k = nums.length - 1;

      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum < 0) {
          j++;
        } else if (sum > 0) {
          k--;
        } else {
          result.add(List.of(nums[i], nums[j], nums[k]));
          j++;
          while (j < nums.length && nums[j] == nums[j - 1]) {
            j++;
          }
        }
      }

    }
    return result;
  }

  public static List<List<Integer>> threeSum_incorrect(int[] nums) {
    Arrays.sort(nums);
    if (nums[0] > 0 || nums[nums.length - 1] < 0) {
      return List.of();
    }
    List<List<Integer>> result = new ArrayList<>();
    int i = 0;
    while (nums[i] <= 0 && i < nums.length - 2) {
      int j = i + 1;
      int k = nums.length - 1;
      while (j < k) {
        if (nums[i] + nums[j] + nums[k] == 0) {
          if (!isListContains(result, nums[i], nums[j])) {
            result.add(List.of(nums[i], nums[j], nums[k]));
          }
          j++;
          k--;
        } else if (nums[i] + nums[j] + nums[k] < 0) {
          j++;
        } else {
          k--;
        }
      }
      i++;
    }
    return result;
  }

  private static boolean isListContains(List<List<Integer>> result, Integer num1, Integer num2) {
    if (result == null || result.isEmpty() || num1 == null || num2 == null) {
      return false;
    }
    for (List<Integer> integers : result) {
      if (integers.contains(num1) && integers.contains(num2)) {
        return true;
      }
    }
    return false;
  }
}
