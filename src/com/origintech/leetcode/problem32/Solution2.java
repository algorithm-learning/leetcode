package com.origintech.leetcode.problem32;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bcshuai on 8/31/16.
 */

/**
 * 采用动态规划思路
 * 状态: S(i): 以s[i]开始的合法括号对的长度
 * 转移方程:
 *     S(i - 1) = S(i) + 1;  if s[i - 1] == '(' && s[i + d + 1] == ')'
 *     S(i - 1) = 0; if s[i - 1] == ')' || (s[i - 1] != '(' && s[i + d + 1] == ')')
 */
public class Solution2 {

    public int longestValidParentheses(String s){
        if(s.length() <= 1){
            return 0;
        }
        int max = 0;
        int[] buf = new int[s.length()];
        buf[s.length() - 1] = 0;
        for(int i = s.length() - 2; i >= 0; i--){
            if(s.charAt(i) == '(' && s.charAt(i + buf[i + 1] + 1) == ')') {
                buf[i] = 2 + buf[i + 1];
                if(i + buf[i + 1] + 2 < s.length())
                    buf[i] += buf[i + buf[i + 1] + 2];
            } else{
                buf[i] = 0;
            }
            max = Math.max(max, buf[i]);
        }
        return max;
    }
    public static void main(String[] args){
        Solution2 s = new Solution2();
        System.out.println(s.longestValidParentheses(")()())"));
    }
}
