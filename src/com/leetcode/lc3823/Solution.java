package com.leetcode.lc3823;

import java.util.HashSet;
import java.util.Set;

/*
3823. Reverse Letters Then Special Characters in a String

You are given a string s consisting of lowercase English letters and special characters.

Your task is to perform these in order:

    Reverse the lowercase letters and place them back into the positions originally occupied by letters.
    Reverse the special characters and place them back into the positions originally occupied by special characters.

Return the resulting string after performing the reversals.



Example 1:

Input: s = ")ebc#da@f("

Output: "(fad@cb#e)"

Explanation:

    The letters in the string are ['e', 'b', 'c', 'd', 'a', 'f']:
        Reversing them gives ['f', 'a', 'd', 'c', 'b', 'e']
        s becomes ")fad#cb@e("
    The special characters in the string are [')', '#', '@', '(']:
        Reversing them gives ['(', '@', '#', ')']
        s becomes "(fad@cb#e)"

Example 2:

Input: s = "z"

Output: "z"

Explanation:

The string contains only one letter, and reversing it does not change the string. There are no special characters.

Example 3:

Input: s = "!@#$%^&*()"

Output: ")(*&^%$#@!"

Explanation:

The string contains no letters. The string contains all special characters, so reversing the special characters reverses the whole string.



Constraints:

    1 <= s.length <= 100
    s consists only of lowercase English letters and the special characters in "!@#$%^&*()".
 */
public class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.reverseByType(")ebc#da@f("));
        System.out.println(solution.reverseByType("z"));
        System.out.println(solution.reverseByType("!@#$%^&*()"));
    }

    public String reverseByType(String s) {
        var spec = new HashSet<Character>(){{
            add('!');
            add('@');
            add('#');
            add('$');
            add('%');
            add('^');
            add('&');
            add('*');
            add('(');
            add(')');
        }};
        var arr = s.toCharArray();
        reverse(arr, spec, true);
        reverse(arr, spec, false);
        return new String(arr);
    }

    private void reverse(char[] arr, Set<Character> spec, boolean isSpec) {
        var lp = 0;
        var rp = arr.length - 1;
        char tmp;
        if (isSpec) {
            while (lp < rp) {
                if (spec.contains(arr[lp]) && spec.contains(arr[rp])) {
                    tmp = arr[lp];
                    arr[lp] = arr[rp];
                    arr[rp] = tmp;
                    lp++;
                    rp--;
                } else {
                    if (!spec.contains(arr[lp]))
                        lp++;
                    if (!spec.contains(arr[rp]))
                        rp--;
                }
            }
        } else {
            while (lp < rp) {
                if (!spec.contains(arr[lp]) && !spec.contains(arr[rp])) {
                    tmp = arr[lp];
                    arr[lp] = arr[rp];
                    arr[rp] = tmp;
                    lp++;
                    rp--;
                } else {
                    if (spec.contains(arr[lp]))
                        lp++;
                    if (spec.contains(arr[rp]))
                        rp--;
                }
            }
        }
    }
}
