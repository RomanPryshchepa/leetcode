package com.leetcode.lc423;

import java.util.HashMap;
import java.util.Map;

/*
423. Reconstruct Original Digits from English
Medium
Topics
Companies

Given a string s containing an out-of-order English representation of digits 0-9, return the digits in ascending order.



Example 1:

Input: s = "owoztneoer"
Output: "012"

Example 2:

Input: s = "fviefuro"
Output: "45"



Constraints:

    1 <= s.length <= 105
    s[i] is one of the characters ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"].
    s is guaranteed to be valid.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    String s;

    s = "owoztneoer";
    System.out.println(solution.originalDigits(s)); // 012

    s = "fviefuro";
    System.out.println(solution.originalDigits(s)); // 45

    s = "fviefuroowoztneoerthreesixseveneightnine";
    System.out.println(solution.originalDigits(s)); // 0123456789
  }

  public String originalDigits(String s) {
    int[] digits = new int[10];
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'z') { // zero
        digits[0]++;
      }
      if (s.charAt(i) == 'w') { // two
        digits[2]++;
      }
      if (s.charAt(i) == 'u') { // four
        digits[4]++;
      }
      if (s.charAt(i) == 'x') { // six
        digits[6]++;
      }
      if (s.charAt(i) == 'g') { // eight
        digits[8]++;
      }
      if (s.charAt(i) == 'r') { // three and zero and four
        digits[3]++;
      }
      if (s.charAt(i) == 'f') { // five and four
        digits[5]++;
      }
      if (s.charAt(i) == 'v') { // seven and five
        digits[7]++;
      }
      if (s.charAt(i) == 'o') { // one and zero and two and four
        digits[1]++;
      }
      if (s.charAt(i) == 'i') { // nine and five and six and eight
        digits[9]++;
      }
    }

    digits[5] = digits[5] - digits[4];
    digits[7] = digits[7] - digits[5];
    digits[3] = digits[3] - digits[4] - digits[0];
    digits[1] = digits[1] - digits[0] - digits[2] - digits[4];
    digits[9] = digits[9] - digits[5] - digits[6] - digits[8];

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < digits.length; i++) {
      while (digits[i] > 0) {
        sb.append(i);
        digits[i]--;
      }
    }

    return sb.toString();
  }

  public String originalDigitsV1(String s) {
    char[] charArray = s.toCharArray();
    char[] result = new char[10];
    Map<Character, Integer> digitMap = new HashMap<>();
    for (char value : charArray) {
      digitMap.put(value, digitMap.getOrDefault(value, 0) + 1);
    }
    while (digitMap.getOrDefault('z', 0) > 0) { // zero
      for (char c : "zero".toCharArray()) {
        digitMap.put(c, digitMap.getOrDefault(c, 0) - 1);
      }
      result[0]++;
    }
    while (digitMap.getOrDefault('w', 0) > 0) { // two
      for (char c : "two".toCharArray()) {
        digitMap.put(c, digitMap.getOrDefault(c, 0) - 1);
      }
      result[2]++;
    }
    while (digitMap.getOrDefault('u', 0) > 0) { // four
      for (char c : "four".toCharArray()) {
        digitMap.put(c, digitMap.getOrDefault(c, 0) - 1);
      }
      result[4]++;
    }
    while (digitMap.getOrDefault('x', 0) > 0) { // six
      for (char c : "six".toCharArray()) {
        digitMap.put(c, digitMap.getOrDefault(c, 0) - 1);
      }
      result[6]++;
    }
    while (digitMap.getOrDefault('g', 0) > 0) { // eight
      for (char c : "eight".toCharArray()) {
        digitMap.put(c, digitMap.getOrDefault(c, 0) - 1);
      }
      result[8]++;
    }

    while (digitMap.getOrDefault('o', 0) > 0) { // one
      for (char c : "one".toCharArray()) {
        digitMap.put(c, digitMap.getOrDefault(c, 0) - 1);
      }
      result[1]++;
    }
    while (digitMap.getOrDefault('r', 0) > 0) { // three
      for (char c : "three".toCharArray()) {
        digitMap.put(c, digitMap.getOrDefault(c, 0) - 1);
      }
      result[3]++;
    }
    while (digitMap.getOrDefault('f', 0) > 0) { // five
      for (char c : "five".toCharArray()) {
        digitMap.put(c, digitMap.getOrDefault(c, 0) - 1);
      }
      result[5]++;
    }
    while (digitMap.getOrDefault('v', 0) > 0) { // seven
      for (char c : "seven".toCharArray()) {
        digitMap.put(c, digitMap.getOrDefault(c, 0) - 1);
      }
      result[7]++;
    }
    while (digitMap.getOrDefault('i', 0) > 0) { // nine
      for (char c : "nine".toCharArray()) {
        digitMap.put(c, digitMap.getOrDefault(c, 0) - 1);
      }
      result[9]++;
    }
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < result.length; i++) {
      while (result[i] > 0) {
        res.append(i);
        result[i]--;
      }
    }

    return res.toString();
  }
}
