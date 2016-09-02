package com.origintech.leetcode.problem28;

/**
 * Created by bcshuai on 8/28/16.
 */

/**
 * 暴力破解, 不过效率低, 提交时被拒
 * 效率太低
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() == 0 && needle.length() == 0)
            return 0;
        for(int i = 0; i < haystack.length();i++){
            int j;
            for(j = 0; i + j < haystack.length() && j < needle.length() &&
                    haystack.charAt(i + j) == needle.charAt(j); j++);
            if(j == needle.length()){
                return i;
            }
        }
        return -1;
    }
}
