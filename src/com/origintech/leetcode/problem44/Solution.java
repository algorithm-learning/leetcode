package com.origintech.leetcode.problem44;

/**
 * Created by bcshuai on 8/31/16.
 */

import java.util.Arrays;

/**
 * 采用动态规划
 * aab
 * c*a*b
 *
 * 对目标串: s = a1 a2 a3 a4 a5 ... an 及匹配串: p = b1 b2 b3 b4 ... bm
 * 状态: p[k][i] = j 其中 p[k][i ... m] = s[j ... n]   1<=k<=n
 * p[i - 1]:
 *   if p[k][i - 1] == p[k][i - 1] != '*' ==> p[k][i - 1] = p[k][i] - 1
 *   if p[k][i - 1] != '*' && p[k][i - 1] != p[k][i] ==> 匹配失败
 *   if p[k][i - 1] == '*" && k <= ((s.length - 1) - p[k][i]) ==> p[k][i - 1] = p[k][i] - k;
 *   else 不匹配
 *
 *  失败， 递推公式错误
 */
public class Solution {
    private boolean equal(char s, char q){
        if(s == q)
            return true;
        if(s == '?' || q == '?')
            return true;
        return false;
    }
    public boolean isMatch(String s, String p) {
        if(s.length() == 0 && p.length() == 0)
            return true;
        if(p.length() == 0)
            return false;

        int[][] buf = new int[s.length() + 1][p.length()];
        for(int i = 0; i <= s.length(); i++){
            Arrays.fill(buf[i], -1);
        }
        boolean[] result = new boolean[s.length() + 1];

        char last = p.charAt(p.length() - 1);
        if(last == '*'){
            for(int i = s.length(); i >= 0; i--){
                buf[i][p.length() - 1] = i;
            }
        }else{
            if(s.length() == 0)
                return false;
            if(equal(last, s.charAt(s.length() - 1))){
                for(int i = s.length(); i >= 0; i--){
                    buf[i][p.length() - 1] = s.length() - 1;
                }
            }else{
                return false;
            }
        }
        if(s.length() == 1){
            return true;
        }
        for(int i = 0; i < result.length; i++){
            result[i] = true;
        }
        for(int i = p.length() - 2; i >= 0; i--){
            if(p.charAt(i) == '*'){
                for(int j = 0; j <= s.length(); j++){
                    buf[j][i] = buf[j][i + 1] - j;
                }
                continue;
            }
            for(int j = 0; j <= s.length(); j++){
                if((buf[j][i + 1] - 1) >= 0 && equal(p.charAt(i), s.charAt(buf[j][i + 1] - 1))){
                    buf[j][i] = buf[j][i + 1] - 1;
                }else{
                    continue;
                }
            }
        }
        for(int i = 0; i <= s.length(); i++){
            if(buf[i][0] == 0)
                return true;
        }
        return false;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        //System.out.println(s.isMatch("aa", "c*a*a"));
        //System.out.println(s.isMatch("aa", "aa"));
        //System.out.println(s.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba",
        //        "a*******b"));
        System.out.println(s.isMatch("abefcdgiescdfimde", "ab*cd?i*de"));
    }
}
