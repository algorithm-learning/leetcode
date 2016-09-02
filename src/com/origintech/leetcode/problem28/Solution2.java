package com.origintech.leetcode.problem28;

/**
 * Created by bcshuai on 8/29/16.
 */

/**
 * 基于KMP算法
 */

/**
 * 代码很难看
 */
public class Solution2 {
    public int[] buildNext(String pattern){
        if(pattern.length() == 0){
            return new int[]{};
        }
        int[] next = new int[pattern.length()];
        next[0] = -1;
        int i, j;
        for(i = 1; i < pattern.length();i++){
            for(j = i - 1;next[j] >= 0 && pattern.charAt(i - 1) != pattern.charAt(next[j]); j = next[j]);
            if(j > 0 && pattern.charAt(i - 1) == pattern.charAt(j)){
                next[i] = next[j] + 1;
                continue;
            }
            next[i] = j;
        }
        return next;
    }
    public int kmp(String target, String pattern){
        if(target.length() == 0 && pattern.length() == 0){
            return 0;
        }
        int[] next = buildNext(pattern);
        int pos = 0, j = 0, k = 0;
        int ret = -1;
        for(pos = 0, k = 0; k < target.length();){
            for(; k < target.length() && j < pattern.length();){
                if(target.charAt(k) == pattern.charAt(j)){
                    ++k;
                    ++j;
                    continue;
                }
                int tmp = next[j];
                if(tmp < 0){
                    j = 0;
                    pos++;
                    k = pos;
                    break;
                }else{
                    j = tmp;
                    pos = k - tmp;
                    break;
                }
            }
            if(j == pattern.length() && pos < target.length()){
                ret = pos;
                break;
            }
        }
        return ret;
    }
    public int strStr(String haystack, String needle) {
        return kmp(haystack, needle);
    }
    public static void main(String[] args){
        Solution2 s = new Solution2();
        System.out.println(s.strStr("mississippi",
                                     "issip"));
    }
}
