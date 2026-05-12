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

import com.leetcode.tools.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
    var solution = new Solution();

    var root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
    System.out.println(solution.inorderTraversal(root));
    System.out.println(solution.inorderTraversal2(root));

    root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(6), new TreeNode(7))), new TreeNode(3, null, new TreeNode(8, new TreeNode(9), null)));
    System.out.println(solution.inorderTraversal(root));
    System.out.println(solution.inorderTraversal2(root));

    root = new TreeNode();
    System.out.println(solution.inorderTraversal(root));
    System.out.println(solution.inorderTraversal2(root));

    root = new TreeNode(1);
    System.out.println(solution.inorderTraversal(root));
    System.out.println(solution.inorderTraversal2(root));
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

  public List<Integer> inorderTraversal2(TreeNode root) {
    var nodes = new LinkedList<TreeNode>();
    var result = new LinkedList<Integer>();
    if (root == null)
      return result;
    var stack = new Stack<TreeNode>();
    stack.push(root);
    while (!stack.empty()) {
      if (stack.peek().left != null && !nodes.contains(stack.peek().left))
        stack.push(stack.peek().left);
      else if (stack.peek().right != null) {
        var node = stack.pop();
        stack.push(node.right);
        nodes.add(node);
      } else
        nodes.add(stack.pop());
    }
    for (var node : nodes)
      result.add(node.val);
    return result;
  }
}
