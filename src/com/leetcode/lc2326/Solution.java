package com.leetcode.lc2326;

/*
2326. Spiral Matrix IV

You are given two integers m and n, which represent the dimensions of a matrix.

You are also given the head of a linked list of integers.

Generate an m x n matrix that contains the integers in the linked list presented in spiral order (clockwise), starting from the top-left of the matrix. If there are remaining empty spaces, fill them with -1.

Return the generated matrix.



Example 1:

Input: m = 3, n = 5, head = [3,0,2,6,8,1,7,9,4,2,5,5,0]
Output: [[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]
Explanation: The diagram above shows how the values are printed in the matrix.
Note that the remaining spaces in the matrix are filled with -1.

Example 2:

Input: m = 1, n = 4, head = [0,1,2]
Output: [[0,1,2,-1]]
Explanation: The diagram above shows how the values are printed from left to right in the matrix.
The last space in the matrix is set to -1.



Constraints:

    1 <= m, n <= 105
    1 <= m * n <= 105
    The number of nodes in the list is in the range [1, m * n].
    0 <= Node.val <= 1000
 */

import com.leetcode.tools.ListNode;
import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    var head = new ListNode(3, new ListNode(0, new ListNode(2, new ListNode(6, new ListNode(8, new ListNode(1, new ListNode(7, new ListNode(9, new ListNode(4, new ListNode(2, new ListNode(5, new ListNode(5, new ListNode(0)))))))))))));
    System.out.println(Arrays.deepToString(solution.spiralMatrix(3, 5, head)));
    head = new ListNode(0, new ListNode(1, new ListNode(2)));
    System.out.println(Arrays.deepToString(solution.spiralMatrix(1, 4, head)));
  }

  public int[][] spiralMatrix(int m, int n, ListNode head) {
    var result = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        result[i][j] = -1;
      }
    }
    var i = 0;
    var j = 0;
    var current = head;
    var direction = 'R';
    while (current != null) {
      result[i][j] = current.val;
      current = current.next;
      if (direction == 'R') {
        if (j < n - 1 && result[i][j + 1] == -1) {
          j++;
        } else {
          direction = 'D';
          i++;
        }
      } else if (direction == 'D') {
        if (i < m - 1 && result[i + 1][j] == -1) {
          i++;
        } else {
          direction = 'L';
          j--;
        }
      } else if (direction == 'L') {
        if (j > 0 && result[i][j - 1] == -1) {
          j--;
        } else {
          direction = 'U';
          i--;
        }
      } else { // if (direction == 'U')
        if (i > 0 && result[i - 1][j] == -1) {
          i--;
        } else {
          direction = 'R';
          j++;
        }
      }
    }
    return result;
  }
}
