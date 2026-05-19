package com.leetcode.lc235;

/*
235. Lowest Common Ancestor of a Binary Search Tree

Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”



Example 1:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

Example 2:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

Example 3:

Input: root = [2,1], p = 2, q = 1
Output: 2



Constraints:

    The number of nodes in the tree is in the range [2, 105].
    -109 <= Node.val <= 109
    All Node.val are unique.
    p != q
    p and q will exist in the BST.
 */

import com.leetcode.tools.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        var root = new TreeNode(6, new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))),  new TreeNode(8, new TreeNode(7),  new TreeNode(9)));
        var p = new TreeNode(2);
        var q = new TreeNode(8);
        System.out.println(solution.lowestCommonAncestor(root, p, q).val);

        root = new TreeNode(6, new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))),  new TreeNode(8, new TreeNode(7),  new TreeNode(9)));
        p = new TreeNode(2);
        q = new TreeNode(4);
        System.out.println(solution.lowestCommonAncestor(root, p, q).val);

        root = new TreeNode(2, new TreeNode(1), null);
        p = new TreeNode(2);
        q = new TreeNode(1);
        System.out.println(solution.lowestCommonAncestor(root, p, q).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        var curr = root;
        var min = Math.min(p.val, q.val);
        var max = Math.max(p.val, q.val);
        while (!(min <= curr.val && curr.val <= max)) {
            if (max < curr.val)
                curr = curr.left;
            if (min > curr.val)
                curr = curr.right;
        }
        return curr;
    }
}