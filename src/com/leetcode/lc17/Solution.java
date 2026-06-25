package com.leetcode.lc17;

import java.util.LinkedList;
import java.util.List;

/*
17. Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:

Input: digits = "2"
Output: ["a","b","c"]



Constraints:

    1 <= digits.length <= 4
    digits[i] is a digit in the range ['2', '9'].
 */
public class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.letterCombinations("23"));
        System.out.println(solution.letterCombinations("2"));
    }

    public List<String> letterCombinations(String digits) {
        var result = new LinkedList<String>();
        var chars = getCharsFromDigit(digits.charAt(0));
        for (var ch : chars)
            result.add(""+ch);
        for (var i = 1; i < digits.length(); i++) {
            chars = getCharsFromDigit(digits.charAt(i));
            var size = result.size();
            for (var j = 0; j < size; j++) {
                var str = result.removeFirst();
                for (var ch : chars)
                    result.add((str + ch));
            }
        }
        return result;
    }

    private char[] getCharsFromDigit(char digit) {
        return switch (digit) {
            case '2' -> new char[]{'a', 'b', 'c'};
            case '3' -> new char[]{'d', 'e', 'f'};
            case '4' -> new char[]{'g', 'h', 'i'};
            case '5' -> new char[]{'j', 'k', 'l'};
            case '6' -> new char[]{'m', 'n', 'o'};
            case '7' -> new char[]{'p', 'q', 'r', 's'};
            case '8' -> new char[]{'t', 'u', 'v'};
            case '9' -> new char[]{'w', 'x', 'y', 'z'};
            default -> new char[0];
        };
    }
}
