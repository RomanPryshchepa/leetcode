package com.codewars.kata_5a04450c8ba914083700000a;

/*
You are given a binary tree. Implement the method findMax which returns the maximal node value in the tree.

For example, maximum in the following Tree is 11.

              7
            /   \
           /     \
          5       2
           \       \
           6        11
           /\      /
          1  9   4

Note:

    Tree node values any integer value.
    Tree can unbalanced and unsorted.
    The root argument is never an empty tree.

You are given a tree node class as follows:
class TreeNode {
  TreeNode  left;
  TreeNode  right;
  int value;
}
 */
public class Solution {

  public static void main(String[] args) {

  }

  static int findMax(TreeNode root) {
    if (root.left == null && root.right == null) {
      return root.value;
    } else if (root.left == null) {
      int maxRight = findMax(root.right);
      return Math.max(maxRight, root.value);
    } else if (root.right == null) {
      int maxLeft = findMax(root.left);
      return Math.max(maxLeft, root.value);
    } else {
      int maxRight = findMax(root.right);
      int maxLeft = findMax(root.left);
      int maxLeftRight = Math.max(maxLeft, maxRight);
      return Math.max(root.value, maxLeftRight);
    }
  }
}
