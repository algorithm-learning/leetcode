package com.origintech.leetcode.problem26;

/**
 * Created by bcshuai on 8/28/16.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        int len = nums.length;
        for(int i = 0; i < len - 1;){
            if(i + k + 1 < len && nums[i + k + 1] == nums[i]){
                ++k;
                continue;
            }
            if(k == 0) {
                ++i;
                continue;
            }
            for(int j = i + k + 1; j < len; j++){
                nums[j - k] = nums[j];
            }
            len -= k;
            k = 0;
            ++i;
        }
        return len;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.removeDuplicates(new int[]{1,2,2,3,4,4,5,5,111}));
    }
}
