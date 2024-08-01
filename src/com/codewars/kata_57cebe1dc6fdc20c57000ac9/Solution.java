package com.codewars.kata_57cebe1dc6fdc20c57000ac9;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

  public static void main(String[] args) {
    System.out.println(findShort("bitcoin take over the world maybe who knows perhaps")); // 3
    System.out.println(findShort("turns out random test cases are easier than writing out basic ones")); // 3
    System.out.println(findShort("Let's travel abroad shall we")); // 2
  }

  public static int findShort(String s) {
    return Arrays.stream(s.split(" ")).sorted(Comparator.comparingInt(String::length)).findFirst().get().length();
  }
}
