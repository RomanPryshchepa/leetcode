package com.leetcode.lc121;

/*
121. Best Time to Buy and Sell Stock

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.



Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.



Constraints:

    1 <= prices.length <= 105
    0 <= prices[i] <= 104


 */
public class Solution {

  public static void main(String[] args) {
    int[] prices;
    //Example 1:
    //
    //Input: prices = [7,1,5,3,6,4]
    //Output: 5
    //Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    //Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
    prices = new int[]{7, 1, 5, 3, 6, 4};
    System.out.println(maxProfit(prices));

    //Example 2:
    //
    //Input: prices = [7,6,4,3,1]
    //Output: 0
    //Explanation: In this case, no transactions are done and the max profit = 0.
    prices = new int[]{7, 6, 4, 3, 1};
    System.out.println(maxProfit(prices));

    //Example 3:
    //
    //Input: prices = [3,4]
    //Output: 1
    //Explanation: In this case, no transactions are done and the max profit = 0.
    prices = new int[]{3, 4};
    System.out.println(maxProfit(prices));

    //Example 4:
    //
    //Input: prices = [4,3]
    //Output: 0
    //Explanation: In this case, no transactions are done and the max profit = 0.
    prices = new int[]{4, 3};
    System.out.println(maxProfit(prices));

    //Example 2:
    //
    //Input: prices = [7,6,4,3,1]
    //Output: 6
    //Explanation: In this case, no transactions are done and the max profit = 0.
    prices = new int[]{1, 3, 4, 6, 7};
    System.out.println(maxProfit(prices));
  }

  public static int maxProfit(int[] prices) {
    int result = 0;
    int min = prices[0];
    int max = prices[0];
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] < min) {
        min = prices[i];
        max = prices[i];
      } else if (prices[i] > max) {
        max = prices[i];
        result = Math.max(result, max - min);
      }
    }
    return result;
  }

  public static int maxProfit1(int[] prices) {
    int result = 0;
    int min = prices[0];
    int max = prices[0];
    boolean up = false;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i - 1] < prices[i]) {
        max = Math.max(max, prices[i]);
        up = true;
      } else if (prices[i - 1] > prices[i]) {
        if (up) {
          result = Math.max(result, max - min);
        }
        up = false;
        min = Math.min(min, prices[i]);
      }
    }

    return result;
  }
}
