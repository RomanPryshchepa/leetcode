package com.leetcode.lc739;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
739. Daily Temperatures

Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.



Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]

Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]

Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]



Constraints:

    1 <= temperatures.length <= 105
    30 <= temperatures[i] <= 100

 */
public class Solution {

  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(new String[]{"0 ", "1 ", "2 ", "3 ", "4 ", "5 ", "6 ", "7 "}));
    int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
    System.out.println(Arrays.toString(temperatures));
    System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    System.out.println(Arrays.toString(dailyTemperatures1(temperatures)));

    System.out.println();
    int[] temperatures1 = {99, 99, 99, 99, 99, 99, 99, 100};
    System.out.println(Arrays.toString(temperatures1));
    System.out.println(Arrays.toString(dailyTemperatures(temperatures1)));
    System.out.println(Arrays.toString(dailyTemperatures1(temperatures1)));

    System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 40, 50, 60})));
    System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 60, 90})));
  }

  public static int[] dailyTemperatures(int[] temperatures) {
    int[] res = new int[temperatures.length];
    Deque<Integer> stack = new LinkedList<>();
    stack.push(temperatures[0]);
    for (int i = 1; i < temperatures.length; i++) {
      if (temperatures[i] > stack.peek()) {
        int k = i;
        while (!stack.isEmpty() && temperatures[i] > stack.peek()) {
          do {
            k--;
          } while (res[k] != 0);
          stack.pop();
          res[k] = i - k;
        }
        stack.push(temperatures[i]);
      } else {
        stack.push(temperatures[i]);
      }
    }
    return res;
  }


  public static int[] dailyTemperatures1(int[] temperatures) {
    int[] res = new int[temperatures.length];
    for (int i = 0; i < temperatures.length - 1; i++) {
      int j = i + 1;
      while (j < temperatures.length) {
        if (temperatures[j] > temperatures[i]) {
          res[i] = j - i;
          break;
        }
        j++;
      }
    }
    return res;
  }
}
