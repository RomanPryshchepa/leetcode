package com.leetcode.lc1436;

import java.util.HashSet;
import java.util.List;

/*
1436. Destination City

You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.

It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.



Example 1:

Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
Output: "Sao Paulo"
Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city. Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".

Example 2:

Input: paths = [["B","C"],["D","B"],["C","A"]]
Output: "A"
Explanation: All possible trips are:
"D" -> "B" -> "C" -> "A".
"B" -> "C" -> "A".
"C" -> "A".
"A".
Clearly the destination city is "A".

Example 3:

Input: paths = [["A","Z"]]
Output: "Z"



Constraints:

    1 <= paths.length <= 100
    paths[i].length == 2
    1 <= cityAi.length, cityBi.length <= 10
    cityAi != cityBi
    All strings consist of lowercase and uppercase English letters and the space character.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.destCity(List.of(List.of("London","New York"), List.of("New York","Lima"), List.of("Lima","Sao Paulo"))));
        System.out.println(solution.destCity2(List.of(List.of("London","New York"), List.of("New York","Lima"), List.of("Lima","Sao Paulo"))));
        System.out.println(solution.destCity(List.of(List.of("B","C"), List.of("D","B"), List.of("C","A"))));
        System.out.println(solution.destCity2(List.of(List.of("B","C"), List.of("D","B"), List.of("C","A"))));
        System.out.println(solution.destCity(List.of(List.of("A","Z"))));
        System.out.println(solution.destCity2(List.of(List.of("A","Z"))));
    }

    public String destCity(List<List<String>> paths) {
        var beginning = new HashSet<String>();
        var destination = new HashSet<String>();
        for (List<String> path : paths) {
            beginning.add(path.getFirst());
            destination.add(path.getLast());
        }
        for (String dest : destination)
            if (!beginning.contains(dest))
                return dest;
        return "";
    }

    public String destCity2(List<List<String>> paths) {
        var destination = paths.getFirst().getLast();
        if (paths.size() > 1) {
            var isChanged = true;
            while (isChanged) {
                isChanged = false;
                for (List<String> path : paths) {
                    if (path.getFirst().equals(destination)) {
                        destination = path.getLast();
                        isChanged = true;
                    }
                }
            }
        }
        return destination;
    }
}
