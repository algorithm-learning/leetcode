package com.origintech.leetcode.problem15;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bcshuai on 8/26/16.
 * 代码有点丑
 */
public class Solution {
    public List<List<Integer>> twoSum(int[] nums, int value, int skipPos){
        List<List<Integer>> ret = new ArrayList<>();
        int begin = 0, end = nums.length - 1;
        while(begin < end){
            if(begin <= skipPos){
                ++begin;
                continue;
            }
            List<Integer> list = new ArrayList<>();
            int tmp = nums[end] + nums[begin];
            if(tmp > value){
                --end;
            }else if(tmp < value){
                ++begin;
            }else{
                list.add(nums[begin]);
                list.add(nums[end]);
                int i = 0;
                for(i = 0; (begin + i) < nums.length && nums[begin + i] == nums[begin]; i++);
                begin += i;
                for(i = 0; (end + i) >= 0 && nums[end + i] == nums[end]; i--) ;
                end += i;
            }
            if(!list.isEmpty()){
                ret.add(list);
            }
        }
        return ret;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        //将数组排序
        List<List<Integer>> ret = new ArrayList<>();
        if(nums.length < 3)
            return ret;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i - 1 >= 0 && nums[i - 1] == nums[i]){
                continue;
            }
            List<List<Integer>> tmp = twoSum(nums, -nums[i], i);
            for(List<Integer> its : tmp){
                its.add(nums[i]);
                ret.add(its);
            }
        }
        return ret;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        List<List<Integer>> list = s.threeSum(new int[]{0,0,0});
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
