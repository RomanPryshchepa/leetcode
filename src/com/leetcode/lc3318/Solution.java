package com.leetcode.lc3318;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/*
3318. Find X-Sum of All K-Long Subarrays I

You are given an array nums of n integers and two integers k and x.

The x-sum of an array is calculated by the following procedure:

    Count the occurrences of all elements in the array.
    Keep only the occurrences of the top x most frequent elements. If two elements have the same number of occurrences, the element with the bigger value is considered more frequent.
    Calculate the sum of the resulting array.

Note that if an array has less than x distinct elements, its x-sum is the sum of the array.

Return an integer array answer of length n - k + 1 where answer[i] is the x-sum of the

nums[i..i + k - 1].



Example 1:

Input: nums = [1,1,2,2,3,4,2,3], k = 6, x = 2

Output: [6,10,12]

Explanation:

    For subarray [1, 1, 2, 2, 3, 4], only elements 1 and 2 will be kept in the resulting array. Hence, answer[0] = 1 + 1 + 2 + 2.
    For subarray [1, 2, 2, 3, 4, 2], only elements 2 and 4 will be kept in the resulting array. Hence, answer[1] = 2 + 2 + 2 + 4. Note that 4 is kept in the array since it is bigger than 3 and 1 which occur the same number of times.
    For subarray [2, 2, 3, 4, 2, 3], only elements 2 and 3 are kept in the resulting array. Hence, answer[2] = 2 + 2 + 2 + 3 + 3.

Example 2:

Input: nums = [3,8,7,8,7,5], k = 2, x = 2

Output: [11,15,15,15,12]

Explanation:

Since k == x, answer[i] is equal to the sum of the subarray nums[i..i + k - 1].



Constraints:

    1 <= n == nums.length <= 50
    1 <= nums[i] <= 50
    1 <= x <= k <= nums.length
 */
public class Solution {

  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(Arrays.toString(sol.findXSum(new int[]{1, 1, 2, 2, 3, 4, 2, 3}, 6, 2)));
    System.out.println(Arrays.toString(sol.findXSum(new int[]{3, 8, 7, 8, 7, 5}, 2, 2)));
  }

  public int[] findXSum(int[] nums, int k, int x) {
    var result = new int[nums.length - k + 1];
    for (int i = 0; i < nums.length - k + 1; i++) {
      result[i] = GetXSum(nums, i, k, x);
    }
    return result;
  }

  private int GetXSum(int[] nums, int start, int len, int x) {
    var map = new HashMap<Integer, Integer>();
    for (int i = start; i < start + len; i++) {
      if (map.containsKey(nums[i])) {
        map.put(nums[i], map.get(nums[i]) + 1);
      } else {
        map.put(nums[i], 1);
      }
    }
    List<Entry<Integer, Integer>> myList = new ArrayList<>(map.entrySet());
    myList.sort((pair1, pair2) -> pair2.getValue().compareTo(pair1.getValue()) == 0 ? pair2.getKey()
        .compareTo(pair1.getKey()) : pair2.getValue().compareTo(pair1.getValue()));
    var sum = 0;
    var idx = 0;
    while (x > 0 && idx < myList.size()) {
      sum += myList.get(idx).getKey() * myList.get(idx).getValue();
      idx++;
      x--;
    }
    return sum;
  }
}
