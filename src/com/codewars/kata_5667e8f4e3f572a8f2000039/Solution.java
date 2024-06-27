package com.codewars.kata_5667e8f4e3f572a8f2000039;

/*
This time no story, no theory. The examples below show you how to write function accum:
Examples:

accum("abcd") -> "A-Bb-Ccc-Dddd"
accum("RqaEzty") -> "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"
accum("cwAt") -> "C-Ww-Aaa-Tttt"

The parameter of accum is a string which includes only letters from a..z and A..Z.
 */
public class Solution {

  public static void main(String[] args) {
    System.out.println(accum("abcd"));
    System.out.println(accum("RqaEzty"));
    System.out.println(accum("cwAt"));
  }

  public static String accum(String s) {
    String div = "";
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      result.append(div);
      div = "-";
      char ch = Character.toLowerCase(s.charAt(i));
      result.append(Character.toUpperCase(ch));
      for (int j = 1; j <= i; j++) {
        result.append(ch);
      }
    }
    return result.toString();
  }
}
