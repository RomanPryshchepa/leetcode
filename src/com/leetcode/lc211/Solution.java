package com.leetcode.lc211;

/*
211. Design Add and Search Words Data Structure

Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

    WordDictionary() Initializes the object.
    void addWord(word) Adds word to the data structure, it can be matched later.
    bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.



Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True



Constraints:

    1 <= word.length <= 25
    word in addWord consists of lowercase English letters.
    word in search consist of '.' or lowercase English letters.
    There will be at most 2 dots in word for search queries.
    At most 104 calls will be made to addWord and search.
 */
public class Solution {
    public static void main(String[] args) {
        var wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad") == false); // return false
        System.out.println(wordDictionary.search("bad") == true); // return true
        System.out.println(wordDictionary.search(".ad") == true); // return true
        System.out.println(wordDictionary.search("b..") == true); // return true
        System.out.println();

        wordDictionary = new WordDictionary();
        wordDictionary.addWord("a");
        wordDictionary.addWord("b");
        wordDictionary.addWord("c");
        wordDictionary.addWord("cat");
        System.out.println(wordDictionary.search("a") == true); // return true
        System.out.println(wordDictionary.search(".") == true); // return true
        System.out.println(wordDictionary.search("d") == false); // return false
        System.out.println(wordDictionary.search("..") == false); // return false
        System.out.println(wordDictionary.search("a..") == false); // return false
        System.out.println(wordDictionary.search("a.t") == false); // return false
        System.out.println(wordDictionary.search("ca..") == false); // return false
        System.out.println(wordDictionary.search("ca.") == true); // return true
        System.out.println(wordDictionary.search("c.t") == true); // return true
        System.out.println(wordDictionary.search(".a.") == true); // return true
        System.out.println(wordDictionary.search("..t") == true); // return true
        System.out.println();

        wordDictionary = new WordDictionary();
        wordDictionary.addWord("aaaa");
        wordDictionary.addWord("aaab");
        wordDictionary.addWord("aaba");
        wordDictionary.addWord("abaa");
        wordDictionary.addWord("baaa");
        System.out.println(wordDictionary.search(".aa.") == true); // return true
        System.out.println(wordDictionary.search("aaa.") == true); // return true
        System.out.println(wordDictionary.search(".aaa") == true); // return true
        System.out.println(wordDictionary.search("a..a") == true); // return true
        System.out.println(wordDictionary.search("ba..") == true); // return true
        System.out.println(wordDictionary.search("..aa") == true); // return true
        System.out.println(wordDictionary.search("..ab") == true); // return true
        System.out.println(wordDictionary.search("..ba") == true); // return true
        System.out.println();

        wordDictionary = new WordDictionary();
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        System.out.println(wordDictionary.search("a") == false); // return false
        System.out.println(wordDictionary.search(".at") == false); // return false
        wordDictionary.addWord("bat");
        System.out.println(wordDictionary.search(".at") == true); // return true
        System.out.println(wordDictionary.search("an.") == true); // return true
        System.out.println(wordDictionary.search("a.d.") == false); // return false
        System.out.println(wordDictionary.search("b.") == false); // return false
        System.out.println(wordDictionary.search("a.d") == true); // return true
        System.out.println(wordDictionary.search(".") == false); // return false
    }
}
