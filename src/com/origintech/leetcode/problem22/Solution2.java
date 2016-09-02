package com.origintech.leetcode.problem22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bcshuai on 8/28/16.
 */

/**
 * 基于动态规划思想
 */
public class Solution2 {
    private Map<Integer, List<String>> gps = new HashMap<>();
    private Map<Integer, List<List<Integer>>> compound = new HashMap<>();
    private Map<Integer, List<String>> ps = new HashMap<>();
    public List<List<Integer>> splitCompond(int n){
        if(compound.containsKey(n))
            return compound.get(n);
        List<List<Integer>> list = new ArrayList<>();
        if(n == 0 || n == 1){
            List<Integer> tmp = new ArrayList<>();
            tmp.add(n);
            list.add(tmp);
            return list;
        }
        for(int i = 1; i <= n; i++){
            List<List<Integer>> tmp = splitCompond(n - i);
            for(List<Integer> l : tmp){
                List<Integer> lt = new ArrayList<>();
                lt.add(0, i);
                lt.addAll(l);
                list.add(lt);
            }
        }
        compound.put(n, list);
        return list;
    }
    public List<String> parenthesis(int n){
        if(ps.containsKey(n))
            return ps.get(n);
        List<String> list = new ArrayList();
        if(n == 0) {
            list.add("");
            return list;
        }
        if(n == 1) {
            list.add("()");
            return list;
        }
        List<String> less = generateParenthesis(n - 1);
        for(String s : less){
            list.add("(" + s + ")");
        }
        ps.put(n, list);
        return list;
    }
    public List<String> combination(List<Integer> compond){
        List<String> list = new ArrayList<>();
        if(compond.isEmpty()){
            list.add("");
            return list;
        }
        int part = compond.remove(0);
        List<String> p = parenthesis(part);
        List<String> q = combination(compond);
        for(String t : p){
            for(String r : q){
                list.add(t + r);
            }
        }
        return list;
    }

    public List<String> generateParenthesis(int n){
        if(gps.containsKey(n))
            return gps.get(n);
        List<String> list = new ArrayList<>();
        List<List<Integer>> compondList = splitCompond(n);
        for(List<Integer> compondGroup: compondList){
            list.addAll(combination(compondGroup));
        }
        gps.put(n, list);
        return list;
    }
    public static void main(String[] args){
        Solution2 s = new Solution2();
        for(String t : s.generateParenthesis(3))
            System.out.println(t);
    }
}
