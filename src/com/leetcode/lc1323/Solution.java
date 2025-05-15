package com.leetcode.lc1323;

/*
1323. Maximum 69 Number

You are given a positive integer num consisting only of digits 6 and 9.

Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).



Example 1:

Input: num = 9669
Output: 9969
Explanation:
Changing the first digit results in 6669.
Changing the second digit results in 9969.
Changing the third digit results in 9699.
Changing the fourth digit results in 9666.
The maximum number is 9969.

Example 2:

Input: num = 9996
Output: 9999
Explanation: Changing the last digit 6 to 9 results in the maximum number.

Example 3:

Input: num = 9999
Output: 9999
Explanation: It is better not to apply any change.



Constraints:

    1 <= num <= 104
    num consists of only 6 and 9 digits.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.maximum69Number(9669));
    System.out.println(solution.maximum69Number(9996));
    System.out.println(solution.maximum69Number(9999));
    System.out.println(solution.maximum69Number(9));
    System.out.println(solution.maximum69Number(6));
  }

  public int maximum69Number(int num) {
    if (!String.valueOf(num).contains("6")) {
      return num;
    }
    var len = String.valueOf(num).length();
    while (len > 0) {
      if (num / (int) Math.pow(10, len - 1) % 10 == 6) {
        return num + 3 * (int) Math.pow(10, len - 1);
      }
      len--;
    }
    return num;
  }

}
