package com.leetcode.lc424;

import java.util.HashMap;

/*
424. Longest Repeating Character Replacement

You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.



Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.

Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.



Constraints:

    1 <= s.length <= 105
    s consists of only uppercase English letters.
    0 <= k <= s.length
 */
public class Solution {

  public static void main(String[] args) {
    var solution = new Solution();
    System.out.println(solution.characterReplacement("ABAB", 2)); //4
    System.out.println(solution.characterReplacement2("ABAB", 2)); //4
    System.out.println(solution.characterReplacement3("ABAB", 2)); //4
    System.out.println(solution.characterReplacement4("ABAB", 2)); //4
    System.out.println();
    System.out.println(solution.characterReplacement("AABABBA", 1)); //4
    System.out.println(solution.characterReplacement2("AABABBA", 1)); //4
    System.out.println(solution.characterReplacement3("AABABBA", 1)); //4
    System.out.println(solution.characterReplacement4("AABABBA", 1)); //4
    System.out.println();
    System.out.println(solution.characterReplacement("ABAA", 0)); //3
    System.out.println(solution.characterReplacement2("ABAA", 0)); //3
    System.out.println(solution.characterReplacement3("ABAA", 0)); //3
    System.out.println(solution.characterReplacement4("ABAA", 0)); //3
    System.out.println();
    System.out.println(solution.characterReplacement("AAAA", 2)); //4
    System.out.println(solution.characterReplacement2("AAAA", 2)); //4
    System.out.println(solution.characterReplacement3("AAAA", 2)); //4
    System.out.println(solution.characterReplacement4("AAAA", 2)); //4
    System.out.println();
    System.out.println(solution.characterReplacement("KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF", 4)); //7
    System.out.println(solution.characterReplacement2("KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF", 4)); //7
    System.out.println(solution.characterReplacement3("KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF", 4)); //7
    System.out.println(solution.characterReplacement4("KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF", 4)); //7
  }

  public int characterReplacement(String s, int k) {
    int leftInd = 0;
    var letterDict = new HashMap<Character, Integer>();
    int res = 0;
    for (int rightInd = 0; rightInd < s.length(); rightInd++) {
      if (letterDict.containsKey(s.charAt(rightInd))) {
        letterDict.put(s.charAt(rightInd), letterDict.get(s.charAt(rightInd)) + 1);
      } else {
        letterDict.put(s.charAt(rightInd), 1);
      }

      while (letterDict.values().stream().reduce(0, Integer::sum) - letterDict.values().stream()
          .max(Integer::compareTo).get() > k) {
        if (letterDict.containsKey(s.charAt(leftInd))) {
          letterDict.put(s.charAt(leftInd), letterDict.get(s.charAt(leftInd)) - 1);
          if (letterDict.get(s.charAt(leftInd)) == 0) {
            letterDict.remove(s.charAt(leftInd));
          }
        }
        leftInd++;
      }
      var valSum = letterDict.values().stream().reduce(0, Integer::sum);
      res = valSum > res ? valSum : res;
    }
    return res;
  }

  public int characterReplacement2(String s, int k) {
    var letters = new int[26];
    var result = 1;
    var left = 0;
    var right = 0;
    var count = 0;
    while (right < s.length()) {
      while (right < s.length() && (count - getMaxLetterCount(letters)) <= k) {
        letters[s.charAt(right++) - 'A']++;
        count++;
      }
      if ((count - getMaxLetterCount(letters)) <= k)
        result = Math.max(result, count);
      else
        result = Math.max(result, count - 1);
      while (left <= right && (count - getMaxLetterCount(letters)) > k) {
        letters[s.charAt(left++) - 'A']--;
        count--;
      }
    }
    return result;
  }

  private int getMaxLetterCount(int[] letters) {
    var max = letters[0];
    for (var elem : letters)
      if (elem > max)
        max = elem;
    return max;
  }

  public int characterReplacement3(String s, int k) {
    var letterStorage = new int[26];
    var max = 0;
    var left = 0;
    var right = 0;
    var result = 0;
    var letterIdx = 0;
    for (; right < s.length(); right++) {
      letterIdx = s.charAt(right) - 'A';
      letterStorage[letterIdx]++;
      if (letterStorage[letterIdx] > max)
        max = letterStorage[letterIdx];
      if (right - left + 1 - max <= k)
        result = Math.max(result, right - left + 1);
      while (left < right && right - left + 1 - max > k)
        letterStorage[s.charAt(left++) - 'A']--;
    }
    return result;
  }

  public int characterReplacement4(String s, int k) {
    var letterCnt = new int[26];
    var lp = -1;
    var result = 0;
    for (var rp = 0; rp < s.length(); rp++) {
      letterCnt[s.charAt(rp) - 'A']++;
      while (isMoreThanK(letterCnt, k)) {
        lp++;
        letterCnt[s.charAt(lp) - 'A']--;
      }
      result = Math.max(result, rp - lp);
    }
    return result;
  }

  private boolean isMoreThanK(int[] letterCnt, int k) {
    var max = 0;
    var sum = 0;
    for (var cnt : letterCnt) {
      if (cnt > max)
        max = cnt;
      sum += cnt;
    }
    return sum - max > k;
  }
}
