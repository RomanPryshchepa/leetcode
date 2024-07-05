package com.codewars.kata_554e4a2f232cdd87d9000038;

/*
Deoxyribonucleic acid (DNA) is a chemical found in the nucleus of cells and carries the "instructions" for the development and functioning of living organisms.

If you want to know more: http://en.wikipedia.org/wiki/DNA

In DNA strings, symbols "A" and "T" are complements of each other, as "C" and "G". Your function receives one side of the DNA (string, except for Haskell); you need to return the other complementary side. DNA strand is never empty or there is no DNA at all (again, except for Haskell).

More similar exercise are found here: http://rosalind.info/problems/list-view/ (source)

Example: (input --> output)

"ATTGC" --> "TAACG"
"GTAT" --> "CATA"
 */
public class Solution {

  public static void main(String[] args) {
    System.out.println(makeComplement("ATTGC")); // "TAACG"
    System.out.println(makeComplement("GTAT")); // "CATA"
  }

  public static String makeComplement(String dna) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < dna.length(); i++) {
      switch (dna.charAt(i)) {
        case 'A':
          stringBuilder.append("T");
          break;
        case 'T':
          stringBuilder.append("A");
          break;
        case 'G':
          stringBuilder.append("C");
          break;
        case 'C':
          stringBuilder.append("G");
          break;
      }
    }
    return stringBuilder.toString();
  }
}
