package com.leetcode.lc133;

import com.leetcode.tools.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
133. Clone Graph

Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of its children.

class Node {
    public int val;
    public List<Node> children;
}



Test case format:

For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.

An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of children of a node in the graph.

The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.



Example 1:

Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
Output: [[2,4],[1,3],[2,4],[1,3]]
Explanation: There are 4 nodes in the graph.
1st node (val = 1)'s children are 2nd node (val = 2) and 4th node (val = 4).
2nd node (val = 2)'s children are 1st node (val = 1) and 3rd node (val = 3).
3rd node (val = 3)'s children are 2nd node (val = 2) and 4th node (val = 4).
4th node (val = 4)'s children are 1st node (val = 1) and 3rd node (val = 3).

Example 2:

Input: adjList = [[]]
Output: [[]]
Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it does not have any children.

Example 3:

Input: adjList = []
Output: []
Explanation: This an empty graph, it does not have any nodes.



Constraints:

    The number of nodes in the graph is in the range [0, 100].
    1 <= Node.val <= 100
    Node.val is unique for each node.
    There are no repeated edges and no self-loops in the graph.
    The Graph is connected and all nodes can be visited starting from the given node.
 */
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;
    public Node() {
        val = 0;
        children = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/
public class Solution {
    private final Map<Node, Node> map = new HashMap<>();

    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.cloneGraph(null));
        System.out.println(solution.cloneGraph2(null));
    }

    public Node cloneGraph(Node node) {
        return dfs(node);
    }

    private Node dfs(Node node) {
        if (node == null)
            return null;
        if (map.containsKey(node))
            return map.get(node);
        Node clone = new Node(node.val);
        map.put(node, clone);
        for (var neighbor : node.children) {
            clone.children.add(dfs(neighbor));
        }
        return clone;
    }

    public Node cloneGraph2(Node node) {
        if (node == null)
            return null;
        var map = new HashMap<Node, Node>();
        var queue = new LinkedList<Node>();
        queue.add(node);
        var qLen = queue.size();
        while (qLen > 0) {
            for (var i = 0; i < qLen; i++) {
                var currNode = queue.pop();
                map.put(currNode, new Node(currNode.val));
                for (var neighbor : currNode.children)
                    if (!map.containsKey(neighbor))
                        queue.add(neighbor);
            }
            qLen = queue.size();
        }
        for (var entry : map.entrySet())
            for (var neighbor : entry.getKey().children)
                entry.getValue().children.add(map.get(neighbor));
        return map.get(node);
    }
}
