package com.leetcode.lc27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
27. Remove Element

Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

    Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
    Return k.

Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int val = ...; // Value to remove
int[] expectedNums = [...]; // The expected answer with correct length.
                            // It is sorted with no values equaling val.

int k = removeElement(nums, val); // Calls your implementation

assert k == expectedNums.length;
sort(nums, 0, k); // Sort the first k elements of nums
for (int i = 0; i < actualLength; i++) {
    assert nums[i] == expectedNums[i];
}

If all assertions pass, then your solution will be accepted.



Example 1:

Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).

Example 2:

Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
Note that the five elements can be returned in any order.
It does not matter what you leave beyond the returned k (hence they are underscores).



Constraints:

    0 <= nums.length <= 100
    0 <= nums[i] <= 50
    0 <= val <= 100

 */
public class Solution {

  public static void main(String[] args) {
    int[] nums = new int[]{3, 2, 2, 3};
    int val = 3;
    System.out.println(removeElement(nums, val));
    System.out.println(Arrays.toString(nums));

    System.out.println("-----------------");

    nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
    val = 2;
    System.out.println(removeElement(nums, val));
    System.out.println(Arrays.toString(nums));

    System.out.println("-----------------");

    nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
    val = 5;
    System.out.println(removeElement(nums, val));
    System.out.println(Arrays.toString(nums));

    System.out.println("-----------------");

    nums = new int[]{4, 4, 5};
    val = 4;
    System.out.println(removeElement(nums, val));
    System.out.println(Arrays.toString(nums));
  }

  public static int removeElement(int[] nums, int val) {
    List<Integer> list = new ArrayList<>();
    for (int num : nums) {
      if (num != val) {
        list.add(num);
      }
    }
    int i = 0;
    for (Integer elem : list) {
      nums[i++] = elem;
    }
    return list.size();
  }

  public static int removeElement1(int[] nums, int val) {
    boolean isOnlyVals;
    int i;
    outher:
    for (i = 0; i < nums.length; i++) {
      while (nums[i] == val) {
        isOnlyVals = true;
        int k = i;
        while (k < nums.length - 1) {
          if (nums[k] != val) {
            isOnlyVals = false;
          }
          nums[k] = nums[k + 1];
          k++;
        }
        if (isOnlyVals) {
          break outher;
        }
      }
    }
    return i;
  }

}
