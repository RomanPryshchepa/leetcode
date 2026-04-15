package com.leetcode.lc278;

/*
278. First Bad Version

You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.



Example 1:

Input: n = 5, bad = 4
Output: 4
Explanation:
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.

Example 2:

Input: n = 1, bad = 1
Output: 1



Constraints:

    1 <= bad <= n <= 231 - 1
 */

/** The isBadVersion API is defined in the parent class VersionControl.
 *  boolean isBadVersion(int version);
 */

public class Solution extends VersionControl {
    public static void main(String[] args) {
        var  solution = new Solution();

        solution.setFirstBadVersion(4);
        System.out.println(solution.firstBadVersion(5));
        System.out.println();

        solution.setFirstBadVersion(1);
        System.out.println(solution.firstBadVersion(1));
    }

    public int firstBadVersion(int n) {
        if (n == 1 || isBadVersion(1))
            return 1;
        var start = 1;
        var end = n;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (isBadVersion(mid)) {
                if (!isBadVersion(mid - 1)) {
                    return mid;
                }
                end = mid - 1;
            }  else {
                start = mid + 1;
            }
        }
        return -1;
    }
}