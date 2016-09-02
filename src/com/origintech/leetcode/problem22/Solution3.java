package com.origintech.leetcode.problem22;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bcshuai on 8/28/16.
 */
public class Solution3 {
    public void generate(int left, int right, String sb, List<String> result){
        if(left == 0 && right == 0){
            result.add(sb);
            return;
        }
        if(left>0)
        {
            generate(left-1,right,sb + "(",result);
        }
        if(right>0&&left<right)
        {
            generate(left,right-1,sb + ")",result);
        }
    }
    public List<String> generateParenthesis(int n){
        List<String> ret = new ArrayList<>();
        generate(n, n, "", ret);
        return ret;
    }
    public static void main(String[] args){
        Solution3 s = new Solution3();
        for(String t : s.generateParenthesis(3))
            System.out.println(t);
    }
}
