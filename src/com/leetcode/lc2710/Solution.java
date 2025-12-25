package com.leetcode.lc2710;

/*
2710. Remove Trailing Zeros From a String

Given a positive integer num represented as a string, return the integer num without trailing zeros as a string.



Example 1:

Input: num = "51230100"
Output: "512301"
Explanation: Integer "51230100" has 2 trailing zeros, we remove them and return integer "512301".

Example 2:

Input: num = "123"
Output: "123"
Explanation: Integer "123" has no trailing zeros, we return integer "123".



Constraints:

    1 <= num.length <= 1000
    num consists of only digits.
    num doesn't have any leading zeros.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeTrailingZeros("51230100"));
        System.out.println(solution.removeTrailingZeros("123"));
    }

    public String removeTrailingZeros(String num) {
        var i = num.length() - 1;
        while (num.charAt(i) == '0')
            i--;
        return num.substring(0, i + 1);
    }
}
