package com.origintech.sort.algo;

import com.origintech.sort.Sort;

import java.util.Comparator;

/**
 * Created by bcshuai on 24/09/2016.
 */
public class QuickSort<T> implements Sort<T> {
    @Override
    public void sort(T[] v) {
        if(v.length <= 1)
            return;
        if(!(v instanceof Comparable[])){
            return;
        }
        internalSort((Comparable[])v, 0, v.length - 1);
    }
    private void internalSort(Comparable[] v, int begin, int end){
        if(end <= begin){
            return;
        }
        Comparable pivot = v[begin];
        int left = begin, right = end;
        while(left < right){
            for(;right > left && v[right].compareTo(pivot) >= 0; --right);
            if(right > left){
                v[left] = v[right];
            }
            for(;left < right && v[left].compareTo(pivot) <0; ++left);
            if(left < right){
                v[right] = v[left];
            }
        }
        v[left] = pivot;
        internalSort(v, begin, left - 1);
        internalSort(v, left + 1, end);
    }
}
