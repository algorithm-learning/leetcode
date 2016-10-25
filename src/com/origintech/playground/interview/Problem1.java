package com.origintech.playground.interview;

import java.util.*;

/**
 * Created by bcshuai on 23/09/2016.
 */
class Problem1 {
    public static void main(String[] args){
        Map<String, String> map = new HashMap<String,String>();
        map.put("hello", "879");
        map.put("world", "456");
        Set<Map.Entry<String, String>> s = map.entrySet();
        Map.Entry<String, String>[] entries = new Map.Entry[s.size()];
        s.toArray(entries);
        Arrays.sort(entries, Map.Entry.comparingByValue());
        for(int i = 0; i < entries.length; i++){
            System.out.println(entries[i].getValue());
        }
    }
}