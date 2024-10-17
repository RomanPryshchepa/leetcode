package com.leetcode.lc946;

import java.util.Stack;

/*
946. Validate Stack Sequences

Given two integer arrays pushed and popped each with distinct values, return true if this could have been the result of a sequence of push and pop operations on an initially empty stack, or false otherwise.



Example 1:

Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Output: true
Explanation: We might do the following sequence:
push(1), push(2), push(3), push(4),
pop() -> 4,
push(5),
pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1

Example 2:

Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
Output: false
Explanation: 1 cannot be popped before 2.



Constraints:

    1 <= pushed.length <= 1000
    0 <= pushed[i] <= 1000
    All the elements of pushed are unique.
    popped.length == pushed.length
    popped is a permutation of pushed.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(
        solution.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
    System.out.println(
        solution.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
  }

  public boolean validateStackSequences(int[] pushed, int[] popped) {
    var pushedIdx = 0;
    var poppedIdx = 0;
    var stack = new Stack<Integer>();
    var flag = true;
    while (flag)
    {
      flag = false;
      while (pushedIdx < pushed.length)
      {
        flag = true;
        stack.push(pushed[pushedIdx]);
        if (pushed[pushedIdx] == popped[poppedIdx])
        {
          pushedIdx++;
          break;
        }
        pushedIdx++;
      }
      while (!stack.isEmpty() && poppedIdx < popped.length && stack.peek() == popped[poppedIdx])
      {
        flag = true;
        stack.pop();
        poppedIdx++;
      }
    }

    return stack.isEmpty();
  }
}
