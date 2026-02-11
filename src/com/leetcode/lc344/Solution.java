package com.leetcode.lc344;

import java.util.Arrays;

/*
344. Reverse String

Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.



Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]



Constraints:

    1 <= s.length <= 105
    s[i] is a printable ascii character.
 */
public class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        char[] s;

        s = new char[]{'h','e','l','l','o'};
        solution.reverseString(s);
        System.out.println(Arrays.toString(s));

        s = new char[]{'H','a','n','n','a','h'};
        solution.reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public void reverseString(char[] s) {
        for (var i = 0; i < s.length / 2; i++) {
            if (s[i] != s[s.length - i - 1]) {
                s[i] += s[s.length - i - 1];
                s[s.length - i - 1] = (char)((int)s[i] - (int)s[s.length - i - 1]);
                s[i] -= s[s.length - i - 1];
            }
        }
    }
}
