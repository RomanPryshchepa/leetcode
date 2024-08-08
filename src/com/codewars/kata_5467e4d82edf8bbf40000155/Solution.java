package com.codewars.kata_5467e4d82edf8bbf40000155;

import java.util.Arrays;

/*
Your task is to make a function that can take any non-negative integer as an argument and return it with its digits in descending order. Essentially, rearrange the digits to create the highest possible number.
Examples:

Input: 42145 Output: 54421

Input: 145263 Output: 654321

Input: 123456789 Output: 987654321
 */
public class Solution {

  public static void main(String[] args) {
    System.out.println(sortDesc(42145)); // 54421
    System.out.println(sortDesc(145263)); // 654321
    System.out.println(sortDesc(123456789)); // 987654321
  }

  public static int sortDesc(final int num) {
    int n = num;
    int[] arr = new int[("" + n).length()];
    int i = 0;
    while (n > 0) {
      arr[i++] = n % 10;
      n = n / 10;
    }
    Arrays.sort(arr);
    int result = 0;
    int mult = 1;
    for (int j = 0; j < arr.length; j++) {
      result += arr[j] * mult;
      mult *= 10;
    }
    return result;
  }

}
