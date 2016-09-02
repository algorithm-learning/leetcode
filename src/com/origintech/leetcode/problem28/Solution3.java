package com.origintech.leetcode.problem28;

/**
 * Created by bcshuai on 8/29/16.
 */
public class Solution3 {
    public int[] genNext(String pattern){
        if(pattern.length() == 0){
            return new int[]{};
        }
        int[] next = new int[pattern.length()];
        next[0] = -1;
        for(int i = 1; i < next.length; i++){
            int j = 0;
            for(j = i - 1; next[j] >= 0 &&
                    pattern.charAt(i - 1) != pattern.charAt(next[j]); j = next[j]);
            if(next[j] >= 0 && pattern.charAt(i - 1) == pattern.charAt(next[j])){
                next[i] = next[j] + 1;
                continue;
            }
            next[i] = j;
        }
        return next;
    }
    public int KMP(String target, String pattern){
        if(pattern.length() == 0){
            return 0;
        }
        int ret = -1;
        int pos = 0;
        int i = 0, j = 0;
        int[] next = genNext(pattern);
        for(i = 0; i < target.length();){
            for(; i < target.length() && j < pattern.length() &&
                    target.charAt(i) == pattern.charAt(j); i++, j++);
            if(j >= pattern.length()) {
                ret = pos;
                break;
            }
            if(next[j] < 0){
                i++;
                pos = i;
                j = 0;
            }else{
                j = next[j];
                pos = i - j;
            }
        }
        return ret;
    }
    public int strStr(String haystack, String needle) {
        if(haystack.length() == 0 && needle.length() == 0){
            return 0;
        }
        return KMP(haystack, needle);
    }
    public static void main(String[] args){
        Solution3 s = new Solution3();
        System.out.println(s.strStr("mississippi",
                "issip"));
    }
}
