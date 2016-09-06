package com.origintech.leetcode.problem72;

/**
 * Created by shuaibincheng on 16/9/3.
 */
public class Solution2 {
    public int minDistance(String word1, String word2) {
        int[][] distance = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 0; i <= word1.length(); i++){
            for(int j = 0; j <= word2.length(); j++){
                if(i == 0){
                    distance[0][j] = j;
                    continue;
                }
                if(j == 0){
                    distance[i][0] = i;
                    continue;
                }
                int replace = 0, insert = 0, del = 0;
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    distance[i][j] = distance[i - 1][j - 1];
                }else{
                    replace = distance[i - 1][j - 1] + 1;
                    insert = distance[i][j - 1] + 1;
                    del = distance[i - 1][j] + 1;
                    distance[i][j] = Math.min(Math.min(insert,del), replace);
                }
            }
        }
        return distance[word1.length()][word2.length()];
    }
    public static void main(String[] args){
        String w1 = "1234859589";
        String w2 = " 234843295";
        //String w1 = "a";
        //String w2 = "a";
        Solution2 s = new Solution2();
        System.out.println(s.minDistance(w1, w2));
    }
}
