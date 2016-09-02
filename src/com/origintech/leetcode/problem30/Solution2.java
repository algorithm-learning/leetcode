package com.origintech.leetcode.problem30;

import java.util.*;

/**
 * Created by bcshuai on 8/29/16.
 */

/**
 * 暴力查找, 性能较低,被拒
 */
public class Solution2 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if(s.length() == 0 || words.length == 0)
            return list;

        Map<String, Integer> wordMap = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            if(wordMap.containsKey(words[i]))
                wordMap.put(words[i], wordMap.get(words[i]) + 1);
            else
                wordMap.put(words[i], 1);
        }

        int begin = 0, end = 0;
        int wordLen = words[0].length();
        for(int i = 0; i < s.length() - wordLen * words.length + 1;i++){
            begin = i;
            end = begin;
            if(end + wordLen > s.length())
                continue;
            String tmp = s.substring(end, end + wordLen);
            while(wordMap.containsKey(tmp)){
                if(wordMap.get(tmp) == 0){
                    break;
                }
                wordMap.put(tmp, wordMap.get(tmp) - 1);
                end += wordLen;

                if(end + wordLen > s.length())
                    break;
                tmp = s.substring(end, end + wordLen);
            }
            int count = 0;
            for(int j = 0; j < words.length; j++){
                count += wordMap.get(words[j]);
                wordMap.put(words[j], 0);
            }
            if(count == 0){
                list.add(begin);
            }
            for(int j = 0; j < words.length; j++){
                wordMap.put(words[j], wordMap.get(words[j]) + 1);
            }
        }
        return list;
    }
    public static void main(String[] args){
        Solution2 s = new Solution2();
        //System.out.println(s.findSubstring("barfoofoobarthefoobarman",
        //        new String[]{"bar","foo","the"}));
        System.out.println(s.findSubstring("wordgoodgoodgoodbestword",
                new String[]{"word","good","best","good"}));
    }
}
