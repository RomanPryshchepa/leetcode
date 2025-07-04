package com.leetcode.lc938;

/*
938. Range Sum of BST

Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].



Example 1:

Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32
Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.

Example 2:

Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
Output: 23
Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.



Constraints:

    The number of nodes in the tree is in the range [1, 2 * 104].
    1 <= Node.val <= 105
    1 <= low <= high <= 105
    All Node.val are unique.
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
    TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(3), new TreeNode(7)), new TreeNode(15, null, new TreeNode(18)));
    System.out.println(solution.rangeSumBST(root, 7, 15));
    root = new TreeNode(10, new TreeNode(5, new TreeNode(3, new TreeNode(1), null), new TreeNode(7, new TreeNode(6), null)), new TreeNode(15, new TreeNode(13), new TreeNode(18)));
    System.out.println(solution.rangeSumBST(root, 6, 10));
  }

  public int rangeSumBST(TreeNode root, int low, int high) {
    TreeNode sum = new TreeNode(0);
    rangeSumBSTHelper(root, sum, low, high);
    return sum.val;
  }

  private void rangeSumBSTHelper(TreeNode root, TreeNode sum, int low, int high) {
    if (root  == null)
      return;
    if (root.val >= low && root.val <= high) {
      sum.val += root.val;
    }
    rangeSumBSTHelper(root.left, sum, low, high);
    rangeSumBSTHelper(root.right, sum, low, high);
  }
}
