package com.origintech.playground.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bcshuai on 12/10/2016.
 */
public class Problem2 {
    public static void sort(List<Integer> data){
        if (data == null){
            return;
        }
        for(int i = 0; i < data.size(); i++){
            int c = data.remove(i);
            int j = 0;
            for(; j < i; j++){
                if(c <= data.get(j)){
                    data.add(j, c);
                    break;
                }
            }
            if(j == i){
                data.add(j, c);
            }
        }
    }
    public static void main(String[] args){
        List<Integer> d = new ArrayList<>();
        d.add(2);
        d.add(3);
        d.add(8);
        d.add(4);
        d.add(9);
        d.add(1);
        sort(d);
        for(int i = 0; i < d.size(); i++){
            System.out.print(" " + d.get(i));
        }
        System.out.println();
    }
}
