package com.leetcode.lc199;

/*
199. Binary Tree Right Side View

Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.



Example 1:

Input: root = [1,2,3,null,5,null,4]

Output: [1,3,4]

Explanation:

Example 2:

Input: root = [1,2,3,4,null,null,null,5]

Output: [1,3,4,5]

Explanation:

Example 3:

Input: root = [1,null,3]

Output: [1,3]

Example 4:

Input: root = []

Output: []



Constraints:

    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100
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
        var root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)),  new TreeNode(3,  null, new TreeNode(4)));
        System.out.println(solution.rightSideView(root));

        root = new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(5), null), null), new TreeNode(3));
        System.out.println(solution.rightSideView(root));

        root = new TreeNode(1, null, new TreeNode(3));
        System.out.println(solution.rightSideView(root));

        System.out.println(solution.rightSideView(null));
    }

    public List<Integer> rightSideView(TreeNode root) {
        var result = new LinkedList<Integer>();
        if (root == null)
            return result;
        var parents = new LinkedList<TreeNode>();
        var children = new LinkedList<TreeNode>();
        parents.add(root);
        while (!parents.isEmpty()) {
            result.add(parents.getLast().val);
            for (var node : parents) {
                if (node.left != null)
                    children.add(node.left);
                if (node.right != null)
                    children.add(node.right);
            }
            parents.clear();
            parents.addAll(children);
            children.clear();
        }
        return result;
    }
}