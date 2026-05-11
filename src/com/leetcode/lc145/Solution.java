package com.leetcode.lc145;

/*
145. Binary Tree Postorder Traversal

Given the root of a binary tree, return the postorder traversal of its nodes' values.



Example 1:

Input: root = [1,null,2,3]
Output: [3,2,1]

Example 2:

Input: root = []
Output: []

Example 3:

Input: root = [1]
Output: [1]



Constraints:

    The number of the nodes in the tree is in the range [0, 100].
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
    System.out.println(solution.postorderTraversal(root));
    System.out.println(solution.postorderTraversal2(root));

    root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(6), new TreeNode(7))), new TreeNode(3, null, new TreeNode(8, new TreeNode(9), null)));
    System.out.println(solution.postorderTraversal(root));
    System.out.println(solution.postorderTraversal2(root));

    root = new TreeNode();
    System.out.println(solution.postorderTraversal(root));
    System.out.println(solution.postorderTraversal2(root));

    root = new TreeNode(1);
    System.out.println(solution.postorderTraversal(root));
    System.out.println(solution.postorderTraversal2(root));
  }

  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    if (root.left != null) {
      result.addAll(postorderTraversal(root.left));
    }
    if (root.right != null) {
      result.addAll(postorderTraversal(root.right));
    }
    result.add(root.val);
    return result;
  }

  public List<Integer> postorderTraversal2(TreeNode root) {
    var nodes = new LinkedList<TreeNode>();
    var result = new LinkedList<Integer>();
    if (root == null)
      return result;
    var stack = new Stack<TreeNode>();
    stack.push(root);
    while (!stack.empty()) {
      if (stack.peek().left != null && !nodes.contains(stack.peek().left))
        stack.push(stack.peek().left);
      else if (stack.peek().right != null && !nodes.contains(stack.peek().right))
        stack.push(stack.peek().right);
      else
        nodes.add(stack.pop());
    }
    for (var node : nodes)
      result.add(node.val);
    return result;
  }
}
