package com.leetcode.lc637;

import com.leetcode.tools.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
637. Average of Levels in Binary Tree

Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [3.00000,14.50000,11.00000]
Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
Hence return [3, 14.5, 11].

Example 2:

Input: root = [3,9,20,15,7]
Output: [3.00000,14.50000,11.00000]



Constraints:

    The number of nodes in the tree is in the range [1, 104].
    -231 <= Node.val <= 231 - 1
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

  public static void main(String[] args) {

  }

  public List<Double> averageOfLevels(TreeNode root) {
    var result = new ArrayList<Double>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    long sum = 0;
    int cnt = 0;
    int size;
    TreeNode node;
    while (!queue.isEmpty()) {
      size = queue.size();
      for (int i = 0; i < size; i++) {
        node = queue.poll();
        sum += node.val;
        cnt++;
        if (node.left != null)
          queue.add(node.left);
        if (node.right != null)
          queue.add(node.right);
      }
      result.add(sum * 1.0/cnt);
      sum = 0;
      cnt = 0;
    }
    return result;
  }
}