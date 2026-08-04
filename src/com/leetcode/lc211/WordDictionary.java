package com.leetcode.lc211;

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
class WordDictionary {
    private final Object[] storage;

    public WordDictionary() {
        storage = new Object[27];
    }

    public void addWord(String word) {
        var level = storage;
        for (var letter : word.toCharArray()) {
            if (level[letter - 'a'] == null)
                level[letter - 'a'] = new Object[27];
            level = (Object[])level[letter - 'a'];
        }
        level[26] = true;
    }

    public boolean search(String word) {
        if (word.indexOf('.') == -1)
            return searchWoDots(word);
        if (word.indexOf('.') != -1) {
            if (word.indexOf('.', word.indexOf('.') + 1) != -1) {
                for (var ch1 = 'a'; ch1 <= 'z'; ch1++) {
                    var newWord = word.replaceFirst("\\.", "" + ch1);
                    for (var ch2 = 'a'; ch2 <= 'z'; ch2++) {
                        if (searchWoDots(newWord.replace('.', ch2)))
                            return true;
                    }
                }
            } else {
                for (var ch = 'a'; ch <= 'z'; ch++)
                    if (searchWoDots(word.replace('.', ch)))
                        return true;
            }
        }
        return false;
    }

    private boolean searchWoDots(String word) {
        var level = storage;
        for (var letter : word.toCharArray()) {
            if (level[letter - 'a'] == null)
                return false;
            level = (Object[])level[letter - 'a'];
        }
        return level[26] != null;
    }
}
