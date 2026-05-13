package com.leetcode.lc104;

/*
104. Maximum Depth of Binary Tree

Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.


Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: 3

Example 2:

Input: root = [1,null,2]
Output: 2



Constraints:

    The number of nodes in the tree is in the range [0, 104].
    -100 <= Node.val <= 100
 */
import com.leetcode.tools.TreeNode;

import java.util.LinkedList;

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
        var root =  new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(solution.maxDepth(root));
        root =  new TreeNode(1, null, new TreeNode(2));
        System.out.println(solution.maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        var result = 0;
        var parents = new LinkedList<TreeNode>();
        var children = new LinkedList<TreeNode>();
        parents.add(root);
        while (!parents.isEmpty()) {
            for (var node : parents) {
                if (node.left != null)
                    children.add(node.left);
                if (node.right != null)
                    children.add(node.right);
            }
            result++;
            parents.clear();
            parents.addAll(children);
            children.clear();
        }
        return result;
    }
}