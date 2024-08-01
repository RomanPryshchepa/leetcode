package com.codewars.kata_56d931ecc443d475d5000003;

public class Solution {

  public static void main(String[] args) {
    System.out.println(testTrueFalse(6));

    System.out.println("for n = 0 : " + (0 == testTrueFalse(0)));
    System.out.println("for n = 1 : " + (1 == testTrueFalse(1)));

    System.out.println("for n = 2 : " + (1 == testTrueFalse(2)));
    System.out.println("for n = 3 : " + (2 == testTrueFalse(3)));

    System.out.println("for n = 4 : " + (1 == testTrueFalse(4)));
    System.out.println("for n = 5 : " + (2 == testTrueFalse(5)));
    System.out.println("for n = 6 : " + (2 == testTrueFalse(6)));
    System.out.println("for n = 7 : " + (3 == testTrueFalse(7)));
    System.out.println("for n = 8 : " + (1 == testTrueFalse(8)));
    System.out.println("for n = 9 : " + (2 == testTrueFalse(9)));
    System.out.println("for n = 10 : " + (2 == testTrueFalse(10)));
    System.out.println("for n = 100 : " + (3 == testTrueFalse(100)));
    System.out.println("for n = 1000 : " + (6 == testTrueFalse(1000)));
    System.out.println("for n = 10000 : " + (5 == testTrueFalse(10000)));
  }

  public static int testTrueFalse(int n) {
    if (n <= 1) return n;
    if (Math.pow(2, (int)(Math.log(n)/Math.log(2))) == n) return 1;
    if (n % 3 == 0) return 2;
    if (n % 5 == 0) return 2;
    return 0;
  }
}
/*
0 => 0
1 => 1
2 => 1
3 => 2
4 => 1
5 => 2
6 => 2
7 => 3
8 => 1
9 => 2
10 => 2
100 => 3
1000 => 6
10000 => 5
 */