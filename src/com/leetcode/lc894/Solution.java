package com.leetcode.lc894;

import com.leetcode.tools.TreeNode;
import java.util.ArrayList;
import java.util.List;

/*
894. All Possible Full Binary Trees

Given an integer n, return a list of all possible full binary trees with n nodes. Each node of each tree in the answer must have Node.val == 0.

Each element of the answer is the root node of one possible tree. You may return the final list of trees in any order.

A full binary tree is a binary tree where each node has exactly 0 or 2 children.



Example 1:

Input: n = 7
Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]

Example 2:

Input: n = 3
Output: [[0,0,0]]



Constraints:

    1 <= n <= 20
 */

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
  private List<TreeNode>[] cache;

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.allPossibleFBT(7));
    System.out.println(solution.allPossibleFBT(3));
  }

  public List<TreeNode> allPossibleFBT(int n) {
    cache = new List[n + 1];
    return getTree(n);
  }

  private List<TreeNode> getTree(int n) {
    if (cache[n] != null) {
      return cache[n];
    }

    if (n == 1) {
      return new ArrayList<>(List.of(new TreeNode(0)));
    }

    List<TreeNode> res = new ArrayList<>();
    for (int i = 0; i < n - 1; i++) {
      var j = n - 1 - i;
      var leftTrees = getTree(i);
      var rightTrees = getTree(j);
      for (TreeNode leftTree : leftTrees) {
        for (TreeNode rightTree : rightTrees) {
          res.add(new TreeNode(0, leftTree, rightTree));
        }
      }
    }
    cache[n] = res;
    return res;
  }
}