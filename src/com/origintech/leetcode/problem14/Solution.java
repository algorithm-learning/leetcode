package com.origintech.leetcode.problem14;

/**
 * Created by bcshuai on 8/26/16.
 */

/**
 * 思路一: 字典树
 * 思路二: 线性遍历
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        int minLen = Integer.MAX_VALUE;
        for(int i = 0; i < strs.length; i++){
            if(strs[i].length() < minLen){
                minLen = strs[i].length();
            }
        }
        if(minLen == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < minLen; i++){
            boolean allSame = true;
            char watcher = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){
                if(strs[j].charAt(i) != watcher){
                    allSame = false;
                    break;
                }
            }
            if(allSame){
                sb.append(watcher);
            }else{
                break;
            }
        }
        return sb.toString();
    }
}
