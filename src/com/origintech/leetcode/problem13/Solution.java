package com.origintech.leetcode.problem13;

/**
 * Created by bcshuai on 8/26/16.
 */
public class Solution {
    public int level(char s){
        switch (s){
            case 'I':
                return 0;
            case 'V':
                return 1;
            case 'X':
                return 2;
            case 'L':
                return 3;
            case 'C':
                return 4;
            case 'D':
                return 5;
            case 'M':
                return 6;
        }
        return 0;
    }
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
    public int romanToInt(String s) {

        if(s.length() == 0)
            return 0;
        if(s.length() == 1)
            return romanCharToInt(s.charAt(0));

        char c1 = s.charAt(s.length() - 1);
        if(c1 == 'I' || c1 == 'X' || c1 == 'C' || c1== 'M'){
            int repeat = 0;
            int i = 0;
            for(i = s.length() - 1; i >= 0 && s.charAt(i) == c1; i--){
                ++repeat;
                if(repeat >= 3){
                    break;
                }
            }
            if(s.length() == repeat){
                //全部读完
                return repeat * romanCharToInt(c1);
            }
            int cache = repeat * romanCharToInt(c1);
            char t = s.charAt(s.length() - repeat - 1);
            int diff = level(t) - level(c1);
            if(diff < 0 && diff >= -2){
                if(s.length() - repeat - 1 != 0) {
                    return cache - romanCharToInt(t) + romanToInt(s.substring(0, s.length() - repeat - 1));
                }else{
                    return cache - romanCharToInt(t);
                }
            }else if(diff < -2){
                return 0;
            }else if(level(t) - level(c1) == 1){
                if(s.length() - repeat - 1 != 0) {
                    return cache + romanCharToInt(t) + romanToInt(s.substring(0, s.length() - repeat - 1));
                }else{
                    return cache + romanCharToInt(t);
                }
            }else{
                return cache + romanToInt(s.substring(0, s.length() - repeat));
            }
        }else{
            char c2 = s.charAt(s.length() - 2);
            int diff = level(c2) - level(c1);
            if(diff < 0 && diff >= -2) {
                if (s.length() - 2 != 0)
                    return romanCharToInt(c1) - romanCharToInt(c2) + romanToInt(s.substring(0, s.length() - 2));
                else
                    return romanCharToInt(c1) - romanCharToInt(c2);
            }else{
                return romanCharToInt(c1) + romanToInt(s.substring(0, s.length() - 1));
            }

        }
    }
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.romanToInt("MMCDXXV"));
    }
}
