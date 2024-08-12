package com.codewars.kata_5656b6906de340bd1b0000ac;

import java.util.Set;
import java.util.TreeSet;

/*
Take 2 strings s1 and s2 including only letters from a to z. Return a new sorted string, the longest possible, containing distinct letters - each taken only once - coming from s1 or s2.
Examples:

a = "xyaabbbccccdefww"
b = "xxxxyyyyabklmopq"
longest(a, b) -> "abcdefklmopqwxy"

a = "abcdefghijklmnopqrstuvwxyz"
longest(a, a) -> "abcdefghijklmnopqrstuvwxyz"

 */
public class Solution {

  public static void main(String[] args) {
    String a;
    String b;

    a = "xyaabbbccccdefww";
    b = "xxxxyyyyabklmopq";
    System.out.println(longest(a, b));

    a = "abcdefghijklmnopqrstuvwxyz";
    System.out.println(longest(a, a));
  }

  public static String longest (String s1, String s2) {
    Set<Character> resultSet = new TreeSet<>();
    for (int i = 0; i < s1.length(); i++) {
      resultSet.add(s1.charAt(i));
    }
    for (int i = 0; i < s2.length(); i++) {
      resultSet.add(s2.charAt(i));
    }
    StringBuilder result = new StringBuilder();
    for (Character c : resultSet) {
      result.append(c);
    }
    return result.toString();
  }
}
