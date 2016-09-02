package com.origintech.leetcode.problem63;

/**
 * Created by bcshuai on 9/2/16.
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;  //rows
        int n = obstacleGrid[0].length; //columns
        int[][] path = new int[m + 1][n + 1];
        path[0][1] = 0;
        path[1][0] = 1;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(obstacleGrid[i - 1][j - 1] == 1){
                    path[i][j] = 0;
                    continue;
                }
                path[i][j] = path[i - 1][j] +
                        path[i][j - 1];
            }
        }

        return path[m][n];
    }
    public static void main(String[] args){
        int[][] a = new int[100][99];
        System.out.println(a.length);
        System.out.println(a[0].length);
    }
}
