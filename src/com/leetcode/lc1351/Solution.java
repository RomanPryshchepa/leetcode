package com.leetcode.lc1351;

/*
1351. Count Negative Numbers in a Sorted Matrix

Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.



Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.

Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0



Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 100
    -100 <= grid[i][j] <= 100


Follow up: Could you find an O(n + m) solution?
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.countNegatives(new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}}));
    System.out.println(solution.countNegatives2(new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}}));
    System.out.println(solution.countNegatives(new int[][]{{3, 2}, {1, 0}}));
    System.out.println(solution.countNegatives2(new int[][]{{3, 2}, {1, 0}}));
  }

  public int countNegatives2(int[][] grid) {
    var i = 0;
    var j = grid[i].length - 1;
    var result = 0;
    while(i < grid.length && j >= 0) {
      if (grid[i][j] >= 0)
        result += grid[i++].length - j - 1;
      else if (j > 0)
        j--;
      else
        return result + grid[i].length * (grid.length - i);
    }
    return result;
  }

  public int countNegatives(int[][] grid) {
    var result = 0;
    for (var row : grid) {
      if (GetFirstNegativeIndex(row) != -1) {
        result += (row.length - GetFirstNegativeIndex(row));
      }
    }
    return result;
  }

  private int GetFirstNegativeIndex(int[] arr) {
    if (arr[0] < 0) {
      return 0;
    }
    if (arr[arr.length - 1] >= 0) {
      return -1;
    }
    var start = 0;
    var end = arr.length - 1;
    var mid = 0;
    while (start < end) {
      mid = (start + end) / 2;
      if (arr[mid] >= 0) {
        start = mid + 1;
      } else if (arr[mid - 1] >= 0) {
        return mid;
      } else {
        end = mid - 1;
      }
    }
    return start;
  }

}
