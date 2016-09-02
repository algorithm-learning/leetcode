package com.origintech.leetcode.problem32;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bcshuai on 8/30/16.
 */

/**
 * 忽略了以下情况: "(((()))))(((((("
 */
public class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() <= 1)
            return 0;
        List<Character> stack = new ArrayList<>();
        int max = 0;
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(stack.isEmpty()){
                if(cur != ')'){
                    stack.add(cur);
                }else{
                    max = Math.max(count, max);
                    count = 0;
                }
                continue;
            }
            char head = stack.get(0);
            if(cur == ')' && head == '('){
                stack.remove(0);
                count += 2;
            }else{
                stack.add(0, cur);
            }
        }
        return Math.max(count, max);
    }
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.longestValidParentheses(")()())"));
    }
}
