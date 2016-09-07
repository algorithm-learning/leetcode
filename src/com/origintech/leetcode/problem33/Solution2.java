package com.origintech.leetcode.problem33;

/**
 * Created by bcshuai on 9/6/16.
 */

/**
 * 非递归解法
 */
public class Solution2 {
    public int search(int[] nums, int target) {
        int begin = 0, end = nums.length;
        while(begin < end){
            int mid = (begin + end) >> 1;
            if(target == nums[mid]){
                return mid;
            }
            if(nums[mid] > nums[end - 1])
            {
                //pivot in [mid ... end)
                if(target > nums[mid]){
                    begin = mid;
                }else if(target > nums[end - 1]){
                    end = mid;
                }
                else{
                    begin = mid;
                }
            }else{
                //pivot in [0 ... mid)
                if(target < nums[mid]){
                    end = mid;
                }else if(target > nums[end - 1]){
                    end = mid;
                }else{
                    begin = mid;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Solution2 s = new Solution2();
        System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 1));
    }
}
