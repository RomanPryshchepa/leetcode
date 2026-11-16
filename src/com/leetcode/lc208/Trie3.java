package com.leetcode.lc208;

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
public class Trie3 {
    private final Node[] nodes;

    public Trie3() {
        nodes = new Node[26];
    }

    public void insert(String word) {
        var currNodes = nodes;
        for (var i = 0; i < word.length(); i++) {
            if (currNodes[word.charAt(i) - 'a'] == null)
                currNodes[word.charAt(i) - 'a'] = new Node();
            if (i == word.length() - 1)
                currNodes[word.charAt(i) - 'a'].isEnd = true;

            currNodes = currNodes[word.charAt(i) - 'a'].children;
        }
    }

    public boolean search(String word) {
        var currNodes = nodes;
        for (var i = 0; i < word.length(); i++) {
            if (currNodes == null
                    || currNodes[word.charAt(i) - 'a'] == null
                    || !currNodes[word.charAt(i) - 'a'].hasValue
                    || i == word.length() - 1 && !currNodes[word.charAt(i) - 'a'].isEnd)
                return false;
            currNodes = currNodes[word.charAt(i) - 'a'].children;
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        var currNodes = nodes;
        for (var i = 0; i < prefix.length(); i++) {
            if (currNodes == null
                    || currNodes[prefix.charAt(i) - 'a'] == null
                    || !currNodes[prefix.charAt(i) - 'a'].hasValue)
                return false;
            currNodes = currNodes[prefix.charAt(i) - 'a'].children;
        }
        return true;
    }

    private static class Node {
        Node[] children;
        boolean hasValue;
        boolean isEnd;

        public Node() {
            hasValue = true;
            isEnd = false;
            children = new Node[26];
        }
    }
}
