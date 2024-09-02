package com.codewars.kata_57ee99a16c8df7b02d00045f;

import java.util.Arrays;

/*
Challenge:

Given a two-dimensional array of integers, return the flattened version of the array with all the integers in the sorted (ascending) order.

Example:

Given [[3, 2, 1], [4, 6, 5], [], [9, 7, 8]], your function should return [1, 2, 3, 4, 5, 6, 7, 8, 9].
 */
public class Solution {

  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(flattenAndSort(new int[][]{{3, 2, 1}, {4, 6, 5}, {}, {9, 7, 8}})));
  }

  public static int[] flattenAndSort(int[][] array) {
    int len = 0;
    for (int[] ints : array) {
      len += ints.length;
    }
    int[] result = new int[len];
    int i = 0;
    for (int[] ints : array) {
      for (int anInt : ints) {
        result[i++] = anInt;
      }
    }
    Arrays.sort(result);
    return result;
    // return Arrays.stream(array).flatMapToInt(Arrays::stream).sorted().toArray();
  }
}
