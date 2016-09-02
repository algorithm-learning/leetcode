package com.origintech.leetcode.problem12;

/**
 * Created by bcshuai on 8/26/16.
 */
public class Solution {

    public String intToRoman(int num) {

        String[][] romanNums = {
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"","X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}
        };

        return romanNums[3][num / 1000]
                + romanNums[2][(num % 1000) / 100]
                + romanNums[1][(num % 100) / 10]
                + romanNums[0][num % 10];
    }
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.intToRoman(3124));
    }
}
