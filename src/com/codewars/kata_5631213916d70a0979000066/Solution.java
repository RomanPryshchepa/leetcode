package com.codewars.kata_5631213916d70a0979000066;

/*
Task

Using n as a parameter in the function pattern, where n>0, complete the codes to get the pattern (take the help of examples):

Note: There is no newline in the end (after the pattern ends)
Examples

pattern(3) should return "1\n1*2\n1**3", e.g. the following:

1
1*2
1**3

pattern(10): should return the following:

1
1*2
1**3
1***4
1****5
1*****6
1******7
1*******8
1********9
1*********10
 */
public class Solution {

  public static void main(String[] args) {
    System.out.println(pattern(3));
    System.out.println(pattern(10));
  }

  public static String pattern(int n) {
    StringBuilder sb = new StringBuilder();
    String delim = "";

    for (int i = 1; i <= n; i++) {
      sb.append(delim);
      sb.append("1");
      sb.append("*".repeat(Math.max(0, i - 1)));
      if (i > 1) {
        sb.append(i);
      }
      delim = "\n";
    }
    return sb.toString();
  }
}
