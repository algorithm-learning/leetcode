package com.origintech.leetcode.problem64;

import java.util.Arrays;

/**
 * Created by bcshuai on 9/2/16.
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] path = new int[rows][cols];
        path[0][0] = grid[0][0];
        for(int i = 1; i < cols; i++){
            path[0][i] = path[0][i - 1] + grid[0][i];
        }
        for(int j = 1; j < rows; j++){
            path[j][0] = path[j - 1][0] + grid[j][0];
        }

        for(int i = 1; i < rows; i++){
            for(int j = 1; j < cols; j++){
                int tmp = Math.min(path[i - 1][j], path[i][j - 1]);
                path[i][j] = tmp + grid[i][j];
            }
        }
        return path[rows - 1][cols - 1];
    }
}
