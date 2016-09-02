package com.origintech.leetcode.problem15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bcshuai on 8/26/16.
 */
public class Solution2 {

    public List<List<Integer>> twoSum(int[] nums, int begin, int target){
        List<List<Integer>> ret = new ArrayList<>();
        int left = begin, right = nums.length - 1;
        while (left < right){
            if(nums[left] + nums[right] + target > 0){
                --right;
                continue;
            }
            if(nums[left] + nums[right] + target < 0){
                ++left;
                continue;
            }
            List<Integer> lis = new ArrayList<>();
            lis.add(target);
            lis.add(nums[left]);
            lis.add(nums[right]);
            ret.add(lis);

            for(int i = left; i < right && nums[i] == nums[i + 1];left++, i++);
            for(int i = right - 1; i > left && nums[i] == nums[i + 1];right--, i--);
            left++;
            right--;
        }
        return ret;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if(nums.length < 3)
            return ret;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            List<List<Integer>> tmp = twoSum(nums, i + 1, nums[i]);
            for(List<Integer> li : tmp){
                ret.add(li);
            }
            for(; i < nums.length - 1 && nums[i] == nums[i + 1]; i++);
        }
        return ret;
    }
    public static void main(String[] args){
        Solution2 s = new Solution2();
        List<List<Integer>> list = s.threeSum(new int[]{-1,0,1,2,-1,-4});
        for(List<Integer> its:list){
            System.out.print("[");
            for(int i : its){
                System.out.print(i + " ");;
            }
            System.out.println("]");
        }
        System.out.println();
    }
}
