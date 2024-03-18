package com.leetcode.lc2264;

/*
You are given a string num representing a large integer. An integer is good if it meets the following conditions:
    It is a substring of num with length 3.
    It consists of only one unique digit.
Return the maximum good integer as a string or an empty string "" if no such integer exists.
Note:
    A substring is a contiguous sequence of characters within a string.
    There may be leading zeroes in num or a good integer.
Example 1:
Input: num = "6777133339"
Output: "777"
Explanation: There are two distinct good integers: "777" and "333".
"777" is the largest, so we return "777".
Example 2:
Input: num = "2300019"
Output: "000"
Explanation: "000" is the only good integer.
Example 3:
Input: num = "42352338"
Output: ""
Explanation: No substring of length 3 consists of only one unique digit. Therefore, there are no good integers.
Constraints:
    3 <= num.length <= 1000
    num only consists of digits.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    String num;

    num = "6777133339";
    System.out.println(solution.largestGoodInteger(num)); // "777"

    num = "2300019";
    System.out.println(solution.largestGoodInteger(num)); // "000"

    num = "42352338";
    System.out.println(solution.largestGoodInteger(num)); // ""
  }

  public String largestGoodInteger(String num) {
    char[] charArray = num.toCharArray();
    int res = -1;
    int cur;
    for (int i = 0; i < charArray.length - 2; i++) {
      if (charArray[i] == charArray[i + 1] && charArray[i + 1] == charArray[i + 2]) {
        if (charArray[i] == '9') {
          return "999";
        }
        cur = Integer.parseInt("" + charArray[i] + charArray[i + 1] + charArray[i + 2]);
        if (cur > res) {
          res = cur;
        }
      }
    }
    if (res == -1) {
      return "";
    } else {
      return res == 0 ? "000" : String.valueOf(res);
    }
  }

}
