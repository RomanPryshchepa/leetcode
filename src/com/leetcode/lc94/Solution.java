package com.leetcode.lc94;

/*
94. Binary Tree Inorder Traversal

Given the root of a binary tree, return the inorder traversal of its nodes' values.



Example 1:

Input: root = [1,null,2,3]
Output: [1,3,2]

Example 2:

Input: root = []
Output: []

Example 3:

Input: root = [1]
Output: [1]



Constraints:

    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100


Follow up: Recursive solution is trivial, could you do it iteratively?
 */

import java.util.ArrayList;
import java.util.List;

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
public class Solution {

  public static void main(String[] args) {

  }

  public List<Integer> inorderTraversal(TreeNode root) {
    var result = new ArrayList<Integer>();
    if (root == null) {
      return result;
    }
    if (root.left != null) {
      result.addAll(inorderTraversal(root.left));
    }
    result.add(root.val);
    if (root.right != null) {
      result.addAll(inorderTraversal(root.right));
    }
    return result;
  }

}
