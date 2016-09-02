package com.origintech.leetcode.problem22;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bcshuai on 8/28/16.
 */
public class Solution {
    public List<List<Integer>> compond(int n){
        List<List<Integer>> list = new ArrayList<>();
        if(n == 0 || n == 1){
            List<Integer> tmp = new ArrayList<>();
            tmp.add(n);
            list.add(tmp);
            return list;
        }
        for(int i = 1; i <= n; i++){
            List<List<Integer>> tmp = compond(n - i);
            for(List<Integer> l : tmp){
                l.add(0, i);
                list.add(l);
            }
        }
        return list;
    }
    public List<String> parenthesis(int n){
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
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList();
        List<List<Integer>> compondList = compond(n);
        for(List<Integer> compond : compondList){
            list.addAll(combination(compond));
        }
        return list;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        for(String t : s.generateParenthesis(3))
            System.out.println(t);
    }
}
