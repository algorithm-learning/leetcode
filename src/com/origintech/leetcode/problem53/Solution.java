package com.origintech.leetcode.problem53;

/**
 * Created by bcshuai on 9/2/16.
 */

/**
 * 动态规划思路
 * S[i]: 以i起始的子数组的最大和
 * http://www.tuicool.com/articles/IbiMjaI 另外一种动态规划的思路，根据具体情况确定最小的空间消耗
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0)
            return 0;
        int[] buf = new int[nums.length];
        buf[nums.length - 1] = nums[nums.length - 1];
        int max = buf[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--){
            if(buf[i + 1] >= 0){
                buf[i] = buf[i + 1] + nums[i];
            }else if(nums[i + 1] >= 0){
                buf[i] = nums[i + 1] + nums[i];
            }else{
                buf[i] = nums[i];
            }
            max = Math.max(buf[i], max);
        }

        return max;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.maxSubArray(new int[]{
            -2,1,-3,4,-1,2,1,-5,4
        }));
    }
}
