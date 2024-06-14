package com.leetcode.lc11;


/*
11. Container With Most Water

You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.



Example 1:

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example 2:

Input: height = [1,1]
Output: 1



Constraints:

    n == height.length
    2 <= n <= 105
    0 <= height[i] <= 104

 */
public class Solution {

  public static void main(String[] args) {
    int[] height;
    //Input: height = [1,8,6,2,5,4,8,3,7]
    //Output: 49
    height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
    System.out.println(maxArea(height));

    //Example 2:
    //
    //Input: height = [1,1]
    //Output: 1
    height = new int[]{1, 1};
    System.out.println(maxArea(height));

    //Input : height = [1,3,2,5,25,24,5]
    //Output : 15
    //Expected : 24
    height = new int[]{1, 3, 2, 5, 25, 24, 5};
    System.out.println(maxArea(height));

    //Input : height = [1,2,3,4,5,25,24,3,4]
    //Output : 20
    //Expected : 24
    height = new int[]{1, 2, 3, 4, 5, 25, 24, 3, 4};
    System.out.println(maxArea(height));
  }

  public static int maxArea(int[] height) {
    int i = 0;
    int j = height.length - 1;
    int maxS = (j - i) * Math.min(height[i], height[j]);
    while (i < j) {
      if (height[j] < height[i]) {
        j--;
      } else {
        i++;
      }
      maxS = Math.max(maxS, (j - i) * Math.min(height[i], height[j]));
    }
    return maxS;
  }

  public static int maxArea1(int[] height) {
    int result = 0;
    for (int k = 0; k < height.length - 1; k++) {
      int i = k;
      int j = height.length - 1;
      int maxS = (j - i) * Math.min(height[i], height[j]);
//    while (i < height.length - 1 && j > 0) {
      while (i < j) {
        int s1 = ((j - 1) - i) * Math.min(height[j - 1], height[i]);
        int s2 = (j - (i + 1)) * Math.min(height[i + 1], height[j]);
        if (s1 > s2) {
          j--;
          maxS = Math.max(s1, maxS);
        } else {
          i++;
          maxS = Math.max(s2, maxS);
        }
      }
      result = Math.max(result, maxS);
    }
    return result;
  }
}
