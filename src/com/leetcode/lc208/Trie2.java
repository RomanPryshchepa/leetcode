package com.leetcode.lc208;

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
public class Trie2 {
    private Object[] storage;

    public void insert(String word) {
        if (storage == null)
            storage = new Object[27];
        var currStorage = storage;
        for (var letter : word.toCharArray()) {
            if (currStorage[letter - 'a'] == null)
                currStorage[letter - 'a'] = new Object[27];
            currStorage = (Object[])currStorage[letter - 'a'];
        }
        currStorage[26] = true;
    }

    public boolean search(String word) {
        if (storage == null)
            return false;
        var currStorage = storage;
        for (var letter : word.toCharArray()) {
            if (currStorage[letter - 'a'] == null)
                return false;
            currStorage = (Object[])currStorage[letter - 'a'];
        }
        return currStorage[26] != null && (boolean) currStorage[26];
    }

    public boolean startsWith(String prefix) {
        if (storage == null)
            return false;
        var currStorage = storage;
        for (var letter : prefix.toCharArray()) {
            if (currStorage[letter - 'a'] == null)
                return false;
            currStorage = (Object[])currStorage[letter - 'a'];
        }
        return true;
    }
}