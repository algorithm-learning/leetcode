package com.origintech.leetcode.problem4;

/**
 * Created by bcshuai on 8/25/16.
 */
public class Solution {
    public int findKth(int[] num1, int begin1, int[] num2, int begin2, int k){
        int len1 = num1.length - begin1;
        int len2 = num2.length - begin2;
        if(len1 == 0){
            return num2[k - 1];
        }
        if(len2 == 0){
            return num1[k - 1];
        }
        if(k == 1){
            return Math.min(num1[begin1], num2[begin2]);
        }
        int half = (k >> 1) - 1;
        int tb1 = 0;
        int tb2 = 0;
        if(len1 < len2){
            tb1 = Math.min(half, len1 - 1);
            tb2 = k - (tb1 + 2);
        }else{
            tb2 = Math.min(half, len2 - 1);
            tb1 = k - (tb2 + 2);
        }

        int kth = 0;
        if(num1[begin1 + tb1] < num2[begin2 + tb2]){
            kth = findKth(num1, begin1 + tb1 + 1, num2, begin2, k - tb1 - 1);
        }else if(num2[begin2 + tb2] < num1[begin1 + tb1]){
            kth = findKth(num1, begin1, num2, begin2 + tb2 + 1, k - tb2 - 1);
        }else{
            kth = num1[begin1 + tb1];
        }

        return kth;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        double median = 0.0;
        if(totalLen % 2 == 1){
            median = findKth(nums1, 0, nums2, 0, (totalLen >> 1) + 1);
        }else{
            median = (findKth(nums1, 0, nums2, 0, (totalLen >> 1)) +
                    findKth(nums1, 0, nums2, 0, (totalLen >> 1) + 1)) / 2.0;
        }
        return median;
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.findMedianSortedArrays(new int[]{
                1, 2
        }, new int[]{
                1, 2
        }));
    }
}
