package com.leetcode.lc1038;

/*
1038. Binary Search Tree to Greater Sum Tree

Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in BST.

As a reminder, a binary search tree is a tree that satisfies these constraints:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.



Example 1:

Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]

Example 2:

Input: root = [0,null,1]
Output: [1,null,1]



Constraints:

    The number of nodes in the tree is in the range [1, 100].
    0 <= Node.val <= 100
    All the values in the tree are unique.



Note: This question is the same as 538: https://leetcode.com/problems/convert-bst-to-greater-tree/

 */
import com.leetcode.tools.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

  public static void main(String[] args) {
    Solution solution = new Solution();
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(1, new TreeNode(0), new TreeNode(2, null, new TreeNode(3)));
    root.right = new TreeNode(6, new TreeNode(5), new TreeNode(7, null, new TreeNode(8)));
    root = new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4));
    var list = new ArrayList<Integer>();
    solution.addToListInOrder(root, list);
    System.out.println(list);

    root = solution.bstToGst(root);
    list.clear();
    solution.addToListInOrder(root, list);
    System.out.println(list);
  }

  public TreeNode bstToGst(TreeNode root) {
    if (root == null || (root.left == null && root.right == null))
      return root;
    var list = new ArrayList<Integer>();
    addToListInOrder(root, list);
    var map = new HashMap<Integer, Integer>();
    map.put(list.get(list.size() - 1), list.get(list.size() - 1));
    for (var i = list.size() - 2; i >= 0; i--) {
      map.put(list.get(i), map.get(list.get(i + 1)) + list.get(i));
    }
    setFromListInOrder(root, map);
    return root;
  }

  private void setFromListInOrder(TreeNode root, Map<Integer, Integer> map) {
    if (root == null)
      return;
    setFromListInOrder(root.left, map);
    root.val = map.get(root.val);
    setFromListInOrder(root.right, map);
  }

  private void addToListInOrder(TreeNode root, List<Integer> list)
  {
    if (root == null)
      return;
    addToListInOrder(root.left, list);
    list.add(root.val);
    addToListInOrder(root.right, list);
  }
}