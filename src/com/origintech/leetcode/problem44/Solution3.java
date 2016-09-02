package com.origintech.leetcode.problem44;

import java.util.Arrays;

/**
 * Created by bcshuai on 9/1/16.
 * 动态规划思路
 * 目标串: s, 模式串： p
 * S[i][j] : s[0 ... i] 是否与 p[0...j] 匹配
 */
public class Solution3 {
    public boolean isMatch(String s, String p) {
        int count = 0;
        for(int i = 0; i < p.length(); i++) if(p.charAt(i) != '*') ++count;
        if(count > s.length())
            return false;
        int begin = 0, end = p.length() - 1;

        for(;begin < end && p.charAt(begin) == '*' && p.charAt(begin + 1) == '*';++begin);
        for(;end > begin && p.charAt(end) == '*' && p.charAt(end - 1) == '*'; --end);
        boolean[][] matrix = new boolean[s.length() + 1][end - begin + 2];
        matrix[0][0] = true;
        for(int j = begin + 1; j <= end + 1; j++){
            if(matrix[0][j - 1 - begin] && p.charAt(j - 1) == '*' ){
                matrix[0][j - begin] = true;
            }
            for(int i = 1; i <= s.length(); i++){
                if(p.charAt(j - 1) == '*'){
                    matrix[i][j - begin] = matrix[i][j - begin - 1] || matrix[i - 1][j - begin];
                }else if(s.charAt(i - 1) == p.charAt(j - 1) ||
                        p.charAt(j - 1) == '?'){
                    matrix[i][j - begin] = matrix[i - 1][j - begin - 1];
                }else{
                    matrix[i][j - begin] = false;
                }
            }
        }

        return matrix[s.length()][end - begin + 1];
    }
    public static void main(String[] args){
        Solution3 s = new Solution3();
        System.out.println(s.isMatch("aab", "c*a*a"));
        //System.out.println(s.isMatch("aa", "aa"));
//        System.out.println(s.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba",
//                "a*******b"));
//        System.out.println(s.isMatch("abefcdgiescdfimde", "ab*cd?i*de"));
        System.out.println(s.isMatch("a", ""));
    }
}
