package com.leetcode.lc3760;

import java.util.HashSet;

/*
3760. Maximum Substrings With Distinct Start

You are given a string s consisting of lowercase English letters.

Return an integer denoting the maximum number of you can split s into such that each substring starts with a distinct character (i.e., no two substrings start with the same character).



Example 1:

Input: s = "abab"

Output: 2

Explanation:

    Split "abab" into "a" and "bab".
    Each substring starts with a distinct character i.e 'a' and 'b'. Thus, the answer is 2.

Example 2:

Input: s = "abcd"

Output: 4

Explanation:

    Split "abcd" into "a", "b", "c", and "d".
    Each substring starts with a distinct character. Thus, the answer is 4.

Example 3:

Input: s = "aaaa"

Output: 1

Explanation:

    All characters in "aaaa" are 'a'.
    Only one substring can start with 'a'. Thus, the answer is 1.



Constraints:

    1 <= s.length <= 105
    s consists of lowercase English letters.
 */
public class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.maxDistinct("abab"));
        System.out.println(solution.maxDistinct("abcd"));
        System.out.println(solution.maxDistinct("aaaa"));
        System.out.println(solution.maxDistinct("rabbbit"));
    }

    public int maxDistinct(String s) {
        var set = new HashSet<Character>();
        for (var ch : s.toCharArray())
            set.add(ch);
        return set.size();
    }
}
