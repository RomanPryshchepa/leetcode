package com.leetcode.lc226;

/*
226. Invert Binary Tree

Given the root of a binary tree, invert the tree, and return its root.



Example 1:

Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]

Example 2:

Input: root = [2,1,3]
Output: [2,3,1]

Example 3:

Input: root = []
Output: []



Constraints:

    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100
 */
import com.leetcode.tools.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

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

  }

  public TreeNode invertTree(TreeNode root) {
    if (root == null)
      return root;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      var node = queue.poll();
      if (node != null) {
        queue.add(node.left);
        queue.add(node.right);
        var left = node.left;
        node.left = node.right;
        node.right = left;
      }
    }
    return root;
  }
}