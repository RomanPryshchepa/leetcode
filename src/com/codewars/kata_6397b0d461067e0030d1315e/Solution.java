package com.codewars.kata_6397b0d461067e0030d1315e;

/*
Write two functions, one that converts standard time to decimal time and one that converts decimal time to standard time.

    One hour has 100 minutes (or 10,000 seconds) in decimal time, yet its duration is the same as in standard time. Thus a decimal minute consists of 36 standard seconds, which is 1/100 of an hour.
    Working time is usually rounded to integer decimal minutes. Thus one standard minute equals 0.02 decimal hours, while two standard minutes equal 0.03 decimal hours and so on.
    The terms "normal" and "standard" time are considered synonymous in this kata, just like the terms "decimal" and "industrial" time.
    toIndustrial(time) should accept either the time in minutes as an integer or a string of the format "h:mm". Minutes will always consist of two digits in the tests (e.g., "0:05"); hours can have more. Return a double that represents decimal hours (e.g. 1.75 for 1h 45m). Round to a precision of two decimal digits - do not simply truncate!
    toNormal(time) should accept a double representing decimal time in hours. Return a string that represents standard time in the format "h:mm".
    There will be no seconds in the tests. We'll neglect them for the purpose of this kata.


Flavor text (click to expand)


Examples:
toIndustrial(1) => 0.02
toIndustrial("1:45") => 1.75
toNormal(0.33) => "0:20"
 */
public class Solution {

  public static void main(String[] args) {
    System.out.println(toIndustrial(1));
    System.out.println(toIndustrial("1:45"));
    System.out.println(toNormal(0.33));
  }

  public static double toIndustrial(String time) {
    String[] split = time.split(":");
    int hours = Integer.parseInt(split[0]);
    int minutes = Integer.parseInt(split[1]);
    return toIndustrial(minutes + 60 * hours);
  }

  public static double toIndustrial(int time) {
    return Math.round(100.0 * time / 60.0) / 100.0;
  }

  public static String toNormal(double time) {
    int industrialHours = (int) time;
    double industrialMinutes = (time - industrialHours) * 100.0;
    int minutes = (int) Math.round(industrialMinutes * 60.0 / 100.0);
    int hours = industrialHours;
    if (minutes == 60) {
      hours++;
      minutes = 0;
    }
    String strMinutes = String.valueOf(minutes);
    if (minutes < 10) {
      strMinutes = "0" + minutes;
    }
    return "%d:%s".formatted(hours, strMinutes);
  }
}
