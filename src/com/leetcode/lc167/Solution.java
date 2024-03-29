package com.leetcode.lc167;

import java.util.Arrays;

/*
167. Two Sum II - Input Array Is Sorted

Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.



Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].



Constraints:

    2 <= numbers.length <= 3 * 104
    -1000 <= numbers[i] <= 1000
    numbers is sorted in non-decreasing order.
    -1000 <= target <= 1000
    The tests are generated such that there is exactly one solution.

 */
public class Solution {

  // {1,2,3,4,5,6,7,8,9} target = 11, 2+9

  public static void main(String[] args) {
    //Input: numbers = [2,7,11,15], target = 9
    int[] numbers = new int[]{2, 7, 11, 15};
    int target = 9;
    //Output: [1,2]
    int[] res = twoSum(numbers, target);
    System.out.println(Arrays.toString(res));

//    Input: numbers = [2,3,4], target = 6
    numbers = new int[]{2, 3, 4};
    target = 6;
//    Output: [1,3]
    res = twoSum(numbers, target);
    System.out.println(Arrays.toString(res));

    //Input: numbers = [-1,0], target = -1
    numbers = new int[]{-1, 0};
    target = -1;
    //Output: [1,2]
    res = twoSum(numbers, target);
    System.out.println(Arrays.toString(res));

    //Input: numbers = [0,0,3,4], target = 0
    numbers = new int[]{0, 0, 3, 4};
    target = 0;
    //Output: [1,2]
    res = twoSum(numbers, target);
    System.out.println(Arrays.toString(res));

    //Input: numbers = [0,1,1,1,1,3,4], target = 3
    numbers = new int[]{0, 1, 1, 1, 1, 3, 4};
    target = 3;
    //Output: [1,6]
    res = twoSum(numbers, target);
    System.out.println(Arrays.toString(res));
  }

  public static int[] twoSum(int[] numbers, int target) {
    int i = 0;
    int j = numbers.length - 1;
    while (i < j) {
      if (numbers[i] + numbers[j] == target) {
        return new int[]{i + 1, j + 1};
      }
      if (numbers[i] + numbers[j] < target) {
        i++;
      } else {
        j--;
      }
    }
    return new int[0];
  }
}
