package com.origintech.leetcode.problem30;

import java.util.*;

/**
 * Created by bcshuai on 8/30/16.
 */
public class Solution3 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if(s.length() == 0 || words.length == 0){
            return list;
        }
        int wordLen = words[0].length();
        if(s.length() < wordLen)
            return list;
        Map<String, Integer> wordSet = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            if(wordSet.containsKey(words[i])){
                wordSet.put(words[i], wordSet.get(words[i]) + 1);
            }else{
                wordSet.put(words[i], 1);
            }
        }
        Map<String, Integer> tmpWordSet = new HashMap<>();
        int count = words.length;
        for(int i = 0; i < wordLen; i++){
            tmpWordSet.clear();
            count = words.length;
            for(int begin = i, end = i;
                begin < s.length() - wordLen * words.length + 1
                    && end < s.length();){
                String tmp = s.substring(end, end + wordLen);
                if(!wordSet.containsKey(tmp)){
                    begin = end + wordLen;
                    end = begin;
                    tmpWordSet.clear();
                    count = words.length;
                    continue;
                }
                if(!tmpWordSet.containsKey(tmp)){
                    --count;
                    tmpWordSet.put(tmp, 1);
                }else if(tmpWordSet.get(tmp) < wordSet.get(tmp)){
                    --count;
                    tmpWordSet.put(tmp,tmpWordSet.get(tmp) + 1);
                } else{
                    if(count == 0){
                        list.add(begin);
                    }
                    String first = s.substring(begin, begin + wordLen);
                    ++count;
                    if(tmpWordSet.get(first) == 1){
                        tmpWordSet.remove(first);
                    }else {
                        tmpWordSet.put(first, tmpWordSet.get(first) - 1);
                    }
                    begin = begin + wordLen;
                    continue;
                }
                if(count == 0){
                    list.add(begin);
                    String first = s.substring(begin, begin + wordLen);
                    ++count;
                    if(tmpWordSet.get(first) == 1){
                        tmpWordSet.remove(first);
                    }else {
                        tmpWordSet.put(first, tmpWordSet.get(first) - 1);
                    }
                    begin = begin + wordLen;
                    end = end + wordLen;
                    continue;
                }
                end += wordLen;
            }
        }
        return list;
    }
    public static void main(String[] args){
        Solution3 s = new Solution3();
        System.out.println(s.findSubstring("cccab",
                new String[]{"cc","ca"}));
        System.out.println(s.findSubstring("wordgoodgoodgoodbestword",
                new String[]{"word","good","best","good"}));
    }
}
