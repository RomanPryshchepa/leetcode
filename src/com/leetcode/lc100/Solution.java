package com.leetcode.lc100;

/*
100. Same Tree

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.


Example 1:


Input: p = [1,2,3], q = [1,2,3]
Output: true
Example 2:


Input: p = [1,2], q = [1,null,2]
Output: false
Example 3:


Input: p = [1,2,1], q = [1,1,2]
Output: false


Constraints:

The number of nodes in both trees is in the range [0, 100].
-104 <= Node.val <= 104
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
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(solution.isSameTree(p, q));

        p =  new TreeNode(1, new TreeNode(2), null);
        q =  new TreeNode(1, null, new TreeNode(2));
        System.out.println(solution.isSameTree(p, q));

        p = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        q = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        System.out.println(solution.isSameTree(p, q));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        var queueP = new LinkedList<TreeNode>();
        var queueQ = new LinkedList<TreeNode>();
        queueP.add(p);
        queueQ.add(q);
        TreeNode pNode;
        TreeNode qNode;
        while (!queueP.isEmpty() && !queueQ.isEmpty()) {
            pNode = queueP.poll();
            qNode = queueQ.poll();
            if (pNode != null && qNode == null || pNode == null && qNode != null)
                return false;
            if (pNode != null && qNode != null) {
                if (pNode.val != qNode.val)
                    return false;
                queueP.add(pNode.left);
                queueP.add(pNode.right);
                queueQ.add(qNode.left);
                queueQ.add(qNode.right);
            }
        }
        return queueP.isEmpty() && queueQ.isEmpty();
    }
}