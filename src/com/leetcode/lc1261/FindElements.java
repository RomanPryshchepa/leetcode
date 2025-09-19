package com.leetcode.lc1261;

import com.leetcode.tools.Pair;
import com.leetcode.tools.TreeNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
class FindElements {

  private final Set<Integer> setOfValues = new HashSet<>();

  public FindElements(TreeNode root) {
    if (root == null) {
      return;
    }
    var listParents = new ArrayList<Pair<TreeNode, Integer>>();
    var listChildren = new ArrayList<Pair<TreeNode, Integer>>();
    listParents.add(new Pair<>(root, 0));
    setOfValues.add(0);
    while (!listParents.isEmpty()) {
      for (var parent : listParents) {
        if (parent.firstItem().left != null) {
          listChildren.add(new Pair<>(parent.firstItem().left, 2 * parent.secondItem() + 1));
          setOfValues.add(2 * parent.secondItem() + 1);
        }
        if (parent.firstItem().right != null) {
          listChildren.add(new Pair<>(parent.firstItem().right, 2 * parent.secondItem() + 2));
          setOfValues.add(2 * parent.secondItem() + 2);
        }
      }
      listParents = listChildren;
      listChildren = new ArrayList<>();
    }
  }

  public boolean find(int target) {
    return setOfValues.contains(target);
  }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
