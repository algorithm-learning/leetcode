package com.origintech.leetcode.problem27;

/**
 * Created by bcshuai on 8/28/16.
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val) continue;
            nums[count++] = nums[i];
        }
        return count;
    }
}
