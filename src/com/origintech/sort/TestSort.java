package com.origintech.sort;

import com.origintech.sort.algo.QuickSort;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by bcshuai on 24/09/2016.
 */
public class TestSort {
    private Integer[] nums = null;
    private Integer[] result = null;
    private int count = 0;
    private Sort<Integer> sort = null;
    @Before
    public void setup(){
        //count = (int)(Math.random() * 1000000) + 1;
        nums = new Integer[count];
        for(int i = 0; i < count; i++){
            nums[i] = (int)(Math.random() * 1000000) + 1;
        }
        result = Arrays.copyOf(nums, nums.length);
        Arrays.sort(result);

        sort = new QuickSort<>();
    }

    @Test
    public void testQuickSort(){
        sort.sort(nums);
        Assert.assertArrayEquals("快速排序单元测试",result, nums);
    }
}
