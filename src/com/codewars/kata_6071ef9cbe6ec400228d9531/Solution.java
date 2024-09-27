package com.codewars.kata_6071ef9cbe6ec400228d9531;

/*
Dot Calculator

You have to write a calculator that receives strings for input. The dots will represent the number in the equation. There will be dots on one side, an operator, and dots again after the operator. The dots and the operator will be separated by one space.

Here are the following valid operators :

    + Addition
    - Subtraction
    * Multiplication
    // Integer Division

Your Work (Task)

You'll have to return a string that contains dots, as many the equation returns. If the result is 0, return the empty string. When it comes to subtraction, the first number will always be greater than or equal to the second number.
Examples (Input => Output)

* "..... + ..............." => "...................."
* "..... - ..."             => ".."
* "..... - ."               => "...."
* "..... * ..."             => "..............."
* "..... * .."              => ".........."
* "..... // .."             => ".."
* "..... // ."              => "....."
* ". // .."                 => ""
* ".. - .."                 => ""
 */
public class Solution {

  public static void main(String[] args) {
    System.out.println(calc("..... + ..............."));
    System.out.println(calc("..... - ..."));
    System.out.println(calc("..... - ."));
    System.out.println(calc("..... * ..."));
    System.out.println(calc("..... * .."));
    System.out.println(calc("..... // .."));
    System.out.println(calc("..... // ."));
    System.out.println(calc(". // .."));
    System.out.println(calc(".. - .."));
  }

  public static String calc(String txt){
    if (txt.contains(" + ")) {
      String[] strs = txt.split(" \\+ ");
      return strs[0].concat(strs[1]);
    } else if (txt.contains(" - ")) {
      String[] strs = txt.split(" - ");
      return ".".repeat(strs[0].length() - strs[1].length());
    } else if (txt.contains(" * ")) {
      String[] strs = txt.split(" \\* ");
      return ".".repeat(strs[0].length() * strs[1].length());
    } else if (txt.contains(" // ")) {
      String[] strs = txt.split(" // ");
      return ".".repeat(strs[0].length() / strs[1].length());
    }
    return "";
  }
}
