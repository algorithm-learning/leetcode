package com.origintech.leetcode.problem26;

/**
 * Created by bcshuai on 8/28/16.
 */
public class Solution2 {
    public int removeDuplicates(int[] nums) {
        int pos = 0, count = 0;
        if(nums.length <= 1)
            return nums.length;
        for(count = 1, pos = 1; pos < nums.length; pos++){
            if(nums[pos - 1] == nums[pos]) continue;
            nums[count++] = nums[pos];
        }
        return count;
    }
    public static void main(String[] args){
        Solution2 s = new Solution2();
        System.out.println(s.removeDuplicates(new int[]{1,2,2,3,4,4,5,5,111}));
    }
}
