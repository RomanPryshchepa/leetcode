package com.leetcode.lc208;

import java.util.HashMap;
import java.util.Map;

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
class Trie {
    private final Map<Character, Object> map;

    public Trie() {
        map = new HashMap<>();
    }

    public void insert(String word) {
        var currMap = map;
        for (char c : word.toCharArray()) {
            if (!currMap.containsKey(c))
                currMap.put(c, new HashMap<>());
            currMap =  (Map<Character, Object>) currMap.get(c);
        }
        currMap.put('*', null);
    }

    public boolean search(String word) {
        var currMap = map;
        for (char c : word.toCharArray()) {
            if (!currMap.containsKey(c))
                return false;
            currMap =  (Map<Character, Object>) currMap.get(c);
        }
        return currMap.containsKey('*');
    }

    public boolean startsWith(String prefix) {
        var currMap = map;
        for (char c : prefix.toCharArray()) {
            if (!currMap.containsKey(c))
                return false;
            currMap =  (Map<Character, Object>) currMap.get(c);
        }
        return true;
    }
}

