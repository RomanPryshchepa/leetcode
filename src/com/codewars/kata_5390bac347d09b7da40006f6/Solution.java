package com.codewars.kata_5390bac347d09b7da40006f6;

/*
Jaden Smith, the son of Will Smith, is the star of films such as The Karate Kid (2010) and After Earth (2013). Jaden is also known for some of his philosophy that he delivers via Twitter. When writing on Twitter, he is known for almost always capitalizing every word. For simplicity, you'll have to capitalize each word, check out how contractions are expected to be in the example below.

Your task is to convert strings to how they would be written by Jaden Smith. The strings are actual quotes from Jaden Smith, but they are not capitalized in the same way he originally typed them.

Example:

Not Jaden-Cased: "How can mirrors be real if our eyes aren't real"
Jaden-Cased:     "How Can Mirrors Be Real If Our Eyes Aren't Real"

Note that the Java version expects a return value of null for an empty string or null.

Link to Jaden's former Twitter account @officialjaden via archive.org
https://web.archive.org/web/20190624190255/https://twitter.com/officialjaden
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.toJadenCase("How can mirrors be real if our eyes aren't real"));
  }

  public String toJadenCase(String phrase) {
    if (phrase == null || phrase.isEmpty()) {
      return null;
    }
    StringBuilder sb = new StringBuilder();
    sb.append(Character.toUpperCase(phrase.charAt(0)));
    for (int i = 1; i < phrase.length(); i++) {
      if (phrase.charAt(i - 1) == ' ' && Character.isAlphabetic(phrase.charAt(i))) {
        sb.append(Character.toUpperCase(phrase.charAt(i)));
      } else {
        sb.append(phrase.charAt(i));
      }
    }
    return sb.toString();
  }

}
