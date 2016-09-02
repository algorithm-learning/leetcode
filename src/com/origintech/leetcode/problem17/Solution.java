package com.origintech.leetcode.problem17;

import com.sun.javafx.binding.StringFormatter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by bcshuai on 8/27/16.
 */
public class Solution {
    public List<String> permutation(String digits, int begin) {
        char[][] numToChars = new char[][]{
                {' '}, //0
                {}, //1
                {'a', 'b', 'c'}, //2
                {'d', 'e', 'f'}, //3
                {'g', 'h', 'i'}, //4
                {'j', 'k', 'l'}, //5
                {'m', 'n', 'o'}, //6
                {'p', 'q', 'r', 's'}, //7
                {'t', 'u', 'v'}, //8
                {'w', 'x', 'y', 'z'} //9
        };

        List<String> list = new ArrayList<>();
        if(begin == digits.length()){
            return list;
        }
        int index = digits.charAt(begin) - '0';
        char[] letters = numToChars[index];
        if(letters.length == 0)
            return list;
        List<String> tmp = permutation(digits, begin + 1);

        for(int i = 0; i < letters.length; i++){
            String item = String.valueOf(letters[i]);
            for(String t : tmp){
                list.add(item + t);
            }
            if(tmp.isEmpty()){
                list.add(item);
            }
        }

        return list;
    }
    public List<String> letterCombinations(String digits) {
        return permutation(digits, 0);
    }

    public static void main(String[] args){
        Solution s = new Solution();
        List<String> list = s.letterCombinations("23");
        for(String t : list){
            System.out.println(t);
        }
    }
}
