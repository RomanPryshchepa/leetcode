package com.leetcode.lc3370;

/*
3370. Smallest Number With All Set Bits

You are given a positive number n.

Return the smallest number x greater than or equal to n, such that the binary representation of x contains only



Example 1:

Input: n = 5

Output: 7

Explanation:

The binary representation of 7 is "111".

Example 2:

Input: n = 10

Output: 15

Explanation:

The binary representation of 15 is "1111".

Example 3:

Input: n = 3

Output: 3

Explanation:

The binary representation of 3 is "11".



Constraints:

    1 <= n <= 1000
 */
public class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.smallestNumber(5));
        System.out.println(solution.smallestNumber(10));
        System.out.println(solution.smallestNumber(3));
    }

    public int smallestNumber(int n) {
        var result = 0;
        while (n != 0) {
            n = n >> 1;
            result++;
        }
        return (1 << result) - 1;
    }
}
