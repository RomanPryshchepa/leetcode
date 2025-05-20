package com.leetcode.lc257;

import com.leetcode.tools.TreeNode;
import java.util.ArrayList;
import java.util.List;

/*
257. Binary Tree Paths

Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.



Example 1:

Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]

Example 2:

Input: root = [1]
Output: ["1"]



Constraints:

    The number of nodes in the tree is in the range [1, 100].
    -100 <= Node.val <= 100
 */

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
  private final List<String> result = new ArrayList<>();
  private final List<String> list = new ArrayList<>();

  public static void main(String[] args) {
    Solution solution = new Solution();
    TreeNode root = new TreeNode(1);
    System.out.println(solution.binaryTreePaths(root));

    solution = new Solution();
    root.left = new TreeNode(2, null, new TreeNode(5));
    root.right = new TreeNode(3);
    System.out.println(solution.binaryTreePaths(root));
  }

  public List<String> binaryTreePaths(TreeNode root) {
    step(root);
    return result;
  }

  private void step(TreeNode node) {
    if (node == null) return;

    list.add(String.valueOf(node.val));

    if (node.left == null && node.right == null)
      result.add(String.join("->", list));
    else {
      step(node.left);
      step(node.right);
    }
    list.remove(list.size() - 1);
  }
}
