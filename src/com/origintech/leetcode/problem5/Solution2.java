package com.origintech.leetcode.problem5;

/**
 * Created by bcshuai on 8/25/16.
 */

/**
 * 耗时太长
 */
public class Solution2 {
    public String internalPalindrom(String s){
        int half = s.length() >> 1;
        int maxLen = 1;
        String longestStr = s.substring(0, 1);
        for(int i = 1; i <= half; i++){
            String sub1 = s.substring(0, i);
            String sub2 = s.substring(i);
            int j = 0;
            for(j = 0; j < i; j++){
                if(s.charAt(i - 1 - j) != s.charAt(i + j)){
                    break;
                }
            }
            if(2 * j > maxLen){
                StringBuilder sb = new StringBuilder();
                for(int k = 0; k < 2 * j; k++){
                    sb.append(s.charAt(i - j + k));
                }
                maxLen = 2 * j;
                longestStr = sb.toString();
            }

            for(j = 0; j < i && i + 1 + j < s.length(); j++){
                if(s.charAt(i - 1 -j) != s.charAt(i + 1 + j)){
                    break;
                }
            }
            if(2 * j + 1 > maxLen){
                StringBuilder sb = new StringBuilder();
                for(int k = 0; k < 2 * j + 1; k++){
                    sb.append(s.charAt(i - j + k));
                }
                maxLen = 2 * j + 1;
                longestStr = sb.toString();
            }
        }
        return longestStr;
    }
    public String longestPalindrome(String s) {
        if(s.length() == 1)
            return s;
        StringBuilder buffer = new StringBuilder();
        buffer.append(s);

        String s1 = internalPalindrom(buffer.toString());
        String s2 = internalPalindrom(buffer.reverse().toString());
        if(s1.length() > s2.length()){
            return s1;
        }else{
            return s2;
        }

    }
    public static void main(String[] args){
        Solution2 s = new Solution2();
        System.out.println(s.longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }
}
