package com.origintech.leetcode.problem3;

import java.util.Arrays;

public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        int[] cache = new int[128];
        Arrays.fill(cache, -1);

        int begin = 0;
        int max = 0;
        int tmp = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(cache[c] >= begin){
                begin = cache[c] + 1;
                max = Math.max(tmp, max);
                tmp = i - begin;
            }
            cache[c] = i;
            tmp++;
        }
        max = Math.max(tmp,max);
        return max;
    }

    public static void main(String[] args) {

    }
}
