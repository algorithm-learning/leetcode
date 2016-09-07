package com.origintech.leetcode.problem34;

/**
 * Created by bcshuai on 9/6/16.
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int begin = 0, end = nums.length - 1;
        while(begin < end){
            int mid = (begin + end) >> 1;
            if(nums[mid] >= target){
                end = mid - 1;
            }else{
                begin = mid + 1;
            }
        }
        int left = begin;
        begin = 0; end = nums.length - 1;
        while(begin < end)
        {
            int mid = (begin + end) >> 1;
            if(nums[mid] <= target){
                begin = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        int right = end;
        if(right < 0 || left < 0){
            return new int[]{-1,-1};
        }
        if(nums[right] != target)
            --right;
        if(nums[left] != target)
            ++left;
        if(left <= right && nums[left] == nums[right]){
            return new int[]{left,right};
        }else{
            return new int[]{-1, -1};
        }
    }
    public static void main(String[] args){
        Solution s = new Solution();
        int[] v = s.searchRange(new int[]{2,2}, 1);
        System.out.printf("[%d,%d]", v[0],v[1]);
    }
}
