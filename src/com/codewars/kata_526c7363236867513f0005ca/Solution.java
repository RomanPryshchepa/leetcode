package com.codewars.kata_526c7363236867513f0005ca;

/*
In this kata you should simply determine, whether a given year is a leap year or not. In case you don't know the rules, here they are:

    Years divisible by 4 are leap years,
    but years divisible by 100 are not leap years,
    but years divisible by 400 are leap years.

Tested years are in range 1600 ≤ year ≤ 4000.
 */
public class Solution {

  public static void main(String[] args) {
    System.out.println(isLeapYear(2020)); // true
    System.out.println(isLeapYear(2000)); // true
    System.out.println(isLeapYear(2015)); // false
    System.out.println(isLeapYear(2100)); // false
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
