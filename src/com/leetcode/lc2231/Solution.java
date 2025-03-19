package com.leetcode.lc2231;

import java.util.ArrayList;

/*
2231. Largest Number After Digit Swaps by Parity

You are given a positive integer num. You may swap any two digits of num that have the same parity (i.e. both odd digits or both even digits).

Return the largest possible value of num after any number of swaps.



Example 1:

Input: num = 1234
Output: 3412
Explanation: Swap the digit 3 with the digit 1, this results in the number 3214.
Swap the digit 2 with the digit 4, this results in the number 3412.
Note that there may be other sequences of swaps but it can be shown that 3412 is the largest possible number.
Also note that we may not swap the digit 4 with the digit 1 since they are of different parities.

Example 2:

Input: num = 65875
Output: 87655
Explanation: Swap the digit 8 with the digit 6, this results in the number 85675.
Swap the first digit 5 with the digit 7, this results in the number 87655.
Note that there may be other sequences of swaps but it can be shown that 87655 is the largest possible number.



Constraints:

    1 <= num <= 109
 */
public class Solution {

  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.largestInteger(1234));
    System.out.println(sol.largestInteger(65875));
    System.out.println(sol.largestInteger(247));
  }

  public int largestInteger(int num) {
    var odd = new ArrayList<Integer>();
    var even = new ArrayList<Integer>();
    var numLst = new ArrayList<Integer>();
    while (num > 0) {
      var n = num % 10;
      num /= 10;
      numLst.add(0, n);
      if (n % 2 == 0) {
        even.add(n);
      } else {
        odd.add(n);
      }
    }
    odd.sort((a,b) -> b - a);
    even.sort((a,b) -> b - a);
    var result = 0;
    var mult = (int) Math.pow(10, numLst.size() - 1);
    var o = 0;
    var e = 0;
    for (Integer integer : numLst) {
      if (integer % 2 == 0) {
        result += even.get(e++) * mult;
      } else {
        result += odd.get(o++) * mult;
      }
      mult /= 10;
    }
    return result;
  }
}
