package com.origintech.leetcode.problem33;

/**
 * Created by bcshuai on 9/6/16.
 */

/**
 * 递归解法
 */
public class Solution {
    public int internalSearch(int[] nums, int begin ,int end, int target){
        if(begin == end){
            return -1;
        }
        if(end - begin == 1){
            return (target == nums[begin])?begin: -1;
        }
        int mid = (begin + end) >> 1;
        if(nums[mid] == target){
            return mid;
        }
        if(nums[mid] > nums[end - 1]){
            //pivot in [mid ... end)
            if(target > nums[mid]){
                return internalSearch(nums, mid + 1, end, target);
            }
            if(target > nums[end - 1]){
                return internalSearch(nums, begin, mid, target);
            }else{
                return internalSearch(nums, mid + 1, end, target);
            }
        }else {
            //pivot in [0, mid)
            if (target < nums[mid]) {
                return internalSearch(nums, begin, mid, target);
            }
            if(target > nums[end - 1]){
                return internalSearch(nums, begin, mid, target);
            }else{
                return internalSearch(nums, mid + 1, end, target);
            }
        }
    }
    public int search(int[] nums, int target) {
        return internalSearch(nums, 0, nums.length, target);
    }
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 8));
    }
}
