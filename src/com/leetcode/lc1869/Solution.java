package com.leetcode.lc1869;

/*
1869. Longer Contiguous Segments of Ones than Zeros

Given a binary string s, return true if the longest contiguous segment of 1's is strictly longer than the longest contiguous segment of 0's in s, or return false otherwise.

    For example, in s = "110100010" the longest continuous segment of 1s has length 2, and the longest continuous segment of 0s has length 3.

Note that if there are no 0's, then the longest continuous segment of 0's is considered to have a length 0. The same applies if there is no 1's.



Example 1:

Input: s = "1101"
Output: true
Explanation:
The longest contiguous segment of 1s has length 2: "1101"
The longest contiguous segment of 0s has length 1: "1101"
The segment of 1s is longer, so return true.

Example 2:

Input: s = "111000"
Output: false
Explanation:
The longest contiguous segment of 1s has length 3: "111000"
The longest contiguous segment of 0s has length 3: "111000"
The segment of 1s is not longer, so return false.

Example 3:

Input: s = "110100010"
Output: false
Explanation:
The longest contiguous segment of 1s has length 2: "110100010"
The longest contiguous segment of 0s has length 3: "110100010"
The segment of 1s is not longer, so return false.



Constraints:

    1 <= s.length <= 100
    s[i] is either '0' or '1'.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.checkZeroOnes("1101"));
    System.out.println(solution.checkZeroOnes("111000"));
    System.out.println(solution.checkZeroOnes("110100010"));
  }

  public boolean checkZeroOnes(String s) {
    if (s.equals("1")) {
      return true;
    }
    var len0 = 0;
    var len1 = 0;
    var maxLen0 = 0;
    var maxLen1 = 0;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == '0' && s.charAt(i - 1) == '0') {
        len0++;
      } else if (s.charAt(i) == '1' && s.charAt(i - 1) == '1') {
        len1++;
      } else {
        maxLen0 = Math.max(maxLen0, len0);
        len0 = 0;
        maxLen1 = Math.max(maxLen1, len1);
        len1 = 0;
      }
    }
    maxLen0 = Math.max(maxLen0, len0);
    maxLen1 = Math.max(maxLen1, len1);
    return maxLen1 > maxLen0;
  }
}
