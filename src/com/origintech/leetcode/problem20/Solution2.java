package com.origintech.leetcode.problem20;

/**
 * Created by bcshuai on 8/28/16.
 */
public class Solution2 {
    public boolean matchInOrder(char c1, char c2){
        if(c1 == '(' && c2 == ')')
            return true;
        if(c1 == '{' && c2 == '}')
            return true;
        if(c1 == '[' && c2 == ']')
            return true;
        return false;
    }
    public boolean isValid(String s) {

        return false;
    }
}
