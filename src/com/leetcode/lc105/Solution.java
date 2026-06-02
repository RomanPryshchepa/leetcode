package com.leetcode.lc105;

/*
105. Construct Binary Tree from Preorder and Inorder Traversal

Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.



Example 1:

Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]



Constraints:

    1 <= preorder.length <= 3000
    inorder.length == preorder.length
    -3000 <= preorder[i], inorder[i] <= 3000
    preorder and inorder consist of unique values.
    Each value of inorder also appears in preorder.
    preorder is guaranteed to be the preorder traversal of the tree.
    inorder is guaranteed to be the inorder traversal of the tree.
 */
import com.leetcode.tools.TreeNode;

import java.util.HashMap;
import java.util.Map;

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
    private int[] preArr;
    private final Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        var nodesCnt = preorder.length;
        this.preArr = preorder;

        for (int i = 0; i < nodesCnt; i++)
            map.put(inorder[i], i);

        return dfs(0, 0, nodesCnt);
    }

    private TreeNode dfs(int preIdx, int inIdx, int subSize) {
        if (subSize <= 0)
            return null;

        var rootVal = preArr[preIdx];

        var rootInIdx = map.get(rootVal);

        var leftSubSize = rootInIdx - inIdx;

        var leftChild = dfs(preIdx + 1, inIdx, leftSubSize);

        var rightChild = dfs(preIdx + 1 + leftSubSize,
                rootInIdx + 1,
                subSize - 1 - leftSubSize);

        return new TreeNode(rootVal, leftChild, rightChild);
    }
}