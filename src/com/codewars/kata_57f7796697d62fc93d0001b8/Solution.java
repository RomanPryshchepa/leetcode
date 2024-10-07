package com.codewars.kata_57f7796697d62fc93d0001b8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of integers (x), and a target (t), you must find out if any two consecutive numbers in the array sum to t. If so, remove the second number.

Example:

x = [1, 2, 3, 4, 5]
t = 3

1+2 = t, so remove 2. No other pairs = t, so rest of array remains:

[1, 3, 4, 5]

Work through the array from left to right.

Return the resulting array.
 */
public class Solution {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(trouble(new int[] {1, 2, 3, 4, 5}, 3)));
  }

  public static int[] trouble(int[] x, int t) {
    //Put your lovely code here ฅ(≈>ܫ<≈)♥
    List<Integer> listX = new ArrayList<>();
    for (int j : x) {
      listX.add(j);
    }
    int prev = x[0];
    int k = 1;
    for (int i = 1; i < x.length; i++) {
      if (prev + x[i] != t) {
        prev = x[i];
        k++;
      } else {
        listX.remove(k);
      }
    }
    int[] res = new int[listX.size()];

    for (int i = 0; i < listX.size(); i++) {
      res[i] = listX.get(i);
    }
    return res;
  }

}
