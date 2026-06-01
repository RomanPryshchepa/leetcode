package com.leetcode.lc2707;

/*
2707. Extra Characters in a String

You are given a 0-indexed string s and a dictionary of words dictionary. You have to break s into one or more non-overlapping substrings such that each substring is present in dictionary. There may be some extra characters in s which are not present in any of the substrings.

Return the minimum number of extra characters left over if you break up s optimally.



Example 1:

Input: s = "leetscode", dictionary = ["leet","code","leetcode"]
Output: 1
Explanation: We can break s in two substrings: "leet" from index 0 to 3 and "code" from index 5 to 8. There is only 1 unused character (at index 4), so we return 1.

Example 2:

Input: s = "sayhelloworld", dictionary = ["hello","world"]
Output: 3
Explanation: We can break s in two substrings: "hello" from index 3 to 7 and "world" from index 8 to 12. The characters at indices 0, 1, 2 are not used in any substring and thus are considered as extra characters. Hence, we return 3.


Constraints:

1 <= s.length <= 50
1 <= dictionary.length <= 50
1 <= dictionary[i].length <= 50
dictionary[i] and s consists of only lowercase English letters
dictionary contains distinct words
 */
public class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.minExtraChar("abcde", new String[]{"a","b","c"})); // 2
        System.out.println(solution.minExtraChar("leetscode", new String[]{"leet","code","leetcode"}));
        System.out.println(solution.minExtraChar("sayhelloworld", new String[]{"hello","world"}));
    }

    public int minExtraChar(String s, String[] dictionary) {
        var trie = new TrieNode(null);
        for (String word : dictionary)
            addWord(trie, word);
        var res = 0;
        while (!s.isEmpty()) {
            var idx = getPrefixLength(trie, s);
            if (idx == -1) {
                res++;
                idx++;
            }
            else if (idx == s.length() - 1)
                break;
            s = s.substring(idx + 1);
        }
        return res;
    }

    private void addWord(TrieNode trie, String word) {
        var current = trie;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null)
                current.children[c - 'a'] = new TrieNode(c);
            current = current.children[c - 'a'];
        }
        current.isEnd = true;
    }

    private int getPrefixLength(TrieNode trie, String word) {
        if (trie.children[word.charAt(0) - 'a'] == null)
            return -1;
        var curr = trie;
        var endIdx = 0;
        for (var i = 0; i < word.length(); i++) {
            if (curr.children[word.charAt(i) - 'a'] != null && curr.children[word.charAt(i) - 'a'].isEnd)
                endIdx = i;
            if (curr.children[word.charAt(i) - 'a'] != null)
                curr = curr.children[word.charAt(i) - 'a'];
            else
                break;
        }
        return endIdx;
    }

    static class TrieNode {
        Character val;
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;

        public TrieNode(Character val) {
            this.val = val;
            this.isEnd = false;
        }
    }
}
