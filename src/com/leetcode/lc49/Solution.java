package com.leetcode.lc49;

import java.util.*;

/*
49. Group Anagrams

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:

Input: strs = [""]
Output: [[""]]

Example 3:

Input: strs = ["a"]
Output: [["a"]]



Constraints:

    1 <= strs.length <= 104
    0 <= strs[i].length <= 100
    strs[i] consists of lowercase English letters.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
        System.out.println(solution.groupAnagrams2(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
        System.out.println(solution.groupAnagrams(new String[] { "" }));
        System.out.println(solution.groupAnagrams2(new String[] { "" }));
        System.out.println(solution.groupAnagrams(new String[] { "a" }));
        System.out.println(solution.groupAnagrams2(new String[] { "a" }));
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        var map = new HashMap<String, List<String>>();
        var inMap = false;
        for (String str : strs) {
            inMap = false;
            for (var key : map.keySet())
                if (str.length() == key.length() && isAnagram(str, key)) {
                    map.get(key).add(str);
                    inMap = true;
                }
            if (!inMap)
                map.put(str, new ArrayList<>() {{
                    add(str);
                }});
        }
        var res = new ArrayList<List<String>>();
        for (var key : map.keySet())
            res.add(map.get(key));
        return res;
    }

    private boolean isAnagram(String str1, String str2) {
        var letters = new int[26];
        for (char c : str1.toCharArray())
            letters[c - 'a']++;
        for (char c : str2.toCharArray())
            letters[c - 'a']--;
        for (var i : letters)
            if (i != 0)
                return false;
        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);
            List<String> value = res.getOrDefault(key, new ArrayList<>());
            value.add(str);
            res.put(key, value);
        }
        return new ArrayList<>(res.values());
    }
}
