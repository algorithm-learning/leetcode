package com.origintech.leetcode.problem72;

/**
 * Created by shuaibincheng on 16/9/3.
 */
public class Solution {
    public int internalMinDistance(String w1, int b1, String w2, int b2){
        if(w1.length() - b1 == 0 || w2.length() - b2 == 0){
            return Math.abs(w2.length() - w1.length() - b2 + b1);
        }

        int replace = internalMinDistance(w1, b1 + 1, w2, b2 + 1) + 1;
        if(w1.charAt(b1) == w2.charAt(b2)){
            return replace - 1;
        }else{
            int insert = internalMinDistance(w1, b1, w2, b2 + 1) + 1;
            int del = internalMinDistance(w1, b1 + 1, w2, b2) + 1;
            return Math.min(Math.min(insert, del), replace);
        }
    }
    public int minDistance(String word1, String word2) {
        return internalMinDistance(word1, 0, word2, 0);
    }
    public static void main(String[] args){
        String w1 = "1234859589";
        String w2 = " 234843295";
        //String w1 = "a";
        //String w2 = "a";
        Solution s = new Solution();
        System.out.println(s.minDistance(w1, w2));
    }
}
