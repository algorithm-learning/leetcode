package com.origintech.leetcode.problem20;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bcshuai on 8/28/16.
 */
public class Solution {
    public boolean matchInOrder(char c1, char c2){
        /*List<Character> left = new ArrayList<>();
        left.add('('); left.add('['); left.add('{');
        List<Character> right = new ArrayList<>();
        right.add(')'); right.add(']'); right.add('}');
        int index1 = left.indexOf(c1);
        int index2 = right.indexOf(c2);
        return index1 >= 0 && index2 >= 0 && index1 == index2;*/
        if(c1 == '(' && c2 == ')')
            return true;
        if(c1 == '{' && c2 == '}')
            return true;
        if(c1 == '[' && c2 == ']')
            return true;
        return false;
    }
    public boolean isValid(String s) {
        if(s == null || s.length() == 0)
            return true;
        if(s == null || s.length() % 2 == 1)
            return true;
        char[] stack = new char[s.length() + 1];
        int pos = 0;
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(!matchInOrder(stack[pos], cur)){
                stack[++pos] = cur;
            }else{
                --pos;
            }
        }
        return pos == 0;
    }
}
