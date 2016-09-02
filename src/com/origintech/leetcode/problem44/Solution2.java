package com.origintech.leetcode.problem44;

/**
 * Created by bcshuai on 8/31/16.
 */

/**
 * 性能太低, 提交到leetcode被拒
 */
public class Solution2 {
    private boolean equal(char s, char q){
        if(s == q)
            return true;
        if(s == '?' || q == '?')
            return true;
        return false;
    }
    public boolean internalIsMatch(String s, int sb, int se, String p, int pb, int pe){
        if((sb - se) == 0 && (pb  - pe == 0)){
            return true;
        }
        if((pb - pe) == 0){
            return false;
        }
        if((pb + 1 - pe) == 0 && p.charAt(pb) == '*'){
            return true;
        }
        for(; pb < pe && sb <= se;){
            if(p.charAt(pb) == '*'){
                for (; pb + 1 < pe && p.charAt(pb + 1) == '*'; pb++) ;
                for(int i = sb; i <= se; i++){
                    if(internalIsMatch(s, i, se, p, pb + 1, pe)) {
                        return true;
                    }
                }
                return false;
            }
            if(sb == se){
                return false;
            }
            if(equal(s.charAt(sb), p.charAt(pb))){
                ++sb;
                ++pb;
            }else{
                return false;
            }
        }
        return pb == pe && sb == se;
    }
    public boolean isMatch(String s, String p) {

        return internalIsMatch(s, 0, s.length(), p, 0, p.length());
    }
    public static void main(String[] args){
        Solution2 s = new Solution2();
        System.out.println(s.isMatch("aa", "c*a*a"));
        System.out.println(s.isMatch("aa", "aa"));
        System.out.println(s.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba",
                "a*******b"));
    }
}
