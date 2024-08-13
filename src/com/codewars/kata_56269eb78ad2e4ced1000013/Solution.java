package com.codewars.kata_56269eb78ad2e4ced1000013;

/*
You might know some pretty large perfect squares. But what about the NEXT one?

Complete the findNextSquare method that finds the next integral perfect square after the one passed as a parameter. Recall that an integral perfect square is an integer n such that sqrt(n) is also an integer.

If the argument is itself not a perfect square then return either -1 or an empty value like None or null, depending on your language. You may assume the argument is non-negative.

Examples:(Input --> Output)

121 --> 144
625 --> 676
114 --> -1 since 114 is not a perfect square
 */
public class Solution {

  public static void main(String[] args) {
    System.out.println(findNextSquare(121));
    System.out.println(findNextSquare(625));
    System.out.println(findNextSquare(114));
  }

  public static long findNextSquare(long sq) {
    if ((long) Math.pow((long) Math.sqrt(sq), 2) == sq) {
      return (long) Math.pow(Math.sqrt(sq) + 1, 2);
    }
    return -1;
  }
}
