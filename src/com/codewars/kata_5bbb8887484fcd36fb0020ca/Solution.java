package com.codewars.kata_5bbb8887484fcd36fb0020ca;

/*
Count how often sign changes in array.
result

number from 0 to ... . Empty array returns 0
example

const arr = [1, -3, -4, 0, 5];


| elem | count |
|------|-------|
|  1   |  0    |
| -3   |  1    |
| -4   |  1    |
|  0   |  2    |
|  5   |  2    |


catchSignChange(arr) == 2;
*/
public class Solution {

  public static void main(String[] args) {
    System.out.println(signChange(new int[]{1, -3, -4, 0, 5}));
  }

  public static int signChange(int[] arr) {
    if (arr.length == 0) {
      return 0;
    }
    int res = 0;
    boolean pos = (arr[0] >= 0);
    for(int i = 1; i < arr.length; i++) {
      if (arr[i] < 0 && pos) {
        res++;
        pos = false;
      } else if (arr[i] >= 0 && !pos) {
        res++;
        pos = true;
      }
    }
    return res;
  }

}
