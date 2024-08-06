package com.codewars.kata_554b4ac871d6813a03000035;

/*
In this little assignment you are given a string of space separated numbers, and have to return the highest and lowest number.
Examples

highAndLow("1 2 3 4 5")  // return "5 1"
highAndLow("1 2 -3 4 5") // return "5 -3"
highAndLow("1 9 3 4 -5") // return "9 -5"

Notes

    All numbers are valid Int32, no need to validate them.
    There will always be at least one number in the input string.
    Output string must be two numbers separated by a single space, and highest number is first.
 */
public class Solution {

  public static void main(String[] args) {
    System.out.println(highAndLow("8 3 -5 42 -1 0 0 -9 4 7 4 -4")); // return "42 -9"
    System.out.println(highAndLow("1 2 3")); // return "3 1"
    System.out.println(highAndLow("3")); // return "3 3"
    System.out.println(highAndLow("1 2 3 4 5")); // return "5 1"
    System.out.println(highAndLow("1 2 -3 4 5")); // return "5 -3"
    System.out.println(highAndLow("1 9 3 4 -5")); // return "9 -5"

  }

  public static String highAndLow(String numbers) {
    String[] s = numbers.split(" ");
    int max = Integer.parseInt(s[0]);
    int min = Integer.parseInt(s[0]);
    for (String string : s) {
      if (Integer.parseInt(string) > max) {
        max = Integer.parseInt(string);
      }
      if (Integer.parseInt(string) < min) {
        min = Integer.parseInt(string);
      }
    }
    return "%d %d".formatted(max, min);
  }
}
