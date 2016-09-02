package com.origintech.leetcode.problem29;

/**
 * Created by bcshuai on 8/29/16.
 */

/**
 * 时间复杂度有点高
 */
public class Solution {
    public int negativeDivide(int dividend, int divisor) {
        if(divisor == 0)
            return Integer.MAX_VALUE;
        if(dividend > 0)
            dividend = -dividend;
        if(divisor > 0)
            divisor = -divisor;
        int result = 0;
        while(dividend <= divisor){
            --result;
            dividend -= divisor;
        }
        return result;
    }
    public int divide(int dividend, int divisor) {
        boolean isNegative = false;
        if((dividend < 0 ) && (divisor < 0) ||
                (dividend > 0) && (divisor > 0)){
            isNegative = false;
        }else{
            isNegative = true;
        }
        int result = negativeDivide(dividend, divisor);
        if(result == Integer.MAX_VALUE)
            return result;
        if(isNegative)
            return result;
        if(result == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
        return -result;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.divide(-2147483648,
                -1));
    }
}
