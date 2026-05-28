package com.leetcode.lc572;

/*
572. Subtree of Another Tree

Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.


Example 1:


Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true
Example 2:


Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false


Constraints:

The number of nodes in the root tree is in the range [1, 2000].
The number of nodes in the subRoot tree is in the range [1, 1000].
-104 <= root.val <= 104
-104 <= subRoot.val <= 104
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
        var root = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5));
        var subRoot = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        System.out.println(solution.isSubtree(root, subRoot));

        root = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2, new TreeNode(0), null)), new TreeNode(5));
        subRoot = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        System.out.println(solution.isSubtree(root, subRoot));
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (isSameTree(root, subRoot))
            return true;
        var queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode node;
        while (!queue.isEmpty()){
            node = queue.poll();
            if (node.left != null) {
                if (isSameTree(node.left, subRoot))
                    return true;
                queue.add(node.left);
            }
            if (node.right != null) {
                if (isSameTree(node.right, subRoot))
                    return true;
                queue.add(node.right);
            }
        }
        return false;
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        return p == null && q == null || (p != null && q != null && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
}
