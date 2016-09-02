package com.origintech.leetcode.problem22;

/**
 * Created by bcshuai on 8/28/16.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 使用solution3的思路解决不存在重复元素的数组的出栈序列问题
 */
public class Solution4 {
    public void inOrOutStack(List<Integer> stack, String s, int[] num, int begin, List<String> result){
        if(num.length == begin && stack.isEmpty()){
            result.add(s);
        }
        if(begin < num.length){
            stack.add(0, num[begin]);
            inOrOutStack(stack, s, num, begin + 1, result);
            stack.remove(0);
        }
        if(!stack.isEmpty()){
            int c = stack.remove(0);
            inOrOutStack(stack, s + c, num, begin, result);
            stack.add(0, c);
        }
    }
    public List<String> outStackSeq(int[] nums){
        List<String> list = new ArrayList<>();
        List<Integer> stack = new ArrayList<>();
        inOrOutStack(stack, "", nums, 0, list);
        return list;
    }
    public static void main(String[] args){
        Solution4 s = new Solution4();
        for(String t : s.outStackSeq(new int[]{1,2,3,4}))
            System.out.println(t);
    }
}
