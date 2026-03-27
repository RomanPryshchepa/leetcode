package com.leetcode.lc1456;

/*
1456. Maximum Number of Vowels in a Substring of Given Length

Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.



Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.

Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.

Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.



Constraints:

    1 <= s.length <= 105
    s consists of lowercase English letters.
    1 <= k <= s.length
 */
public class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.maxVowels("abciiidef", 3));
        System.out.println(solution.maxVowels("aeiou", 2));
        System.out.println(solution.maxVowels("leetcode", 3));
    }

    public int maxVowels(String s, int k) {
        var max = 0;
        for (var i = 0; i < k; i++) {
            if ("aeiou".indexOf(s.charAt(i)) >= 0)
                max++;
        }
        var left = 1;
        var right = left + k - 1;
        var len = max;
        for (; right < s.length(); right++, left++) {
            if ("aeiou".indexOf(s.charAt(right)) >= 0)
                len++;
            if ("aeiou".indexOf(s.charAt(left - 1)) >= 0)
                len--;
            max = Math.max(max, len);
        }
        return max;
    }
}
