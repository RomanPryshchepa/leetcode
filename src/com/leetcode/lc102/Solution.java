package com.leetcode.lc102;
/*
102. Binary Tree Level Order Traversal

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).



Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:

Input: root = [1]
Output: [[1]]

Example 3:

Input: root = []
Output: []



Constraints:

    The number of nodes in the tree is in the range [0, 2000].
    -1000 <= Node.val <= 1000
 */

import com.leetcode.tools.TreeNode;

import java.util.LinkedList;
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
    public static void main(String[] args) {
        var solution = new Solution();
        var root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(solution.levelOrder(root));

        root =  new TreeNode(1);
        System.out.println(solution.levelOrder(root));

        root = null;
        System.out.println(solution.levelOrder(root));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        var result = new LinkedList<List<Integer>>();
        if (root == null)
            return result;
        var parents = new LinkedList<TreeNode>();
        var children = new LinkedList<TreeNode>();
        parents.add(root);
        LinkedList<Integer> nodeList;
        while (!parents.isEmpty()) {
            nodeList = new LinkedList<>();
            for (var node : parents) {
                nodeList.add(node.val);
                if (node.left != null)
                    children.add(node.left);
                if (node.right != null)
                    children.add(node.right);
            }
            result.add(nodeList);
            parents.clear();
            parents.addAll(children);
            children.clear();
        }
        return result;
    }
}