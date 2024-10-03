package com.codewars.kata_559cc2d2b802a5c94700000c;

/*
Write a function that takes an array of unique integers and returns the minimum number of integers needed to make the values of the array consecutive from the lowest number to the highest number.
Example

[4, 8, 6] --> 2
Because 5 and 7 need to be added to have [4, 5, 6, 7, 8]

[-1, -5] --> 3
Because -2, -3, -4 need to be added to have [-5, -4, -3, -2, -1]

[1] --> 0
[]  --> 0
 */
public class Solution {

  public static void main(String[] args) {
    System.out.println(consecutive(new int[]{4, 8, 6}));
    System.out.println(consecutive(new int[]{-1, -5}));
    System.out.println(consecutive(new int[]{1}));
    System.out.println(consecutive(new int[]{}));
  }

  public static int consecutive(final int[] arr) {
    if (arr.length == 0) {
      return 0;
    }
    int min = arr[0];
    int max = arr[0];
    for (int j : arr) {
      if (j > max) {
        max = j;
      }
      if (j < min) {
        min = j;
      }
    }
    return max - min + 1 - arr.length; // your code here
  }

}
