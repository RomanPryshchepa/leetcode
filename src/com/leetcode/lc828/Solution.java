package com.leetcode.lc828;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
828. Count Unique Characters of All Substrings of a Given String

Let's define a function countUniqueChars(s) that returns the number of unique characters in s.

    For example, calling countUniqueChars(s) if s = "LEETCODE" then "L", "T", "C", "O", "D" are the unique characters since they appear only once in s, therefore countUniqueChars(s) = 5.

Given a string s, return the sum of countUniqueChars(t) where t is a substring of s. The test cases are generated such that the answer fits in a 32-bit integer.

Notice that some substrings can be repeated so in this case you have to count the repeated ones too.



Example 1:

Input: s = "ABC"
Output: 10
Explanation: All possible substrings are: "A","B","C","AB","BC" and "ABC".
Every substring is composed with only unique letters.
Sum of lengths of all substring is 1 + 1 + 1 + 2 + 2 + 3 = 10

Example 2:

Input: s = "ABA"
Output: 8
Explanation: The same as example 1, except countUniqueChars("ABA") = 1.

Example 3:

Input: s = "LEETCODE"
Output: 92



Constraints:

    1 <= s.length <= 105
    s consists of uppercase English letters only.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.uniqueLetterString("ABC"));
    System.out.println(solution.uniqueLetterString("ABA"));
    System.out.println(solution.uniqueLetterString("LEETCODE"));
    var s =
        "DELQGVWNZKIJJPSXOVWWIZUXCEGWSQLESNSRBMKZARFPAXSVWQEZDENDAHNNIBHGHTFDLPGDLFXMIYRFNLMXHNPIFUAXINXPXLCTTJNLGGMKJIOEWBECNOFQPVCIKIAZMNGHEHFMCPWSMJTMGVSXTOGCGUYKFMNCGLCBRAFJLJVPIVDOLJBURULPGXBVDCEWXXXLTRMSHPKSPFDGNVOCZWDXJUWVNAREDOKTZMIUDKDQWWWSAEUUDBHMWZELOSBIHMAYJEMGZPMDOOGSCKLVHTGMETHUISCLJKDOQEWGVBULEMUXGTRKGXYFDIZTZWMLOFTCANBGUARNWQEQWGMIKMORVQUZANJNRNPMJWYLVHWKDFLDDBBMILAKGFROEQAMEVONUVHOHGPKLBPNYZFPLXNBCIFENCGIMIDCXIIQJWPVVCOCJTSKSHVMQJNLHSQTEZQTTMOXUSKBMUJEJDBJQNXECJGSZUDENJCPTTSREKHPRIISXMWBUGMTOVOTRKQCFSDOTEFPSVQINYLHXYVZTVAMWGPNKIDLOPGAMWSKDXEPLPPTKUHEKBQAWEBMORRZHBLOGIYLTPMUVBPGOOOIEBJEGTKQKOUURHSEJCMWMGHXYIAOGKJXFAMRLGTPNSLERNOHSDFSSFASUJTFHBDMGBQOKZRBRAZEQQVWFRNUNHBGKRFNBETEDJIWCTUBJDPFRRVNZENGRANELPHSDJLKVHWXAXUTMPWHUQPLTLYQAATEFXHZARFAUDLIUDEHEGGNIYICVARQNRJJKQSLXKZZTFPVJMOXADCIGKUXCVMLPFJGVXMMBEKQXFNXNUWOHCSZSEZWZHDCXPGLROYPMUOBDFLQMTTERGSSGVGOURDWDSEXONCKWHDUOVDHDESNINELLCTURJHGCJWVIPNSISHRWTFSFNRAHJAJNNXKKEMESDWGIYIQQRLUUADAXOUEYURQRVZBCSHXXFLYWFHDZKPHAGYOCTYGZNPALAUZSTOU";
    System.out.println(solution.uniqueLetterString(s)); // 629134
  }

  public int uniqueLetterString(String s) {
    var dict = new HashMap<Character, List<Integer>>();
    for (var i = 0; i < s.length(); i++) {
      if (!dict.containsKey(s.charAt(i))) {
        dict.put(s.charAt(i), new ArrayList<>());
        dict.get(s.charAt(i)).add(-1);
      }
      dict.get(s.charAt(i)).add(i);
    }
    var res = 0;
    for (var key : dict.keySet())
    {
      dict.get(key).add(s.length());
      for (var i = 1; i < dict.get(key).size() - 1; i++) {
        res += (dict.get(key).get(i) - dict.get(key).get(i - 1)) * (dict.get(key).get(i + 1) - dict.get(key).get(i));
      }
    }
    return res;
  }
}
