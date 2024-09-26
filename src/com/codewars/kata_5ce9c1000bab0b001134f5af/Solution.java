package com.codewars.kata_5ce9c1000bab0b001134f5af;

/*
Given a month as an integer from 1 to 12, return to which quarter of the year it belongs as an integer number.

For example: month 2 (February), is part of the first quarter; month 6 (June), is part of the second quarter; and month 11 (November), is part of the fourth quarter.

Constraint:

    1 <= month <= 12
 */
public class Solution {

  public static void main(String[] args) {
    System.out.println(quarterOf(2));
    System.out.println(quarterOf(5));
    System.out.println(quarterOf(8));
    System.out.println(quarterOf(11));
  }

  public static int quarterOf(int month) {
    return (month - 1) / 3 + 1;
  }
}
