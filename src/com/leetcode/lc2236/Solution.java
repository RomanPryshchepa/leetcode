package com.leetcode.lc2236;

/*
2236. Root Equals Sum of Children

You are given the root of a binary tree that consists of exactly 3 nodes: the root, its left child, and its right child.

Return true if the value of the root is equal to the sum of the values of its two children, or false otherwise.



Example 1:

Input: root = [10,4,6]
Output: true
Explanation: The values of the root, its left child, and its right child are 10, 4, and 6, respectively.
10 is equal to 4 + 6, so we return true.

Example 2:

Input: root = [5,3,1]
Output: false
Explanation: The values of the root, its left child, and its right child are 5, 3, and 1, respectively.
5 is not equal to 3 + 1, so we return false.



Constraints:

    The tree consists only of the root, its left child, and its right child.
    -100 <= Node.val <= 100
 */

import com.leetcode.tools.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.checkTree(new TreeNode(10, new TreeNode(4), new TreeNode(6))));
    System.out.println(solution.checkTree(new TreeNode(5, new TreeNode(3), new TreeNode(1))));
  }

  public boolean checkTree(TreeNode root) {
    return root.val == root.left.val + root.right.val;
  }
}