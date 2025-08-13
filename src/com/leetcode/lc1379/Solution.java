package com.leetcode.lc1379;

/*
1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree

Given two binary trees original and cloned and given a reference to a node target in the original tree.

The cloned tree is a copy of the original tree.

Return a reference to the same node in the cloned tree.

Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.



Example 1:

Input: tree = [7,4,3,null,null,6,19], target = 3
Output: 3
Explanation: In all examples the original and cloned trees are shown. The target node is a green node from the original tree. The answer is the yellow node from the cloned tree.

Example 2:

Input: tree = [7], target =  7
Output: 7

Example 3:

Input: tree = [8,null,6,null,5,null,4,null,3,null,2,null,1], target = 4
Output: 4



Constraints:

    The number of nodes in the tree is in the range [1, 104].
    The values of the nodes of the tree are unique.
    target node is a node from the original tree and is not null.



Follow up: Could you solve the problem if repeated values on the tree are allowed?
 */

import com.leetcode.tools.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    TreeNode original = new TreeNode(7, new TreeNode(4), new TreeNode(3, new TreeNode(6), new TreeNode(19)));
    TreeNode cloned = new TreeNode(7, new TreeNode(4), new TreeNode(3, new TreeNode(6), new TreeNode(19)));
    TreeNode target = new TreeNode(3);
    System.out.println(solution.getTargetCopy(original, cloned, target).val);
    original = new TreeNode(7);
    cloned = new TreeNode(7);
    target = new TreeNode(7);
    System.out.println(solution.getTargetCopy(original, cloned, target).val);
    original = new TreeNode(8, null, new TreeNode(6, null, new TreeNode(5, null, new TreeNode(4, null, new TreeNode(3, null, new TreeNode(2, null, new TreeNode(1)))))));
    cloned = new TreeNode(8, null, new TreeNode(6, null, new TreeNode(5, null, new TreeNode(4, null, new TreeNode(3, null, new TreeNode(2, null, new TreeNode(1)))))));
    target = new TreeNode(4);
    System.out.println(solution.getTargetCopy(original, cloned, target).val);
  }

  public TreeNode getTargetCopy(TreeNode original, TreeNode cloned, TreeNode target) {
    if (original == null)
      return null;
    else if (original.val == target.val)
      return cloned;
    var left = getTargetCopy(original.left, cloned.left, target);
    if (left != null)
      return left;
    else
      return getTargetCopy(original.right, cloned.right, target);
  }
}
