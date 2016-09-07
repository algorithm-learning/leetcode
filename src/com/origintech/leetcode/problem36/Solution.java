package com.origintech.leetcode.problem36;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bcshuai on 9/6/16.
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check the nine-rectangle-grid
        Map<Character, Integer> count = new HashMap<>();
        for(int i = 0; i < board.length; i += 3){
            for(int j = 0; j < board.length; j += 3){
                count.clear();
                for(int k = 0; k < 3; k++){
                    for(int l = 0; l < 3; l++){
                        char c = board[i + k][j + l];
                        if(c == '.')
                            continue;
                        if(count.containsKey(c))
                            return false;
                    }
                }
            }
        }
        return true;
    }
}
