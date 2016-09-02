package com.origintech.leetcode.problem5;

/**
 * Created by bcshuai on 8/25/16.
 */
public class Solution3 {
    public String modifyString(String src){
        StringBuilder sb =  new StringBuilder();
        for(int i = 0; i < src.length(); i++){
            sb.append("#");
            sb.append(src.charAt(i));
        }
        sb.append("#");
        return sb.toString();
    }
    public String longestPalindrome(String s) {

        String newStr = modifyString(s);
        int[] buf = new int[newStr.length()];

        int maxLen = 0;
        String longestStr = "";
        int longestStrCenter = 0;

        int maxP = -1;
        int posOfMaxP = -1;

        for(int i = 0; i < newStr.length(); i++){
            if(i < maxP){
                buf[i] = Math.min(maxP -  i, buf[(posOfMaxP << 1) -i]);
                continue;
            }
            buf[i] = 1;
            for(;i - buf[i] >= 0 &&
                    i + buf[i] < newStr.length() &&
                    newStr.charAt(i - buf[i]) == newStr.charAt(i + buf[i]);){
                buf[i]++;
            }
            if(buf[i] > maxLen){
                longestStrCenter = i;
                maxLen = buf[i];
            }
        }

        StringBuilder sb =  new StringBuilder();
        for(int begin = longestStrCenter - buf[longestStrCenter] + 2;
                begin <= longestStrCenter + buf[longestStrCenter] - 2; begin = begin + 2 ){
            sb.append(newStr.charAt(begin));
        }

        return sb.toString();
    }
    public static void main(String[] args){
        Solution3 s = new Solution3();
        System.out.println(s.longestPalindrome("ababababa"));
    }
}
