package com.origintech.leetcode.problem30;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.*;

/**
 * Created by bcshuai on 8/29/16.
 */

/**
 * 很复杂的思路, 有空再写吧
 */
public class Solution {
    public List<Integer> allIndexOf(String s, String subStr){
        List<Integer> list = new ArrayList<>();
        int index = s.indexOf(subStr);

        while(index >= 0){
            list.add(index);
            index = s.substring(index + subStr.length()).indexOf(subStr);
        }
        return list;
    }
    public List<Integer> findSubstring(String s, String[] words) {
        Set<String> wordSet = new TreeSet<>();
        for(int i = 0; i < words.length; i++)
            wordSet.add(words[i]);

        List<Integer> ret = new ArrayList<>();
        if(s.length() == 0 || words.length == 0){
            return ret;
        }

        int workLen = words[0].length();
        for(int i = 0; i < words.length; i++){
            List<Integer> lis = allIndexOf(s, words[i]);
            for(int li : lis){

            }
        }
        return null;
    }
}
