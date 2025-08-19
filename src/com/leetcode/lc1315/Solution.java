package com.leetcode.lc1315;

/*
1315. Sum of Nodes with Even-Valued Grandparent

Given the root of a binary tree, return the sum of values of nodes with an even-valued grandparent. If there are no nodes with an even-valued grandparent, return 0.

A grandparent of a node is the parent of its parent if it exists.



Example 1:

Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 18
Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.

Example 2:

Input: root = [1]
Output: 0



Constraints:

    The number of nodes in the tree is in the range [1, 104].
    1 <= Node.val <= 100
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
    var root = new TreeNode(6, new TreeNode(7, new TreeNode(2, new TreeNode(9), null), new TreeNode(7, new TreeNode(1), new TreeNode(4))), new TreeNode(8, new TreeNode(1), new TreeNode(3, null, new TreeNode(5))));
    System.out.println(solution.sumEvenGrandparent(root));

    root = new TreeNode(1);
    System.out.println(solution.sumEvenGrandparent(root));
  }

  public int sumEvenGrandparent(TreeNode root) {
    var sum = new TreeNode(0);
    sumEvenGrandparentRec(root, sum);
    return sum.val;
  }

  private void sumEvenGrandparentRec(TreeNode root, TreeNode sum) {
    if (root == null)
      return;

    if (root.val % 2 == 0)
      sum.val += sumEvenGrandparentHelper(root);

    sumEvenGrandparentRec(root.left, sum);
    sumEvenGrandparentRec(root.right, sum);
  }

  private int sumEvenGrandparentHelper(TreeNode root) {
    var sum = 0;
    if (root == null)
      return 0;
    if (root.left != null) {
      if (root.left.left != null)
        sum += root.left.left.val;
      if (root.left.right != null)
        sum += root.left.right.val;
    }
    if (root.right != null) {
      if (root.right.left != null)
        sum += root.right.left.val;
      if (root.right.right != null)
        sum += root.right.right.val;
    }
    return sum;
  }
}