package com.leetcode.lc735;

import java.util.Arrays;
import java.util.Stack;

/*
735. Asteroid Collision

We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.



Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.

Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.



Constraints:

    2 <= asteroids.length <= 104
    -1000 <= asteroids[i] <= 1000
    asteroids[i] != 0
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] arr;

    arr = solution.asteroidCollision(new int[]{5, 10, -5});
    System.out.println(Arrays.toString(arr)); // [5, 10]

    arr = solution.asteroidCollision(new int[]{8, -8});
    System.out.println(Arrays.toString(arr)); // []

    arr = solution.asteroidCollision(new int[]{10, 2, -5});
    System.out.println(Arrays.toString(arr)); // [10]

    arr = solution.asteroidCollision(new int[]{10, 2, -5, 2, 6, -7});
    System.out.println(Arrays.toString(arr)); // [10]

    arr = solution.asteroidCollision(new int[]{-2, -1, 1, 2});
    System.out.println(Arrays.toString(arr)); // [-2, -1, 1, 2]

    arr = solution.asteroidCollision(new int[]{-2, -2, 1, -2});
    System.out.println(Arrays.toString(arr)); // [-2,-2,-2]

  }

  public int[] asteroidCollision(int[] asteroids) {
    var stack = new Stack<Integer>();
    var stackItem = 0;
    for (var item : asteroids) {
      if (stack.isEmpty()) {
        stack.push(item);
      } else {
        stackItem = stack.pop();
        if (stackItem > 0 && item < 0) {
          if (stackItem > -item) {
            stack.push(stackItem);
          } else if (stackItem < -item) {
            while (!stack.isEmpty() && stackItem > 0 && stackItem < -item) {
              stackItem = stack.pop();
            }
              if (stackItem > 0 && stackItem > -item) {
                stack.push(stackItem);
              } else if (stackItem > 0 && stackItem < -item) {
                stack.push(item);
              } else if (stackItem < 0) {
                stack.push(stackItem);
                stack.push(item);
              }
          }
        } else {
          stack.push(stackItem);
          stack.push(item);
        }
      }
    }
    int[] res = new int[stack.size()];
    while (!stack.isEmpty()) {
      res[stack.size() - 1] = stack.pop();
    }
    return res;
  }
}
