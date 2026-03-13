package com.leetcode.lc383;

/*
383. Ransom Note

Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.



Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true



Constraints:

    1 <= ransomNote.length, magazine.length <= 105
    ransomNote and magazine consist of lowercase English letters.
 */
public class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.canConstruct("a", "b"));
        System.out.println(solution.canConstruct("aa", "ab"));
        System.out.println(solution.canConstruct("aa", "aab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        var letters = new int[26];
        for (var ch : magazine.toCharArray())
            letters[ch - 'a']++;
        for (var ch : ransomNote.toCharArray()) {
            letters[ch - 'a']--;
            if (letters[ch - 'a'] < 0)
                return false;
        }
        return true;
    }
}
