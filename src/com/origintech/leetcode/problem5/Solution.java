package com.origintech.leetcode.problem5;


import java.util.ArrayList;

/**
 * Failed
 */

/**
 * Created by bcshuai on 8/25/16.
 */
public class Solution {
    /**
     * 回文与栈的结构很相似
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        ArrayList<Character> stack = new ArrayList<>();
        ArrayList<Character> pastStack = new ArrayList<>();
        ArrayList<Character> futureQueue = new ArrayList<>();

        int maxLen = 1;
        String longestString = s.substring(0, 1);

        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(stack.isEmpty() && pastStack.isEmpty() && futureQueue.isEmpty()){
                stack.add(0, cur);
            }else if(stack.isEmpty() && (!pastStack.isEmpty() || !futureQueue.isEmpty())){
                //当前情况所有的元素均相同
                boolean allSame = false;
                for(char c : pastStack){
                    if(c != cur){
                        allSame = false;
                        break;
                    }
                    allSame = true;
                }
                for(char c : futureQueue){
                    if(c != cur){
                        allSame =false;
                        break;
                    }
                    allSame = true;
                }
                if(allSame){
                    futureQueue.add(cur);
                }else{
                    int tmpLen = pastStack.size() + futureQueue.size();
                    StringBuilder sb = new StringBuilder();
                    while (!pastStack.isEmpty()) {
                        char c = pastStack.remove(0);
                        stack.add(0, c);
                        sb.append(c);
                    }
                    while (!futureQueue.isEmpty()) {
                        char c = futureQueue.remove(0);
                        stack.add(0, c);
                        sb.append(c);
                    }
                    if(tmpLen > maxLen){
                        maxLen = tmpLen;
                        longestString = sb.toString();
                        System.out.println(longestString);
                    }
                    stack.add(0,cur);
                }
            }else{
                char header = stack.remove(0);
                if(header == cur){
                    pastStack.add(0,header);
                    futureQueue.add(cur);
                }else{
                    boolean allSame = false;
                    for(char c : pastStack){
                        if(c != cur){
                            allSame = false;
                            break;
                        }
                        allSame = true;
                    }
                    for(char c : futureQueue){
                        if(c != cur){
                            allSame =false;
                            break;
                        }
                        allSame = true;
                    }
                    if(allSame){
                        futureQueue.add(cur);
                    }else{
                        stack.add(0, header);

                        int tmpLen = pastStack.size() + futureQueue.size();
                        StringBuilder sb = new StringBuilder();
                        while (!pastStack.isEmpty()) {
                            char c = pastStack.remove(0);
                            stack.add(0, c);
                            sb.append(c);
                        }
                        while (!futureQueue.isEmpty()) {
                            char c = futureQueue.remove(0);
                            stack.add(0, c);
                            sb.append(c);
                        }
                        if(tmpLen > maxLen){
                            maxLen = tmpLen;
                            longestString = sb.toString();
                            System.out.println(longestString);
                        }
                        if(!stack.isEmpty() && stack.size() > 1 && cur == stack.get(1)){
                            pastStack.add(0, stack.remove(0));
                            pastStack.add(0, stack.remove(0));
                            futureQueue.add(cur);
                        }else{
                            stack.add(0, cur);
                        }
                    }
                }
            }

        }
        if(pastStack.size() + futureQueue.size() > maxLen){
            maxLen = pastStack.size() + futureQueue.size();
            StringBuilder sb = new StringBuilder();
            while (!pastStack.isEmpty()){
                char c = pastStack.remove(0);
                stack.add(0, c);
                sb.append(c);
            }
            while (!futureQueue.isEmpty()){
                char c = futureQueue.remove(0);
                stack.add(0, c);
                sb.append(c);
            }
            longestString = sb.toString();
            System.out.println(longestString);
        }

        return longestString;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.longestPalindrome("ababababa"));
    }
}
