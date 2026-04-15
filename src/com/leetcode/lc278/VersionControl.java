package com.leetcode.lc278;

public class VersionControl {
    private int firstBadVersion;

    public void setFirstBadVersion(int firstBadVersion) {
        this.firstBadVersion = firstBadVersion;
    }

    public boolean isBadVersion(int version) {
        return version >= firstBadVersion;
    }
}
