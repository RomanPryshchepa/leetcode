package com.leetcode.lc1980;

import java.util.Collections;
import java.util.HashSet;

/*
1980. Find Unique Binary String

Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length n that does not appear in nums. If there are multiple answers, you may return any of them.



Example 1:

Input: nums = ["01","10"]
Output: "11"
Explanation: "11" does not appear in nums. "00" would also be correct.

Example 2:

Input: nums = ["00","01"]
Output: "11"
Explanation: "11" does not appear in nums. "10" would also be correct.

Example 3:

Input: nums = ["111","011","001"]
Output: "101"
Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.



Constraints:

    n == nums.length
    1 <= n <= 16
    nums[i].length == n
    nums[i] is either '0' or '1'.
    All the strings of nums are unique.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findDifferentBinaryString(new String[]{"01", "10"}));
        System.out.println(solution.findDifferentBinaryString(new String[]{"00", "01"}));
        System.out.println(solution.findDifferentBinaryString(new String[]{"111", "011", "001"}));
    }

    public String findDifferentBinaryString(String[] nums) {
        var set = new HashSet<String>();
        Collections.addAll(set, nums);
        for (int i = (int) Math.pow(2, nums.length - 1); i < Math.pow(2, nums.length); i++) {
            if (!set.contains(Integer.toBinaryString(i)))
                return Integer.toBinaryString(i);
        }
        var binary = "";
        for (int i = 0; i < Math.pow(2, nums.length - 1); i++) {
            binary = addZeros(Integer.toBinaryString(i), nums.length);
            if (!set.contains(binary))
                return binary;
        }
        return "";

    }

    private String addZeros(String str, int len) {
        return "0".repeat(Math.max(0, len - str.length())) + str;
    }
}
