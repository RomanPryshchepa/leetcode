package com.codewars.kata_556196a6091a7e7f58000018;

import java.util.Arrays;

public class Solution {

  public static void main(String[] args) {

  }

  public static int largestPairSum(int[] numbers){
    Arrays.sort(numbers);
    return numbers[numbers.length - 1] + numbers[numbers.length - 2];
  }
}
