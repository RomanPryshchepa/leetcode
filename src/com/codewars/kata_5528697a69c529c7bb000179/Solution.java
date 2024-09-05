package com.codewars.kata_5528697a69c529c7bb000179;

/*
In this kata you should simply determine, whether a given year is a leap year or not. In case you don't know the rules, here they are:

    Years divisible by 4 are leap years,
    but years divisible by 100 are not leap years,
    but years divisible by 400 are leap years.

Tested years are in range 1600 ≤ year ≤ 4000.
 */
public class Solution {

  public static void main(String[] args) {
    System.out.println(isLeapYear(2020));
    System.out.println(isLeapYear(2000));
    System.out.println(isLeapYear(2015));
    System.out.println(isLeapYear(2100));
  }

  public static boolean isLeapYear(int year) {
    if (year % 4 == 0 && year % 100 != 0) {
      return true;
    }
    if (year % 100 == 0 && year % 400 != 0) {
      return false;
    }
    if (year % 400 == 0) {
      return true;
    }
    return false;
  }
}
