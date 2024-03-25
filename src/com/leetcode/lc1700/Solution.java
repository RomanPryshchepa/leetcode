package com.leetcode.lc1700;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/*
1700. Number of Students Unable to Eat Lunch

The school cafeteria offers circular and square sandwiches at lunch break, referred to by numbers 0 and 1 respectively. All students stand in a queue. Each student either prefers square or circular sandwiches.
The number of sandwiches in the cafeteria is equal to the number of students. The sandwiches are placed in a stack. At each step:
    If the student at the front of the queue prefers the sandwich on the top of the stack, they will take it and leave the queue.
    Otherwise, they will leave it and go to the queue's end.
This continues until none of the queue students want to take the top sandwich and are thus unable to eat.
You are given two integer arrays students and sandwiches where sandwiches[i] is the type of the i​​​​​​th sandwich in the stack (i = 0 is the top of the stack) and students[j] is the preference of the j​​​​​​th student in the initial queue (j = 0 is the front of the queue). Return the number of students that are unable to eat.
Example 1:
Input: students = [1,1,0,0], sandwiches = [0,1,0,1]
Output: 0
Explanation:
- Front student leaves the top sandwich and returns to the end of the line making students = [1,0,0,1].
- Front student leaves the top sandwich and returns to the end of the line making students = [0,0,1,1].
- Front student takes the top sandwich and leaves the line making students = [0,1,1] and sandwiches = [1,0,1].
- Front student leaves the top sandwich and returns to the end of the line making students = [1,1,0].
- Front student takes the top sandwich and leaves the line making students = [1,0] and sandwiches = [0,1].
- Front student leaves the top sandwich and returns to the end of the line making students = [0,1].
- Front student takes the top sandwich and leaves the line making students = [1] and sandwiches = [1].
- Front student takes the top sandwich and leaves the line making students = [] and sandwiches = [].
Hence all students are able to eat.
Example 2:
Input: students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
Output: 3
 */
public class Solution {

  public int countStudents(int[] students, int[] sandwiches) {
    Deque<Integer> studentsQueue = new ArrayDeque<>(students.length);
    for (int student : students) {
      studentsQueue.addLast(student);
    }
    int n = 0;
    int sandwichIdx = 0;
    while (sandwichIdx < sandwiches.length && !studentsQueue.isEmpty() && n < studentsQueue.size()) {
      int studentPop = studentsQueue.pop();
      if (studentPop == sandwiches[sandwichIdx]) {
        sandwichIdx++;
        n = 0;
      } else {
        studentsQueue.addLast(studentPop);
        n++;
      }
    }
    return studentsQueue.size();
  }

  public int countStudents1(int[] students, int[] sandwiches) {
    Deque<Integer> studentsQueue = new ArrayDeque<>(students.length);
    for (int student : students) {
      studentsQueue.addLast(student);
    }
    Deque<Integer> sandwichesQueue = new LinkedList<>();
    for (int sandwich : sandwiches) {
      sandwichesQueue.addLast(sandwich);
    }
    int n = 0;
    while (!sandwichesQueue.isEmpty() && !studentsQueue.isEmpty() && n < studentsQueue.size()) {
      int studentPop = studentsQueue.pop();
      if (studentPop == sandwichesQueue.getFirst()) {
        sandwichesQueue.pop();
        n = 0;
      } else {
        studentsQueue.addLast(studentPop);
        n++;
      }
    }
    return studentsQueue.size();
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] students;
    int[] sandwiches;

    students = new int[]{1, 1, 0, 0};
    sandwiches = new int[]{0, 1, 0, 1};
    System.out.println(solution.countStudents(students, sandwiches)); // 0

    students = new int[]{1, 1, 1, 0, 0, 1};
    sandwiches = new int[]{1, 0, 0, 0, 1, 1};
    System.out.println(solution.countStudents(students, sandwiches)); // 3
  }
}
