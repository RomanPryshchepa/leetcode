package com.leetcode.lc401;

import java.util.ArrayList;
import java.util.List;

/*
401. Binary Watch

A binary watch has 4 LEDs on the top to represent the hours (0-11), and 6 LEDs on the bottom to represent the minutes (0-59). Each LED represents a zero or one, with the least significant bit on the right.

    For example, the below binary watch reads "4:51".

Given an integer turnedOn which represents the number of LEDs that are currently on (ignoring the PM), return all possible times the watch could represent. You may return the answer in any order.

The hour must not contain a leading zero.

    For example, "01:00" is not valid. It should be "1:00".

The minute must consist of two digits and may contain a leading zero.

    For example, "10:2" is not valid. It should be "10:02".



Example 1:

Input: turnedOn = 1
Output: ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]

Example 2:

Input: turnedOn = 9
Output: []



Constraints:

    0 <= turnedOn <= 10
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.readBinaryWatch(1));
    System.out.println(solution.readBinaryWatch2(1));
    System.out.println(solution.readBinaryWatch(9));
    System.out.println(solution.readBinaryWatch2(9));
    System.out.println(solution.readBinaryWatch(5));
    System.out.println(solution.readBinaryWatch2(5));
    System.out.println(solution.readBinaryWatch(0));
    System.out.println(solution.readBinaryWatch2(0));
  }

  public List<String> readBinaryWatch2(int turnedOn) {
    var list = new ArrayList<String>();
    for (int hour = 0; hour < 12; hour++) {
      for (int minute = 0; minute < 60; minute++) {
        if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {
          list.add(String.format("%d:%02d", hour, minute));
        }
      }
    }
    return list;
  }

  public List<String> readBinaryWatch(int turnedOn) {
    if (turnedOn == 0) {
      return List.of("0:00");
    }
    var result = new ArrayList<String>();
    var n = 10;
    var maxBit = (int) Math.pow(2, n);
    for (int i = 1; i < maxBit; i++) {
      String binaryString = Integer.toBinaryString(i);
      var bits = "0".repeat(n - binaryString.length()) + binaryString;
      if (bitsCount(bits) == turnedOn && getTime(bits) != null) {
        result.add(getTime(bits));
      }
    }
    return result;
  }

  private String getTime(String bits) {
    var charArray = bits.toCharArray();
    var hourCnt = 4;
    var hour = 0;
    var minuteCnt = 6;
    var minute = 0;
    for (int i = 0; i < hourCnt; i++) {
      if (charArray[i] == '1') {
        hour += (int) Math.pow(2, hourCnt - i - 1);
      }
    }
    if (hour > 11)
      return null;
    for (int i = hourCnt; i < hourCnt + minuteCnt; i++) {
      if (charArray[i] == '1') {
        minute += (int) Math.pow(2, hourCnt + minuteCnt - i - 1);
      }
    }
    if (minute > 59)
      return null;
    return String.format("%d:%02d", hour, minute);
  }

  private int bitsCount(String bits) {
    var cnt = 0;
    for (char c : bits.toCharArray()) {
      if (c == '1')
        cnt++;
    }
    return cnt;
  }
}
