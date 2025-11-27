package com.leetcode.lc700;

/*
700. Search in a Binary Search Tree

You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.



Example 1:

Input: root = [4,2,7,1,3], val = 2
Output: [2,1,3]

Example 2:

Input: root = [4,2,7,1,3], val = 5
Output: []



Constraints:

    The number of nodes in the tree is in the range [1, 5000].
    1 <= Node.val <= 10^7
    root is a binary search tree.
    1 <= val <= 10^7
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
    var root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));
    TreeNode result = solution.searchBST(root, 2);
    System.out.println(result.val + ", " + result.left.val + ", " + result.right.val);
    System.out.println(solution.searchBST(root, 5));
  }

  public TreeNode searchBST(TreeNode root, int val) {
    TreeNode node = root;
    while (node != null) {
      if (node.val == val) {
        return node;
      }
      if (val < node.val) {
        node = node.left;
      } else {
        node = node.right;
      }
    }
    return null;
  }
}