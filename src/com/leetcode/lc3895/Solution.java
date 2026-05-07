package com.leetcode.lc3895;

/*
3895. Count Digit Appearances

You are given an integer array nums and an integer digit.

Return the total number of times digit appears in the decimal representation of all elements in nums.



Example 1:

Input: nums = [12,54,32,22], digit = 2

Output: 4

Explanation:

The digit 2 appears once in 12 and 32, and twice in 22. Thus, the total number of times digit 2 appears is 4.

Example 2:

Input: nums = [1,34,7], digit = 9

Output: 0

Explanation:

The digit 9 does not appear in the decimal representation of any element in nums, so the total number of times digit 9 appears is 0.



Constraints:

    1 <= nums.length <= 1000
    1 <= nums[i] <= 106
    0 <= digit <= 9
 */
public class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.countDigitOccurrences(new int[]{12, 54, 32, 22}, 2));
        System.out.println(solution.countDigitOccurrences(new int[]{1, 34, 7}, 9));
    }

    public int countDigitOccurrences(int[] nums, int digit) {
        var cnt = 0;
        for (var num : nums)
            cnt += countDigitOccurrences(num, digit);
        return cnt;
    }

    private int countDigitOccurrences(int num, int digit) {
        var cnt = 0;
        while (num > 0) {
            if (num % 10 == digit)
                cnt++;
            num /= 10;
        }
        return cnt;
    }
}
