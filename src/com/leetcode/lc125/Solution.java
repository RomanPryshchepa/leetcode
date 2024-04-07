package com.leetcode.lc125;

/*
125. Valid Palindrome

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.



Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.



Constraints:

    1 <= s.length <= 2 * 105
    s consists only of printable ASCII characters.

 */
public class Solution {

  public static void main(String[] args) {
    //Example 1:
    //
    //Input: s = "A man, a plan, a canal: Panama"
    //Output: true
    //Explanation: "amanaplanacanalpanama" is a palindrome.
    System.out.println(isPalindrome("A man, a plan, a canal: Panama"));

    //Example 2:
    //
    //Input: s = "race a car"
    //Output: false
    //Explanation: "raceacar" is not a palindrome.
    System.out.println(isPalindrome("race a car"));

    //Example 3:
    //
    //Input: s = " "
    //Output: true
    //Explanation: s is an empty string "" after removing non-alphanumeric characters.
    //Since an empty string reads the same forward and backward, it is a palindrome.
    System.out.println(isPalindrome(" "));
    System.out.println("=================");
    System.out.println(isPalindrome("aa"));
    System.out.println(isPalindrome("aaa"));
    System.out.println(isPalindrome("aaaa"));
    System.out.println(isPalindrome("dsa,asd"));
    System.out.println(isPalindrome("a,b,a"));
    System.out.println(isPalindrome("+-"));
  }

  public static boolean isPalindrome(String s) {
    char[] charArray = s.toLowerCase().toCharArray();
    int i = 0;
    int j = charArray.length - 1;
    while (i < j && i < charArray.length && j >= 0) {
      while (i < charArray.length && i < j && !Character.isLetterOrDigit(charArray[i])) {
        i++;
      }
      while (j >= 0 && i < j && !Character.isLetterOrDigit(charArray[j])) {
        j--;
      }
      if (charArray[i] != charArray[j]) {
        return false;
      } else {
        i++;
        j--;
      }
    }
    return true;
  }

  public static boolean isPalindrome1(String s) {
    s = s.replaceAll("[^a-zA-Z0-9]+", "").toLowerCase();
    return new StringBuilder(s).reverse().toString().equals(s);
  }

}
