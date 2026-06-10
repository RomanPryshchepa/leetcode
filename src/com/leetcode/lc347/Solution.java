package com.leetcode.lc347;

import com.leetcode.tools.Pair;

import java.util.*;

/*
347. Top K Frequent Elements

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.



Example 1:

Input: nums = [1,1,1,2,2,3], k = 2

Output: [1,2]

Example 2:

Input: nums = [1], k = 1

Output: [1]

Example 3:

Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2

Output: [1,2]



Constraints:

    1 <= nums.length <= 105
    -104 <= nums[i] <= 104
    k is in the range [1, the number of unique elements in the array].
    It is guaranteed that the answer is unique.



Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class Solution {
    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1,1,1,2,2,3}, 2)));
        System.out.println(Arrays.toString(solution.topKFrequent2(new int[]{1,1,1,2,2,3}, 2)));
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1}, 1)));
        System.out.println(Arrays.toString(solution.topKFrequent2(new int[]{1}, 1)));
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1,2,1,2,1,2,3,1,3,2}, 2)));
        System.out.println(Arrays.toString(solution.topKFrequent2(new int[]{1,2,1,2,1,2,3,1,3,2}, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }

        List<Integer> values = new ArrayList<>(map.values());
        values.sort(Comparator.reverseOrder());

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() != null && entry.getValue().equals(values.get(i))) {
                    res[i] = entry.getKey();
                    map.put(entry.getKey(), null);
                    break;
                }
            }
        }
        return res;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        for (var num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }
        var queue = new PriorityQueue<Pair<Integer, Integer>>(map.size(), (a, b) -> b.secondItem() - a.secondItem());
        for (var key : map.keySet())
            queue.add(new Pair<>(key, map.get(key)));
        var res = new int[k];
        var i = 0;
        while (k-- > 0)
            res[i++] = queue.poll().firstItem();
        return res;
    }
}
