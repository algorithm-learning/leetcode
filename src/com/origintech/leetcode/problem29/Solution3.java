package com.origintech.leetcode.problem29;

/**
 * Created by bcshuai on 8/29/16.
 */

/**
 * 思路: a  = k * b + (a % b), 令d = (a % b),则 a = k * b + d, 其中d < b;
 * 则 a / b本质是寻找k, 而k又可以表达为: k = 2 ^ i + m
 */
public class Solution3 {
    private int internalDevide(int dividend, int divisor){
        if(dividend > divisor){
            return 0;
        }
        if(dividend == divisor){
            return -1;
        }
        int count = 0;
        while ((divisor << (count + 1)) < 0 && dividend < (divisor << (count + 1))){
            ++count;
        }
        int remain = dividend - (divisor << count);
        return (-1 << count) + internalDevide(remain, divisor);
    }
    public int toNegative(int v){
        if(v > 0){
            v = -v;
        }
        return v;
    }
    public int divide(int dividend, int divisor) {
        if(divisor == 0){
            return Integer.MAX_VALUE;
        }
        if(dividend == 0){
            return 0;
        }
        boolean isNegative = false;
        if((dividend > 0 && divisor > 0) ||
                (dividend < 0) && (divisor < 0)){
            isNegative = false;
        }else{
            isNegative = true;
        }
        int result = internalDevide(toNegative(dividend), toNegative(divisor));
        if(isNegative){
            return result;
        }
        if(result == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
        return -result;
    }
    public static void main(String[] args){
        Solution3 s = new Solution3();
        System.out.println(s.divide(2147483647 ,3));
    }
}
