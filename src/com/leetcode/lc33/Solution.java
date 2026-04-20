package com.leetcode.lc33;

/*
33. Search in Rotated Sorted Array

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:

Input: nums = [1], target = 0
Output: -1



Constraints:

    1 <= nums.length <= 5000
    -104 <= nums[i] <= 104
    All values of nums are unique.
    nums is an ascending array that is possibly rotated.
    -104 <= target <= 104
 */
public class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.search(new int[] {4,5,6,7,0,1,2}, 0)); // 4
        System.out.println(solution.search(new int[] {4,5,6,7,0,1,2}, 3)); // -1
        System.out.println(solution.search(new int[] {1}, 0)); // -1
        System.out.println(solution.search(new int[] {5,6,7,8,9,10,11,12,13,14,15,0,1,2,3,4}, 9)); // 4
        System.out.println(solution.search(new int[] {5,6,7,8,9,10,11,12,13,14,15,0,1,2,3,4}, 0)); // 11
        System.out.println(solution.search(new int[] {5,6,7,8,9,10,11,12,13,14,15,0,1,2,3,4}, 1)); // 12
        System.out.println(solution.search(new int[] {5,6,7,8,9,10,11,12,13,14,15,0,1,2,3,4}, 6)); // 1
        System.out.println(solution.search(new int[] {5,6,7,8,9,10,11,12,13,14,15,0,1,2,3,4}, 3)); // 14
        System.out.println(solution.search(new int[] {5,6,7,8,9,10,11,12,13,14,15,0,1,2,3,4}, 5)); // 0
        System.out.println(solution.search(new int[] {5,6,7,8,9,10,11,12,13,14,15,0,1,2,3,4}, 4)); // 15
        System.out.println(solution.search(new int[] {5,6,7,8,9,10,11,12,13,14,15,0,1,2,3,4}, 13)); // 8
        System.out.println(solution.search(new int[] {5,6,7,8,9,10,11,12,13,14,15,0,1,2,3,4}, 23)); // -1
    }

    //     0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15
    //     5  6  7  8  9 10 11 12 13 14 15  0  1  2  3  4
    // 1 - 5  6  7  8  9 st<mid<end
    // else
    // 2 - 13 14 15  0  1  2  3 mid<st mid<end : left - target<mid || target>=st ; right - mid<target<=end
    // 3 - 11 12 13 14 15  0  1 mid>st mid>end : left - st=<target<mid; right - target>mid || target<=end


    public int search(int[] nums, int target) {
        var start  = 0;
        var end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[start] < nums[end]) {
                if (nums[mid] < target)
                    start = mid + 1;
                else
                    end = mid - 1;
            } else {
                if (nums[mid] < nums[start] && nums[mid] < nums[end]) {
                    if (nums[mid] < target && target <= nums[end])
                        start = mid + 1;
                    else // target < nums[mid] || target >= nums[start]
                        end = mid - 1;
                } else { // nums[mid] > nums[start] && nums[mid] > nums[end]
                    if (nums[start] <= target && target < nums[mid])
                        end = mid - 1;
                    else
                        start = mid + 1;
                }
            }
        }
        return -1;
    }
}
