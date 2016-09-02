package com.origintech.leetcode.problem70;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bcshuai on 9/2/16.
 */
public class Solution {
    public int climbStairs(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        for(int i = 3; i <= n; i++){
            int ways = list.get(i - 1) + list.get(i - 2);
            list.add(i, ways);
        }
        return list.get(Integer.valueOf(n));
    }
}
