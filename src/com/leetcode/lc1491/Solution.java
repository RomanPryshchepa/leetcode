package com.leetcode.lc1491;

/*
1491. Average Salary Excluding the Minimum and Maximum Salary

You are given an array of unique integers salary where salary[i] is the salary of the ith employee.

Return the average salary of employees excluding the minimum and maximum salary. Answers within 10-5 of the actual answer will be accepted.



Example 1:

Input: salary = [4000,3000,1000,2000]
Output: 2500.00000
Explanation: Minimum salary and maximum salary are 1000 and 4000 respectively.
Average salary excluding minimum and maximum salary is (2000+3000) / 2 = 2500

Example 2:

Input: salary = [1000,2000,3000]
Output: 2000.00000
Explanation: Minimum salary and maximum salary are 1000 and 3000 respectively.
Average salary excluding minimum and maximum salary is (2000) / 1 = 2000



Constraints:

    3 <= salary.length <= 100
    1000 <= salary[i] <= 106
    All the integers of salary are unique.
 */
public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] salary;

    salary = new int[]{4000, 3000, 1000, 2000};
    System.out.println(solution.average(salary)); // 2500.0000

    salary = new int[]{1000, 2000, 3000};
    System.out.println(solution.average(salary)); // 2000.0000

    salary = new int[]{1000, 2001, 2002, 3000};
    System.out.println(solution.average(salary)); // 2001.5000
  }

  public double average(int[] salary) {
    int sum = salary[0];
    int min = salary[0];
    int max = salary[0];
    for (int i = 1; i < salary.length; i++) {
      if (salary[i] < min) {
        min = salary[i];
      }
      if (salary[i] > max) {
        max = salary[i];
      }
      sum += salary[i];
    }
    return (sum - min - max) * 1.0 / (salary.length - 2);
  }
}
