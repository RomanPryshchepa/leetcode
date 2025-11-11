package com.leetcode.lc587;

import java.util.Arrays;

/*
587. Erect the Fence

You are given an array trees where trees[i] = [xi, yi] represents the location of a tree in the garden.

Fence the entire garden using the minimum length of rope, as it is expensive. The garden is well-fenced only if all the trees are enclosed.

Return the coordinates of trees that are exactly located on the fence perimeter. You may return the answer in any order.



Example 1:

Input: trees = [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
Output: [[1,1],[2,0],[4,2],[3,3],[2,4]]
Explanation: All the trees will be on the perimeter of the fence except the tree at [2, 2], which will be inside the fence.

Example 2:

Input: trees = [[1,2],[2,2],[4,2]]
Output: [[4,2],[2,2],[1,2]]
Explanation: The fence forms a line that passes through all the trees.



Constraints:

    1 <= trees.length <= 3000
    trees[i].length == 2
    0 <= xi, yi <= 100
    All the given positions are unique.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(Arrays.deepToString(solution.outerTrees(new int[][]{{1, 1}, {2, 2}, {2, 0}, {2, 4}, {3, 3}, {4, 2}})));
    System.out.println(Arrays.deepToString(solution.outerTrees(new int[][]{{1, 2}, {2, 2}, {4, 2}})));
  }

  public int[][] outerTrees(int[][] trees) {
    if (trees.length < 4) {
      return trees;
    }
    Arrays.sort(trees, (tree1, tree2) -> tree1[0] == tree2[0] ? tree1[1] - tree2[1] : tree1[0] - tree2[0]);
    boolean[] visited = new boolean[trees.length];
    int[] stack = new int[trees.length + 10];
    int stackSize = 1;
    for (int i = 1; i < trees.length; i++) {
      while (stackSize > 1 && crossProduct(trees[stack[stackSize - 1]], trees[stack[stackSize - 2]], trees[i]) < 0) {
        visited[stack[--stackSize]] = false;
      }
      visited[i] = true;
      stack[stackSize++] = i;
    }
    int size = stackSize;
    for (int i = trees.length - 1; i >= 0; i--) {
      if (visited[i]) {
        continue;
      }
      while (stackSize > size && crossProduct(trees[stack[stackSize - 1]], trees[stack[stackSize - 2]], trees[i]) < 0) {
        stackSize--;
      }
      stack[stackSize++] = i;
    }
    int[][] result = new int[stackSize - 1][2];
    for (int i = 0; i < result.length; ++i) {
      result[i] = trees[stack[i]];
    }
    return result;
  }

  private int crossProduct(int[] a, int[] b, int[] c) {
    return (b[0] - a[0]) * (c[1] - b[1]) - (b[1] - a[1]) * (c[0] - b[0]);
  }
}
