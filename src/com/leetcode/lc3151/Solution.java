package com.leetcode.lc3151;

/*
3151. Special Array I

An array is considered special if the parity of every pair of adjacent elements is different. In other words, one element in each pair must be even, and the other must be odd.

You are given an array of integers nums. Return true if nums is a special array, otherwise, return false.



Example 1:

Input: nums = [1]

Output: true

Explanation:

There is only one element. So the answer is true.

Example 2:

Input: nums = [2,1,4]

Output: true

Explanation:

There is only two pairs: (2,1) and (1,4), and both of them contain numbers with different parity. So the answer is true.

Example 3:

Input: nums = [4,3,1,6]

Output: false

Explanation:

nums[1] and nums[2] are both odd. So the answer is false.



Constraints:

    1 <= nums.length <= 100
    1 <= nums[i] <= 100
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isArraySpecial(new int[]{1}));
        System.out.println(solution.isArraySpecial(new int[]{2, 1, 4}));
        System.out.println(solution.isArraySpecial(new int[]{4, 3, 1, 6}));
    }

    public boolean isArraySpecial(int[] nums) {
        if (nums.length == 1)
            return true;
        for (var i = 1; i < nums.length; i++)
            if ((nums[i - 1] + nums[i]) % 2 == 0)
                return false;
        return true;
    }
}
