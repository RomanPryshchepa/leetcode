package com.leetcode.lc3242;

import java.util.HashMap;
import java.util.Map;

/**
 * Your NeighborSum object will be instantiated and called as such: NeighborSum obj = new
 * NeighborSum(grid); int param_1 = obj.adjacentSum(value); int param_2 = obj.diagonalSum(value);
 */
class NeighborSum {

  private final Map<Integer, Integer> valuesWithIndexes;
  private final int[][] gridCopy;
  private final int[][] adjacentNeighbors;
  private final int[][] diagonalNeighbors;
  private final int gridLength;

  public NeighborSum(int[][] grid) {
    gridCopy = grid.clone();
    gridLength = grid.length;
    adjacentNeighbors = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    diagonalNeighbors = new int[][]{{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    valuesWithIndexes = new HashMap<>();
    for (int i = 0; i < gridLength; i++) {
      for (int j = 0; j < gridLength; j++) {
        valuesWithIndexes.put(grid[i][j], i * 100 + j);
      }
    }
  }

  public int adjacentSum(int value) {
    return sum(value, adjacentNeighbors);
  }

  public int diagonalSum(int value) {
    return sum(value, diagonalNeighbors);
  }

  private int sum(int value, int[][] neighbors) {
    var sum = 0;
    var valueI = valuesWithIndexes.getOrDefault(value, 0) / 100;
    var valueJ = valuesWithIndexes.getOrDefault(value, 0) % 100;
    var neighborI = 0;
    var neighborJ = 0;
    for (int[] neighbor : neighbors) {
      neighborI = valueI + neighbor[0];
      neighborJ = valueJ + neighbor[1];
      if (neighborI >= 0 && neighborI < gridLength && neighborJ >= 0 && neighborJ < gridLength) {
        sum += gridCopy[neighborI][neighborJ];
      }
    }
    return sum;
  }
}