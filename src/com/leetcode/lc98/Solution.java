package com.leetcode.lc98;

/*
98. Validate Binary Search Tree

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

    The left of a node contains only nodes with keys strictly less than the node's key.
    The right subtree of a node contains only nodes with keys strictly greater than the node's key.
    Both the left and right subtrees must also be binary search trees.



Example 1:

Input: root = [2,1,3]
Output: true

Example 2:

Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.



Constraints:

    The number of nodes in the tree is in the range [1, 104].
    -231 <= Node.val <= 231 - 1
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
    public static void main(String[] args) {
        var solution = new Solution();
        var root = new TreeNode(2, new TreeNode(1),  new TreeNode(3));
        System.out.println(solution.isValidBST(root));

        root = new TreeNode(5, new TreeNode(1), new TreeNode(4,  new TreeNode(3), new TreeNode(6)));
        System.out.println(solution.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        var values = new ArrayList<Integer>();
        DFS(root, values);
        for (var i = 1; i < values.size(); i++)
            if (values.get(i) <= values.get(i - 1))
                return false;
        return true;
    }

    private void DFS(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        DFS(root.left, list);
        list.add(root.val);
        DFS(root.right, list);
    }
}