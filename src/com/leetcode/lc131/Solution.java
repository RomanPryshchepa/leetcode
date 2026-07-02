package com.leetcode.lc131;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
131. Palindrome Partitioning

Given a string s, partition s such that every of the partition is a . Return all possible palindrome partitioning of s.



Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:

Input: s = "a"
Output: [["a"]]



Constraints:

    1 <= s.length <= 16
    s contains only lowercase English letters.
 */
class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.partition("aab"));
        solution = new Solution();
        System.out.println(solution.partition("a"));
    }

    private int stringLength;
    private String inputString;
    private boolean[][] isPalindrome;
    private final List<String> currentPartition = new ArrayList<>();
    private final List<List<String>> allPartitions = new ArrayList<>();

    public List<List<String>> partition(String s) {
        stringLength = s.length();
        inputString = s;
        isPalindrome = new boolean[stringLength][stringLength];
        for (var i = 0; i < stringLength; i++)
            Arrays.fill(isPalindrome[i], true);
        for (var startIndex = stringLength - 1; startIndex >= 0; startIndex--)
            for (var endIndex = startIndex + 1; endIndex < stringLength; endIndex++)
                isPalindrome[startIndex][endIndex] =
                        s.charAt(startIndex) == s.charAt(endIndex) &&
                                isPalindrome[startIndex + 1][endIndex - 1];
        findPartitions(0);
        return allPartitions;
    }

    private void findPartitions(int startIndex) {
        if (startIndex == inputString.length()) {
            allPartitions.add(new ArrayList<>(currentPartition));
            return;
        }
        for (var endIndex = startIndex; endIndex < stringLength; endIndex++) {
            if (isPalindrome[startIndex][endIndex]) {
                currentPartition.add(inputString.substring(startIndex, endIndex + 1));
                findPartitions(endIndex + 1);
                currentPartition.removeLast();
            }
        }
    }
}
