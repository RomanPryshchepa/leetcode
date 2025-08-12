package com.leetcode.lc1302;

/*
1302. Deepest Leaves Sum

Given the root of a binary tree, return the sum of values of its deepest leaves.



Example 1:

Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15

Example 2:

Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 19



Constraints:

    The number of nodes in the tree is in the range [1, 104].
    1 <= Node.val <= 100
 */

import com.leetcode.tools.TreeNode;
import java.util.ArrayList;

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
    var root = new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(7), null), new TreeNode(5)), new TreeNode(3, null, new TreeNode(6, null, new TreeNode(8))));
    System.out.println(solution.deepestLeavesSum(root));
  }

  public int deepestLeavesSum(TreeNode root) {
    var parentNodes = new ArrayList<TreeNode>();
    var childNodes = new ArrayList<TreeNode>();
    parentNodes.add(root);
    while (true) {
      for (var node : parentNodes) {
        if (node.left != null)
          childNodes.add(node.left);

        if (node.right != null)
          childNodes.add(node.right);
      }
      if (childNodes.isEmpty())
        break;
      parentNodes = childNodes;
      childNodes = new ArrayList<TreeNode>();
    }
    var result = 0;
    for (var node : parentNodes)
      result += node.val;
    return result;
  }
}