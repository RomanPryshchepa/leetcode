package com.leetcode.lc648;

import java.util.List;

/*
648. Replace Words

In English, we have a concept called root, which can be followed by some other word to form another longer word - let's call this word derivative. For example, when the root "help" is followed by the word "ful", we can form a derivative "helpful".

Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace all the derivatives in the sentence with the root forming it. If a derivative can be replaced by more than one root, replace it with the root that has the shortest length.

Return the sentence after the replacement.



Example 1:

Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"

Example 2:

Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
Output: "a a b c"



Constraints:

    1 <= dictionary.length <= 1000
    1 <= dictionary[i].length <= 100
    dictionary[i] consists of only lower-case letters.
    1 <= sentence.length <= 106
    sentence consists of only lower-case letters and spaces.
    The number of words in sentence is in the range [1, 1000]
    The length of each word in sentence is in the range [1, 1000]
    Every two consecutive words in sentence will be separated by exactly one space.
    sentence does not have leading or trailing spaces.
 */
class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.replaceWords(List.of("cat","bat","rat"), "the cattle was rattled by the battery"));
        System.out.println(solution.replaceWords(List.of("a","b","c"), "aadsfasf absbs bbab cadsfafs"));
        System.out.println(solution.replaceWords(List.of("ax","aaa","aab","aac","aad"), "aaab")); // "aaa"
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        var trie = new Trie();
        for (String word : dictionary)
            trie.insert(word);
        var words = sentence.split(" ");
        var res = new StringBuilder();
        for (String word : words) {
            if (!res.isEmpty())
                res.append(" ");
            res.append(trie.prefix(word).isEmpty() ? word : trie.prefix(word));
        }
        return res.toString();
    }

    static class Trie {
        private final TrieNode[] trie;

        public Trie() {
            trie = new TrieNode[26];
        }

        public void insert(String word) {
            var currTrie = trie;
            TrieNode currTrieNode = null;
            for (var ch : word.toCharArray()) {
                if (currTrie[ch - 'a'] == null)
                    currTrie[ch - 'a'] = new TrieNode(ch);
                currTrieNode = currTrie[ch - 'a'];
                currTrie = currTrie[ch - 'a'].children;
            }
            if (currTrieNode != null)
                currTrieNode.isEnd = true;
        }

        public String prefix(String word) {
            var sb = new StringBuilder();
            var currTrie = trie;
            var hasEnd = false;
            for (var ch : word.toCharArray()) {
                if (currTrie[ch - 'a'] == null)
                    break;
                sb.append(currTrie[ch - 'a'].val);
                if (currTrie[ch - 'a'].isEnd) {
                    hasEnd = true;
                    break;
                }
                currTrie = currTrie[ch - 'a'].children;
            }
            if (!hasEnd)
                return "";
            return sb.toString();
        }

        static class TrieNode {
            char val;
            TrieNode[] children;
            boolean isEnd;


            public TrieNode(char val) {
                this(val, false);
            }

            public TrieNode(char val, boolean isEnd) {
                this.val = val;
                this.isEnd = isEnd;
                this.children = new TrieNode[26];
            }
        }
    }
}
