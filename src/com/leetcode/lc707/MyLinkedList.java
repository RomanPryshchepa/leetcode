package com.leetcode.lc707;


public class MyLinkedList {

  private Node root;
  private int size;

  public MyLinkedList() {

  }

  public int get(int index) {
    Node current = root;
    if (index >= size) {
      return -1;
    }
    while (index > 0) {
      current = current.next;
      index--;
    }
    return current.val;
  }

  public void addAtHead(int val) {
    root = new Node(val, root);
    size++;
  }

  public void addAtTail(int val) {
    if (root == null) {
      root = new Node(val);
      size++;
      return;
    }
    Node current = root;
    while (current.next != null) {
      current = current.next;
    }
    current.next = new Node(val);
    size++;
  }

  public void addAtIndex(int index, int val) {
    if (index == 0) {
      root = new Node(val, root);
      size++;
      return;
    }
    if (index > size) {
      return;
    }
    if (index == size) {
      addAtTail(val);
      return;
    }
    Node current = root;
    Node prev = current;
    while (index > 0) {
      prev = current;
      current = current.next;
      index--;
    }
    prev.next = new Node(val, prev.next);
    size++;
  }

  public void deleteAtIndex(int index) {
    if (index >= size) {
      return;
    }
    if (index == 0) {
      root = root.next;
      size--;
      return;
    }

    Node current = root;
    Node prev = current;
    while (index > 0) {
      prev = current;
      current = current.next;
      index--;
    }
    prev.next = prev.next.next;
    size--;
  }

  class Node {

    int val;

    Node next;

    Node(int val) {
      this.val = val;
    }

    Node(int val, Node next) {
      this.val = val;
      this.next = next;
    }

  }

  public void print() {
    Node current = root;
    String delim = "";
    while (current != null) {
      System.out.print(delim + current.val);
      delim = " -> ";
      current = current.next;
    }
    System.out.println();
  }
}
