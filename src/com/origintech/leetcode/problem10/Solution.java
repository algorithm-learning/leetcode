package com.origintech.leetcode.problem10;

import java.util.ArrayList;

/**
 * Created by bcshuai on 8/25/16.
 */

/**
 * Failed
 * 对于*操作符, 每次只在后面的串无法满足时才进行贪心匹配
 */
public class Solution {
    public boolean equal(char c1, char c2){
        if(c1 == '.' || c2 == '.')
            return true;
        return c1 == c2;
    }
    public boolean isMatch(String s, String p) {
        char op = '\0';
        char sym = '\0';
        int i, j;
        char pc = '\0', sc = '\0';
        ArrayList<Character> opStack = new ArrayList<>();
        ArrayList<Character> charStack = new ArrayList<>();

        for(i = 0, j = 0; j < s.length() && i < p.length();){

            if(pc == '\0')
                pc = p.charAt(i);  //将当前模式串字符入栈
            sc = s.charAt(j);

            if(op == '\0' && (i + 1) < p.length() && p.charAt(i + 1) == '*') {
                op = '*';
                i++;
            }

            if(!equal(pc, sc) && op == '*'){
                //当前字符匹配失败, 但找到*操作符,跳过该字符
                i++;
                //清空栈
                pc = '\0'; op = '\0';
                continue;
            }
            if(!equal(pc, sc) && op == '\0'){
                return false;
            }
            if(j + 1 < s.length() && equal(pc, s.charAt(j + 1)) && op == '*'){
                //重复计算,保持栈
                j++;
            }else{
                //下一个字符不是重复的, 清空栈
                pc = op = '\0';
                i++;
                j++;
            }
        }

        return j == s.length() ;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.isMatch("aaa", "a*a"));
    }
}
