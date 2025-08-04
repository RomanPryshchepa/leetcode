package com.leetcode.lc2265;

/*
2265. Count Nodes Equal to Average of Subtree

Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average of the values in its subtree.

Note:

    The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
    A subtree of root is a tree consisting of root and all of its descendants.



Example 1:

Input: root = [4,8,5,0,1,null,6]
Output: 5
Explanation:
For the node with value 4: The average of its subtree is (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4.
For the node with value 5: The average of its subtree is (5 + 6) / 2 = 11 / 2 = 5.
For the node with value 0: The average of its subtree is 0 / 1 = 0.
For the node with value 1: The average of its subtree is 1 / 1 = 1.
For the node with value 6: The average of its subtree is 6 / 1 = 6.

Example 2:

Input: root = [1]
Output: 1
Explanation: For the node with value 1: The average of its subtree is 1 / 1 = 1.



Constraints:

    The number of nodes in the tree is in the range [1, 1000].
    0 <= Node.val <= 1000
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
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    TreeNode root = new TreeNode(4, new TreeNode(8, new TreeNode(0), new TreeNode(1)), new TreeNode(5, null, new TreeNode(6)));
    System.out.println(solution.averageOfSubtree(root));
  }

  public int averageOfSubtree(TreeNode root) {
    var count = new TreeNode(0);
    averageOfSubtreeHelper(count, root);
    return count.val;
  }

  private void averageOfSubtreeHelper(TreeNode count, TreeNode root) {
    if (root == null)
      return;
    var sum = new TreeNode(0);
    var cnt = new TreeNode(0);
    averageOfSubtreeSumCount(sum, cnt, root);
    if (cnt.val > 0 && root.val == sum.val / cnt.val)
      count.val++;
    averageOfSubtreeHelper(count, root.left);
    averageOfSubtreeHelper(count, root.right);
  }

  private void averageOfSubtreeSumCount(TreeNode sum, TreeNode count, TreeNode root) {
    if (root == null)
      return;
    sum.val += root.val;
    count.val++;
    averageOfSubtreeSumCount(sum, count, root.left);
    averageOfSubtreeSumCount(sum, count, root.right);
  }
}