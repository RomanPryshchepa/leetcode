package com.leetcode.lc3304;

/*
3304. Find the K-th Character in String Game I

Alice and Bob are playing a game. Initially, Alice has a string word = "a".

You are given a positive integer k.

Now Bob will ask Alice to perform the following operation forever:

    Generate a new string by changing each character in word to its next character in the English alphabet, and append it to the original word.

For example, performing the operation on "c" generates "cd" and performing the operation on "zb" generates "zbac".

Return the value of the kth character in word, after enough operations have been done for word to have at least k characters.



Example 1:

Input: k = 5

Output: "b"

Explanation:

Initially, word = "a". We need to do the operation three times:

    Generated string is "b", word becomes "ab".
    Generated string is "bc", word becomes "abbc".
    Generated string is "bccd", word becomes "abbcbccd".

Example 2:

Input: k = 10

Output: "c"



Constraints:

    1 <= k <= 500
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kthCharacter(5));
        System.out.println(solution.kthCharacter(10));
        System.out.println(solution.kthCharacter(100));
    }

    public char kthCharacter(int k) {
        var sb = new StringBuilder("a");
        while (sb.length() < k) {
            sb.append(getNewStr(sb.toString()));
        }
        return sb.charAt(k - 1);
    }

    private String getNewStr(String str) {
        var sb = new StringBuilder();
        for (var c : str.toCharArray())
            if (c + 1 > 122)
                sb.append("a");
            else
                sb.append((char)(c + 1));
        return sb.toString();
    }
}
