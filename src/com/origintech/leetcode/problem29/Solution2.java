package com.origintech.leetcode.problem29;

/**
 * Created by bcshuai on 8/29/16.
 */

/**
 * 1. 因为(a + b) / c = a / c + ((a + b) - a) / c
 * 基于这个思想,可以采用分治的策略
 * 2. 因为负数的取值范围大小正数, 所以采用负数运算,最后转为正数
 */
public class Solution2 {
    public int toNegivate(int v){
        if(v > 0)
            return -v;
        return v;
    }
    public boolean isOdd(int v){
        int part1 = v >> 1;
        int part2 = v - part1;
        return part1 == part2;
    }

    public int negativeDivide(int dividend, int divisor) {
        if (dividend > divisor)
            return 0;
        int count = 0;
        int result = -1;
        int part1 = dividend >> 1;
        int part2 = dividend - part1;
        if(part1 <= dividend && part2 <= dividend){

        }
        return 0;
    }
    public int divide(int dividend, int divisor) {
        if(divisor == 0)
            return Integer.MAX_VALUE;
        boolean isPositive = false;
        if((dividend < 0 && divisor < 0)
                || (dividend > 0 && divisor > 0))
            isPositive = true;
        else
            isPositive = false;
        dividend = toNegivate(dividend);
        divisor = toNegivate(divisor);
        int result = negativeDivide(dividend, divisor);
        if(isPositive)
            return -result;
        else
            return result;
    }
    public static void main(String[] args){
        Solution2 s = new Solution2();
        System.out.println(s.divide(-2147483648,
                -1));
    }
}
