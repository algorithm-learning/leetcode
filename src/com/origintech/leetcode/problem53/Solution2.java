package com.origintech.leetcode.problem53;

/**
 * Created by bcshuai on 9/2/16.
 */

/**
 * 基于分治思路
 */
public class Solution2 {
    private static class Range{
        public int begin;
        public int end;
        public int value;
    }
    public Range internalMaxSubArray(int[] nums, int begin, int end){
        if(begin + 1 == end){
            Range r = new Range();
            r.begin = begin;
            r.end = end;
            r.value = nums[begin];
            return r;
        }
        int mid = (begin + end) >> 1;
        Range l = internalMaxSubArray(nums, begin, mid);
        Range r = internalMaxSubArray(nums, mid, end);

        if(l.value > r.value)
            return l;
        else
            return r;
    }
    public int maxSubArray(int[] nums) {
        Range r = internalMaxSubArray(nums, 0, nums.length);
        return r.value;
    }
    public static void main(String[] args){
        Solution2 s = new Solution2();
        System.out.println(s.maxSubArray(new int[]{
                -2,1,-3,4,-1,2,1,-5,4
        }));
    }
}
