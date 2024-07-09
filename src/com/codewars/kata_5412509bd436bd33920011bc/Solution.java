package com.codewars.kata_5412509bd436bd33920011bc;

/*
Usually when you buy something, you're asked whether your credit card number, phone number or answer to your most secret question is still correct. However, since someone could look over your shoulder, you don't want that shown on your screen. Instead, we mask it.

Your task is to write a function maskify, which changes all but the last four characters into '#'.
Examples (input --> output):

"4556364607935616" --> "############5616"
     "64607935616" -->      "#######5616"
               "1" -->                "1"
                "" -->                 ""

// "What was the name of your first pet?"
"Skippy" --> "##ippy"
"Nananananananananananananananana Batman!" --> "####################################man!"
 */
public class Solution {

  public static void main(String[] args) {
    System.out.println(maskify("4556364607935616").equals("############5616"));
    System.out.println(maskify("64607935616").equals("#######5616"));
    System.out.println(maskify("1").equals("1"));
    System.out.println(maskify("").equals(""));
    System.out.println(maskify("Skippy").equals("##ippy"));
    System.out.println(maskify("Nananananananananananananananana Batman!").equals(
        "####################################man!"));
  }

  public static String maskify(String str) {
    if (str == null || str.length() <= 4) {
      return str;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      if (i < str.length() - 4) {
        sb.append("#");
      } else {
        sb.append(str.charAt(i));
      }
    }
    return sb.toString();
  }
}
