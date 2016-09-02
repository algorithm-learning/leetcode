package com.origintech.leetcode.problem13;

/**
 * Created by bcshuai on 8/26/16.
 */
public class Solution2 {
    public int romanCharToInt(char s){
        switch (s){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }
    public int romanToInt(String s){
        char cur = '\0';
        char pre = '\0';
        int value = 0;
        int sum = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            cur = s.charAt(i);
            value = romanCharToInt(cur);
            if(cur == pre){
                sum += value;
                continue;
            }
            if(romanCharToInt(cur) < romanCharToInt(pre)){
                sum -= cur;
                continue;
            }
            sum += value;
            pre = cur;
        }
        return sum;
    }
    public static void main(String[] args){
        Solution2 s = new Solution2();
        System.out.println(s.romanToInt("MMCDXXV"));
    }
}
