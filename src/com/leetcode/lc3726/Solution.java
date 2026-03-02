package com.leetcode.lc3726;

/*
3726. Remove Zeros in Decimal Representation

You are given a positive integer n.

Return the integer obtained by removing all zeros from the decimal representation of n.



Example 1:

Input: n = 1020030

Output: 123

Explanation:

After removing all zeros from 1020030, we get 123.

Example 2:

Input: n = 1

Output: 1

Explanation:

1 has no zero in its decimal representation. Therefore, the answer is 1.



Constraints:

    1 <= n <= 1015
 */
public class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.removeZeros(1020030));
        System.out.println(solution.removeZeros(1));
        System.out.println(solution.removeZeros(1000000002000300040L));
    }

    public long removeZeros(long n) {
        long res = 0;
        long step = 1;
        while (n != 0) {
            if (n % 10 != 0) {
                res += (n % 10) * step;
                step *= 10;
            }
            n /= 10;
        }
        return res;
    }
}
