package com.origintech.leetcode.problem31;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by bcshuai on 8/30/16.
 */

/**
 * 思路: 全排列中, 升序排列的字典序最小, 降序排列的字典序最大
 * 对串: a1 a2 a3 ... ak a(k+1) .... an, 有
 *   1. (k + 1) <= i < j <= n, 有 ai >=</=> aj
 *   2. ak < a(k+1)
 */
public class Solution {
    public void inverseArray(int[] num, int begin, int end){
        int i = begin, j = end;
        int tmp = 0;
        while(i < j){
            tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;
            ++i;--j;
        }
    }
    public void nextPermutation(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return;
        }
        int i = nums.length - 2;
        for(; i >= 0 && nums[i] >= nums[i + 1];i--);
        if(i < 0){
            inverseArray(nums, 0, nums.length - 1);
            return;
        }
        int j = i;
        int tmp = nums[i];
        for(; j < nums.length - 1; j++){
            if(tmp < nums[j + 1]){
                nums[j] = nums[j + 1];
            }else{
                break;
            }
        }
        nums[j] = tmp;
        inverseArray(nums, i, j - 1);
        Arrays.sort(nums, i + 1, nums.length);
    }
    public static void main(String[] args){
        Solution s = new Solution();
        int[] a = {2,3,1};
        s.nextPermutation(a);
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
