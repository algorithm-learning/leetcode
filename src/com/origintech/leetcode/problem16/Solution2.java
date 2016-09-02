package com.origintech.leetcode.problem16;

/**
 * Created by bcshuai on 8/26/16.
 */

/**
 * 暴力搜索
 */
public class Solution2 {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return nums[0] + nums[1];

        int closest = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 2; i++){
            for(int j = i + 1; j < nums.length - 1; j++){
                for(int k = j + 1; k < nums.length; k++){
                    int diff = Math.abs(nums[i] + nums[j] + nums[k] - target);
                    if(diff < min){
                        min = diff;
                        closest = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }
        return closest;
    }
}
