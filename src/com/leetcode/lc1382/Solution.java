package com.leetcode.lc1382;

/*
1382. Balance a Binary Search Tree

Given the root of a binary search tree, return a balanced binary search tree with the same node values. If there is more than one answer, return any of them.

A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.



Example 1:

Input: root = [1,null,2,null,3,null,4,null,null]
Output: [2,1,3,null,null,null,4]
Explanation: This is not the only correct answer, [3,1,4,null,2] is also correct.

Example 2:

Input: root = [2,1,3]
Output: [2,1,3]



Constraints:

    The number of nodes in the tree is in the range [1, 104].
    1 <= Node.val <= 105
 */
import com.leetcode.tools.TreeNode;
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
class Solution {
  private List<Integer> values;

  public static void main(String[] args) {
    Solution solution = new Solution();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    System.out.println(solution.balanceBST(root));
  }

  public TreeNode balanceBST(TreeNode root) {
    values = new ArrayList<>();
    inOrderTraversal(root);
    return buildBalanceBST(0, values.size() - 1);
  }

  private void inOrderTraversal(TreeNode root) {
    if (root == null)
      return;
    inOrderTraversal(root.left);
    values.add(root.val);
    inOrderTraversal(root.right);
  }

  private TreeNode buildBalanceBST(int start, int end) {
    if (start > end)
      return null;
    var mid = (start + end) / 2;
    var root = new TreeNode(values.get(mid));
    root.left = buildBalanceBST(start, mid - 1);
    root.right = buildBalanceBST(mid + 1, end);
    return root;
  }
}