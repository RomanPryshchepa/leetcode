package com.leetcode.lc3794;

/*
3794. Reverse String Prefix

You are given a string s and an integer k.

Reverse the first k characters of s and return the resulting string.



Example 1:

Input: s = "abcd", k = 2

Output: "bacd"

Explanation:

The first k = 2 characters "ab" are reversed to "ba". The final resulting string is "bacd".

Example 2:

Input: s = "xyz", k = 3

Output: "zyx"

Explanation:

The first k = 3 characters "xyz" are reversed to "zyx". The final resulting string is "zyx".

Example 3:

Input: s = "hey", k = 1

Output: "hey"

Explanation:

The first k = 1 character "h" remains unchanged on reversal. The final resulting string is "hey".



Constraints:

    1 <= s.length <= 100
    s consists of lowercase English letters.
    1 <= k <= s.length
 */
public class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.reversePrefix("abcd", 2));
        System.out.println(solution.reversePrefix("xyz", 3));
        System.out.println(solution.reversePrefix("hey", 1));
    }

    public String reversePrefix(String s, int k) {
        if (k == s.length())
            return (new StringBuilder(s)).reverse().toString();
        if (k == 1)
            return s;
        return (new StringBuilder(s.substring(0, k))).reverse().append(s.substring(k)).toString();
    }
}
