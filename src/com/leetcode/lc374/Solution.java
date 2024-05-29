package com.leetcode.lc374;

/*
374. Guess Number Higher or Lower

We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

You call a pre-defined API int guess(int num), which returns three possible results:

    -1: Your guess is higher than the number I picked (i.e. num > pick).
    1: Your guess is lower than the number I picked (i.e. num < pick).
    0: your guess is equal to the number I picked (i.e. num == pick).

Return the number that I picked.



Example 1:

Input: n = 10, pick = 6
Output: 6

Example 2:

Input: n = 1, pick = 1
Output: 1

Example 3:

Input: n = 2, pick = 1
Output: 1



Constraints:

    1 <= n <= 231 - 1
    1 <= pick <= n
 */

public class Solution {

  public static void main(String[] args) {
    System.out.println(guess(10, 5));
    System.out.println(guess(1, 5));
    System.out.println(guess(1, 1));

    Solution solution = new Solution();
    System.out.println(solution.guessNumber(10));
    System.out.println(solution.guessNumber(1));
  }

  public int guessNumber(int n) {
    int start = 1;
    int end = n;
    while (guess(n) != 0) {
      n = start + (end - start) / 2;
      if (guess(n) == 0) {
        return n;
      }
      if (guess(n) == -1) {
        end = n - 1;
      } else {
        start = n + 1;
      }
    }
    return n;
  }

  /**
   * Forward declaration of guess API.
   * @param  num   your guess
   * @return       -1 if num is higher than the picked number
   *			      1 if num is lower than the picked number
   *               otherwise return 0
   * int guess(int num);
   */
  private static int guess(int num) {
    return Integer.compare(1, num);
  }

  private static int guess(int num, int pick) {
    return Integer.compare(pick, num);
  }
}
