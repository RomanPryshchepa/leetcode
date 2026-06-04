package com.leetcode.lc703;

import java.util.ArrayList;
import java.util.List;

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
class KthLargest2 {
    private final List<Integer> storage = new ArrayList<>();
    private final int k;

    public KthLargest2(int k, int[] nums) {
        this.k = k;
        for (var val : nums)
            storage.add(insertPos(val), val);
    }

    public int add(int val) {
        storage.add(insertPos(val), val);
        return storage.get(storage.size() - k);
    }

    private int insertPos(int val) {
        var start = 0;
        var end = storage.size() - 1;
        var mid = start + (end - start) / 2;
        while (start <= end) {
            if (storage.get(mid) == val)
                return mid;
            else if (storage.get(mid) < val)
                start = mid + 1;
            else
                end = mid - 1;
            mid = start + (end - start) / 2;
        }
        return start;
    }
}