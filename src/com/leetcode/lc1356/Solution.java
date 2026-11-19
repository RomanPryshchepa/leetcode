package com.leetcode.lc1356;

import java.util.Arrays;

/*
1356. Sort Integers by The Number of 1 Bits

You are given an integer array arr. Sort the integers in the array in ascending order by the number of 1's in their binary representation and in case of two or more integers have the same number of 1's you have to sort them in ascending order.

Return the array after sorting it.



Example 1:

Input: arr = [0,1,2,3,4,5,6,7,8]
Output: [0,1,2,4,8,3,5,6,7]
Explantion: [0] is the only integer with 0 bits.
[1,2,4,8] all have 1 bit.
[3,5,6] have 2 bits.
[7] has 3 bits.
The sorted array by bits is [0,1,2,4,8,3,5,6,7]

Example 2:

Input: arr = [1024,512,256,128,64,32,16,8,4,2,1]
Output: [1,2,4,8,16,32,64,128,256,512,1024]
Explantion: All integers have 1 bit in the binary representation, you should just sort them in ascending order.



Constraints:

    1 <= arr.length <= 500
    0 <= arr[i] <= 104
 */
public class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(Arrays.toString(solution.sortByBits(new int[]{0,1,2,3,4,5,6,7,8})));
        System.out.println(Arrays.toString(solution.sortByBits(new int[]{1024,512,256,128,64,32,16,8,4,2,1})));
    }

    public int[] sortByBits(int[] arr) {
        var pairs = new int[arr.length][2];
        for (var i = 0; i < arr.length; i++)
            pairs[i] = new int[] { arr[i], Integer.bitCount(arr[i]) };
        Arrays.sort(pairs, (a, b) -> a[1] - b[1] != 0 ? a[1] - b[1] : a[0] - b[0]);
        var result = new int[arr.length];
        for (var i = 0; i < arr.length; i++)
            result[i] = pairs[i][0];
        return result;
    }
}
