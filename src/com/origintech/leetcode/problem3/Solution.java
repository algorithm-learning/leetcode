package com.origintech.leetcode.problem3;

import java.util.ArrayList;

/**
 * Created by bcshuai on 8/25/16.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1){
            return s.length();
        }
        int begin = 0, end = 1;
        int maxLength = 0;
        int tempMax = 0;
        for(end = 1; end < s.length(); end++){
            int index = s.indexOf(s.charAt(end), begin);
            if(index >= 0 && index < end){
                tempMax = end - begin;
                begin = ++index;
            }
            maxLength = Math.max(tempMax, maxLength);
        }
        tempMax = end - begin;
        maxLength = Math.max(tempMax, maxLength);
        return maxLength;
    }
    public static void main(String[] args){
        Solution2 s = new Solution2();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
    }
}
