package com.leetcode.lc222;

/*
222. Count Complete Tree Nodes

Given the root of a complete binary tree, return the number of the nodes in the tree.

According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Design an algorithm that runs in less than O(n) time complexity.



Example 1:

Input: root = [1,2,3,4,5,6]
Output: 6

Example 2:

Input: root = []
Output: 0

Example 3:

Input: root = [1]
Output: 1



Constraints:

    The number of nodes in the tree is in the range [0, 5 * 104].
    0 <= Node.val <= 5 * 104
    The tree is guaranteed to be complete.
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
        var solution = new Solution();

        var root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
        System.out.println(solution.countNodes(root));
        System.out.println(solution.countNodes(null));
        root = new TreeNode(1);
        System.out.println(solution.countNodes(root));
    }

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null)
            return 1;
        TreeNode count = new TreeNode(0);
        countNodes(root, count);
        return count.val;
    }

    private void countNodes(TreeNode root, TreeNode count) {
        count.val++;
        if (root.right != null) {
            countNodes(root.right, count);
            countNodes(root.left, count);
        }
        else if (root.left != null) {
            countNodes(root.left, count);
        }
    }
}
