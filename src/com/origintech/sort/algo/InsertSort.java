package com.origintech.sort.algo;

import com.origintech.sort.Sort;

/**
 * Created by bcshuai on 12/10/2016.
 */
public class InsertSort implements Sort {
    @Override
    public void sort(Object[] v) {
        if(v.length <= 1){
            return;
        }
        if( !(v instanceof Comparable[])){
            return;
        }
    }
}
