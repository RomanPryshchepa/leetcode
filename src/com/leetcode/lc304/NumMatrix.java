package com.leetcode.lc304;

class NumMatrix {
    private final int[][] prefSum;

    public NumMatrix(int[][] matrix) {
        prefSum = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            prefSum[i][0] = matrix[i][0];
            for (int j = 1; j < matrix[0].length; j++) {
                prefSum[i][j] = prefSum[i][j - 1] + matrix[i][j];
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 1; i < matrix.length; i++) {
                prefSum[i][j] += prefSum[i - 1][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefSum[row2][col2]
                - (row1 - 1 < 0 ? 0 : prefSum[row1 - 1][col2])
                - (col1 - 1 < 0 ? 0 : prefSum[row2][col1 - 1])
                + (row1 - 1 < 0 || col1 - 1 < 0 ? 0 : prefSum[row1 - 1][col1 - 1]);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */