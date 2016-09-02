package com.origintech.leetcode.problem10;

/**
 * Created by bcshuai on 8/25/16.
 */
public class Solution2 {
    public boolean equal(char c1, char c2){
        if(c1 == '.' || c2 == '.')
            return true;
        return c1 == c2;
    }
    public boolean isMatch(String s, String p) {
        if("".equals(p)){
            return "".equals(s);
        }
        //p不为空时
        char sym = p.charAt(0);
        char op = '\0';
        if(p.length() >= 2 && p.charAt(1) == '*'){
            op = '*';
        }
        if("".equals(s) && op == '\0'){
            return false;
        }
        if("".equals(s) && op == '*'){
            return isMatch(s, p.substring(2));
        }
        char c = s.charAt(0);
        if(equal(sym, c)){
            if(op != '*'){
                return isMatch(s.substring(1), p.substring(1));
            }else{
                int i;
                for(i = 0;i < s.length() && equal(s.charAt(i), sym); i++){
                    if(isMatch(s.substring(i), p.substring(2))){
                        return true;
                    }
                }
                return isMatch(s.substring(i), p.substring(2));
            }
        }else{
            if(op != '*'){
                return false;
            }else{
                return isMatch(s, p.substring(2));
            }
        }
    }
    public static void main(String[] args){
        Solution2 s = new Solution2();
        System.out.println(s.isMatch("bbbba", ".*a*a"));
    }
}
