package com.leetcode.tools;

public class ListNodeHelper {
  public static ListNode createList(int... elements) {
    ListNode head = null;
    if (elements.length > 0) {
      head = new ListNode(elements[0]);
    }
    ListNode current = head;
    for (int i = 1; i < elements.length; i++) {
      current.next = new ListNode(elements[i]);
      current = current.next;
    }

    return head;
  }

  public static void printList(ListNode head) {
    printList(head, " > ");
  }

  public static void printList(ListNode head, String delimiter) {
    if (head == null) {
      System.out.println();
      return;
    }
    ListNode current = head;
    var delim = "";
    while (current != null) {
      System.out.print(delim + current.val);
      delim = delimiter == null ? "->" : delimiter;
      current = current.next;
    }
    System.out.println();
  }
}
