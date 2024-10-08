package com.codewars.kata_576400f2f716ca816d001614;

import java.util.Arrays;

/*
Write a function which reduces fractions to their simplest form! Fractions will be presented as an array/tuple (depending on the language) of strictly positive integers, and the reduced fraction must be returned as an array/tuple:

input:   [numerator, denominator]
output:  [reduced numerator, reduced denominator]
example: [45, 120] --> [3, 8]

All numerators and denominators will be positive integers.

Note: This is an introductory Kata for a series... coming soon!
 */
public class Solution {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(myFraction(new int[] {45, 120})));
  }

  public static int[] myFraction(int[] fractions){
    int gcd1 = gcd(fractions[0], fractions[1]);
    int[] res = new int[2];
    res[0] = fractions[0]/gcd1;
    res[1] = fractions[1]/gcd1;
    //your code here
    return res;
  }

  private static int gcd(int a, int b) {
    if (a == b) {
      return a;
    }
    return a > b ? gcd(a - b, b) : gcd(a, b - a);
  }
}
