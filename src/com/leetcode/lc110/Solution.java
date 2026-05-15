package com.leetcode.lc110;

/*
110. Balanced Binary Tree

Given a binary tree, determine if it is .



Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: true

Example 2:

Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Example 3:

Input: root = []
Output: true



Constraints:

    The number of nodes in the tree is in the range [0, 5000].
    -104 <= Node.val <= 104
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
        var solution = new Solution();
        var root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(solution.isBalanced(root));

        root = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3)), new TreeNode(2));
        System.out.println(solution.isBalanced(root));

        System.out.println(solution.isBalanced(null));
    }

    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode root) {
        if (root == null)
            return 0;
        var lHeight = height(root.left);
        var rHeight = height(root.right);
        if (lHeight == -1 || rHeight == -1 || Math.abs(lHeight - rHeight) > 1)
            return -1;
        return 1 + Math.max(lHeight, rHeight);
    }
}