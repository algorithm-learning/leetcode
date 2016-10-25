package com.origintech.leetcode.problem85;

import java.util.Map;

/**
 * Created by bcshuai on 9/19/16.
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int[][][] rects = new int[matrix.length + 1][matrix[0].length + 1][4];
        int max = 0;
        for(int i = 0; i < rects.length; i++){
            for(int j = 0; j < rects[0].length; j++){
                if(i == 0 || j == 0){
                    continue;
                }
                if(matrix[i - 1][j - 1] == '0'){
                    continue;
                }
                int[] up = {0, 0, 0, 0};
                int[] left = {0, 0, 0, 0};
                int[] corner = {0, 0, 0, 0};

                up[2] = 1;
                up[3] = rects[i - 1][j][3] + 1;
                up[0] = up[2];
                up[1] = up[3];
                int upArea = up[0] * up[1];

                left[2] = rects[i][j - 1][2] + 1;
                left[3] = 1;
                left[0] = left[2];
                left[1] = left[3];
                int leftArea = left[0] * left[1];
                if(leftArea > 1 && upArea > 1) {
                    corner[0] = Math.min(rects[i][j - 1][2], rects[i - 1][j - 1][0]) + 1;
                    corner[1] = Math.min(rects[i - 1][j][3], rects[i - 1][j - 1][1]) + 1;
                }
                int cornerArea = corner[0] * corner[1];
                int tmpMax = 0;
                if(cornerArea >= upArea && cornerArea >=  leftArea) {
                    rects[i][j][0] = corner[0];
                    rects[i][j][1] = corner[1];
                    tmpMax = cornerArea;
                }else if (upArea >= cornerArea  && upArea >= leftArea) {
                    rects[i][j][0] = up[0];
                    rects[i][j][1] = up[1];
                    tmpMax = upArea;
                }else {
                    rects[i][j][0] = left[0];
                    rects[i][j][1] = left[1];
                    tmpMax = leftArea;
                }
                rects[i][j][2] = left[2];
                rects[i][j][3] = up[3];
                if (tmpMax > max) max = tmpMax;
            }
        }
        /*int max = 0;
        int left = 0, top = 0;
        for(int i = 1; i < rects.length; i++ ) {
            for (int j = 1; j < rects[0].length; j++) {
                int area = rects[i][j][0] * rects[i][j][1];
                System.out.printf(" [%d, %d]" , rects[i][j][0], rects[i][j][1]);
                if (area > max) {
                    max = area;
                    left = i;
                    top = j;
                }
            }
            System.out.println();
        }
        System.out.printf("left=%d, top=%d\n", left, top);*/
        return max;
    }
    public static void main(String[] args){
        char[][]  matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        Solution s = new Solution();
        System.out.println(s.maximalRectangle(matrix));
    }
}
