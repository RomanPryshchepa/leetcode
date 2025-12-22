package com.leetcode.lc1641;

import java.util.Arrays;

/*
1641. Count Sorted Vowel Strings

Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.

A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.



Example 1:

Input: n = 1
Output: 5
Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].

Example 2:

Input: n = 2
Output: 15
Explanation: The 15 sorted strings that consist of vowels only are
["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.

Example 3:

Input: n = 33
Output: 66045



Constraints:

    1 <= n <= 50
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countVowelStrings(1));
        System.out.println(solution.countVowelStrings(2));
        System.out.println(solution.countVowelStrings(33));
        System.out.println(solution.countVowelStrings(3));
        System.out.println(solution.countVowelStrings(4));
        System.out.println(solution.countVowelStrings(5));
    }

    public int countVowelStrings(int n) {
        final var vowelsCount = 5;
        if (n == 1)
            return vowelsCount;
        var arr = new int[vowelsCount];
        Arrays.fill(arr, 1);
        for (var k = 1; k < n; k++)
            for (var i = 1; i < vowelsCount; i++)
                arr[i] += arr[i - 1];
        var result = 0;
        for (var i = 0; i < vowelsCount; i++)
            result += arr[i];
        return result;
    }
}
