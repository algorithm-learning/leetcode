package com.origintech.leetcode.problem8;

/**
 * Created by bcshuai on 8/25/16.
 */
public class Solution {
    public int convertCharToInt(char c){
        char[] cha = {
                '0', '1', '2', '3', '4', '5',
                '6','7','8','9',
                'a', 'b', 'c', 'd', 'e', 'f'
        };
        for(int i = 0; i < cha.length; i++){
            if(c == cha[i]){
                return i;
            }
        }
        return 0;
    }
    public int myAtoi(String str) {
        str = str.trim();
        if(str.length() == 0){
            return 0;
        }

        int begin = 0;
        int end = str.length();
        int base = 10;
        int sym = 1;
        for(;begin < end && (str.charAt(begin) == '-' || str.charAt(begin) == '+'); begin++){
            if(str.charAt(begin) == '-'){
                sym *= -1;
            }else{
                sym *= 1;
            }
        }
        if(begin > 1){
            return 0;
        }
        for(end = begin; end < str.length(); end++){
            if(str.charAt(end) < '0' || str.charAt(end) > '9'){
                break;
            }
        }
        if(begin == end){
            return 0;
        }
        if(str.charAt(begin) == '0'){
            if(begin + 1 == str.length()){
                return 0;
            }
            if(str.charAt(begin) == 'x' || str.charAt(begin) == 'X'){
                base = 16;
            }
        }else{
            base = 10;
        }
        int result = 0;
        for(int i = end - 1; i >= begin; i--){
            if(!(str.charAt(i) >= '0' && str.charAt(i) <= '9')){
                break;
            }
            result += sym * Math.pow(base, end - 1 - i) * convertCharToInt(str.charAt(i));

        }

        return result;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.myAtoi("-134"));
    }
}
