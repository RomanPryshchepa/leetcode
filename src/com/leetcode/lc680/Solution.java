package com.leetcode.lc680;

/*
680. Valid Palindrome II

Given a string s, return true if the s can be palindrome after deleting at most one character from it.



Example 1:

Input: s = "aba"
Output: true

Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.

Example 3:

Input: s = "abc"
Output: false



Constraints:

    1 <= s.length <= 105
    s consists of lowercase English letters.
 */
public class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.validPalindrome("aba"));
        System.out.println(solution.validPalindrome("abca"));
        System.out.println(solution.validPalindrome("abc"));
    }

    public boolean validPalindrome(String s) {
        var lPointer = 0;
        var rPointer = s.length() - 1;
        while (lPointer < rPointer) {
            if (lPointer < s.length() && rPointer >= 0 && s.charAt(lPointer) != s.charAt(rPointer))
                return isPalindrome(s.substring(lPointer + 1, rPointer + 1)) || isPalindrome(s.substring(lPointer, rPointer));
            lPointer++;
            rPointer--;
        }
        return true;
    }

    private boolean isPalindrome(String s) {
        var lPointer = 0;
        var rPointer = s.length() - 1;
        while (lPointer < rPointer)
            if (lPointer < s.length() && rPointer >= 0 && s.charAt(lPointer++) != s.charAt(rPointer--))
                return false;
        return true;
    }
}
