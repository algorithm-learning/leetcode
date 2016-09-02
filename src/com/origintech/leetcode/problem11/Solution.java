package com.origintech.leetcode.problem11;

/**
 * Created by bcshuai on 8/26/16.
 */

/**
 * 本题的核心问题是求解: Max{(i - j) * min(h[i], h[j]}, i > j;
 * 分析可得到一个重要条件, 如果i, j 是最大容器, 则意味着:
 * 对任意 m > i, 有h[m] < min(h[i], h[j], 且
 * 对任意 n < j, 有h[n] < min(h[i], h[j].
 */
public class Solution {
    public int maxArea(int[] height) {
        if(height.length < 1){
            return 0;
        }
        int begin = 0, end = height.length - 1;
        int max = 0;
        while(end > begin){
            int area = (end - begin) * Math.min(height[end], height[begin]);
            max = Math.max(max, area);
            if(height[begin] < height[end]){
                int i = 0;
                for(i = begin; begin < height.length && height[i] <= height[begin]; i++);
                begin = i;
            }else{
                int i = 0;
                for(i = end; i >= 0 && height[i] <= height[end]; i--);
                end = i;
            }
        }
        return max;
    }
}
