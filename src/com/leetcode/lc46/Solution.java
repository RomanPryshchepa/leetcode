package com.leetcode.lc46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
46. Permutations

Given an array nums of distinct integers, return all the possible

. You can return the answer in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:

Input: nums = [1]
Output: [[1]]



Constraints:

    1 <= nums.length <= 6
    -10 <= nums[i] <= 10
    All the integers of nums are unique.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.permute(new int[]{1, 2, 3}));
    System.out.println(solution.permute2(new int[]{1, 2, 3}));
    System.out.println(solution.permute(new int[]{1, 2, 3, 4}));
    System.out.println(solution.permute2(new int[]{1, 2, 3, 4}));
  }

  public List<List<Integer>> permute(int[] nums) {
    var n = 1;
    for (int i = 2; i <= nums.length; i++) {
      n *= i;
    }
    var list = Arrays.stream(nums).boxed().collect(Collectors.toList());
    Set<List<Integer>> result = new HashSet<>();
    result.add(new ArrayList<>(list));
    while (result.size() < n) {
      Collections.shuffle(list);
      result.add(new ArrayList<>(list));
    }
    return new ArrayList<>(result);
  }

  public List<List<Integer>> permute2(int[] nums) {
    var result = new ArrayList<List<Integer>>();
    result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    for (int step = 0; step < nums.length - 1; step++) {
      var size = result.size();
      for (var k = 0; k < size; k++) {
        var target = result.removeFirst();
        for (int j = step; j < nums.length; j++)
          result.add(swap(target, step, j));
      }
    }
    return result;
  }

  private List<Integer> swap(List<Integer> nums, int i, int j) {
    var result = new ArrayList<>(nums);
    if (i == j)
      return nums;
    int temp = result.get(i);
    result.set(i, nums.get(j));
    result.set(j, temp);
    return result;
  }
}
