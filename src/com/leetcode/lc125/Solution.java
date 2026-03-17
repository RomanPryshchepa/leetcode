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
    var solution = new Solution();
    //Example 1:
    //
    //Input: s = "A man, a plan, a canal: Panama"
    //Output: true
    //Explanation: "amanaplanacanalpanama" is a palindrome.
    System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
    System.out.println(solution.isPalindrome2("A man, a plan, a canal: Panama"));

    //Example 2:
    //
    //Input: s = "race a car"
    //Output: false
    //Explanation: "raceacar" is not a palindrome.
    System.out.println(solution.isPalindrome("race a car"));
    System.out.println(solution.isPalindrome2("race a car"));

    //Example 3:
    //
    //Input: s = " "
    //Output: true
    //Explanation: s is an empty string "" after removing non-alphanumeric characters.
    //Since an empty string reads the same forward and backward, it is a palindrome.
    System.out.println(solution.isPalindrome(" "));
    System.out.println(solution.isPalindrome2(" "));
    System.out.println("=================");
    System.out.println(solution.isPalindrome("aa"));
    System.out.println(solution.isPalindrome2("aa"));
    System.out.println(solution.isPalindrome("aaa"));
    System.out.println(solution.isPalindrome2("aaa"));
    System.out.println(solution.isPalindrome("aaaa"));
    System.out.println(solution.isPalindrome2("aaaa"));
    System.out.println(solution.isPalindrome("dsa,asd"));
    System.out.println(solution.isPalindrome2("dsa,asd"));
    System.out.println(solution.isPalindrome("a,b,a"));
    System.out.println(solution.isPalindrome2("a,b,a"));
    System.out.println(solution.isPalindrome("+-"));
    System.out.println(solution.isPalindrome2("+-"));
  }

  public boolean isPalindrome(String s) {
    var lPointer = 0;
    var rPointer = s.length() - 1;
    while (lPointer < rPointer) {
      while (lPointer < s.length() && !Character.isLetterOrDigit(s.charAt(lPointer)))
        lPointer++;
      while (rPointer >= 0 && !Character.isLetterOrDigit(s.charAt(rPointer)))
        rPointer--;
      if (lPointer < s.length() && rPointer >= 0 && Character.toLowerCase(s.charAt(lPointer++)) != Character.toLowerCase(s.charAt(rPointer--)))
        return false;
    }
    return true;
  }

  public boolean isPalindrome2(String s) {
    s = s.replaceAll("[^a-zA-Z0-9]+", "").toLowerCase();
    return new StringBuilder(s).reverse().toString().equals(s);
  }

}
