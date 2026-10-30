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
        System.out.println(solution.validPalindrome2("aba"));
        System.out.println();
        System.out.println(solution.validPalindrome("abca"));
        System.out.println(solution.validPalindrome2("abca"));
        System.out.println();
        System.out.println(solution.validPalindrome("abc"));
        System.out.println(solution.validPalindrome2("abc"));
        System.out.println();
        System.out.println(solution.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
        System.out.println(solution.validPalindrome2("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
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

    public boolean validPalindrome2(String s) {
        for (var i = 0; i < s.length() / 2; i++)
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                return isPalindrome(s, i + 1, s.length() - i - 1) || isPalindrome(s, i, s.length() - i - 2);
        return true;
    }

    private boolean isPalindrome(String s, int lp, int rp) {
        while (lp < rp)
            if (s.charAt(lp++) != s.charAt(rp--))
                return false;
        return true;
    }
}
