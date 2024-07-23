package com.codewars.kata_5a6d3bd238f80014a2000187;

import java.util.Arrays;

/*
This is related to my other Kata (https://www.codewars.com/kata/5a6663e9fd56cb5ab800008b/train/java) about cats and dogs.
Kata Task

I have a cat and a dog which I got as kitten / puppy.

I forget when that was, but I do know their current ages as catYears and dogYears.

Find how long I have owned each of my pets and return as a list [ownedCat, ownedDog]

NOTES:

    Results are truncated whole numbers of "human" years

Cat Years

    15 cat years for first year
    +9 cat years for second year
    +4 cat years for each year after that

Dog Years

    15 dog years for first year
    +9 dog years for second year
    +5 dog years for each year after that

References

    http://www.catster.com/cats-101/calculate-cat-age-in-cat-years
    http://www.slate.com/articles/news_and_politics/explainer/2009/05/a_dogs_life.html
 */
public class Solution {

  public static void main(String[] args) {
    System.out.println(Arrays.toString(ownedCatAndDog(15, 15))); // 1,1
    System.out.println(Arrays.toString(ownedCatAndDog(24, 24))); // 2,2
    System.out.println(Arrays.toString(ownedCatAndDog(56, 64))); // 10,10

    System.out.println(Arrays.toString(ownedCatAndDog(66, 86))); // 12,14
    System.out.println(Arrays.toString(ownedCatAndDog(39, 100))); // 5,17
    System.out.println(Arrays.toString(ownedCatAndDog(77, 31))); // 15,3
    System.out.println(Arrays.toString(ownedCatAndDog(27, 65))); // 2,10
    System.out.println(Arrays.toString(ownedCatAndDog(43, 24))); // 6,2
    System.out.println(Arrays.toString(ownedCatAndDog(97, 64))); // 20,10
    System.out.println(Arrays.toString(ownedCatAndDog(55, 45))); // 9,6
    System.out.println(Arrays.toString(ownedCatAndDog(34, 21))); // 4,1
    System.out.println(Arrays.toString(ownedCatAndDog(41, 20))); // 6,1
    System.out.println(Arrays.toString(ownedCatAndDog(16, 73))); // 1,11
    System.out.println(Arrays.toString(ownedCatAndDog(31, 4))); // 3,0
    System.out.println(Arrays.toString(ownedCatAndDog(14, 24))); // 0,2
  }

  public static int[] ownedCatAndDog(final int catYears, final int dogYears) {
    int[] result = new int[2];
    if (catYears >= 15 && catYears < 24) {
      result[0] = 1;
    } else if (catYears >= 24) {
      result[0] = 2 + (catYears - 24) / 4;
    }

    if (dogYears >= 15 && dogYears < 24) {
      result[1] = 1;
    } else if (dogYears >= 24) {
      result[1] = 2 + (dogYears - 24) / 5;
    }
    return result;
  }
}
