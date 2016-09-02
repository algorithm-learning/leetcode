package com.origintech.leetcode.problem23;



public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode header = new ListNode(0);
        header.next = null;
        ListNode pre =  header;
        ListNode begin = null, end = null;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                begin = l1; end = l1;
                for(;end.next != null && end.next.val < l2.val; end = end.next);
                pre.next = begin;
                l1 = end.next;
                pre = end;
            }else{
                begin = l2; end = l2;
                for(;end.next != null && end.next.val < l1.val; end = end.next);
                pre.next = begin;
                l2 = end.next;
                pre = end;
            }
        }
        if(l1 == null)
            pre.next = l2;
        if(l2 == null)
            pre.next = l1;
        return header.next;
    }
    public ListNode merge(ListNode[] lists, int begin, int end){
        if(begin == end){
            return lists[begin];
        }
        int mid = (begin + end) >> 1;
        ListNode l1 = merge(lists, begin, mid);
        ListNode l2 = merge(lists, mid + 1, end);
        return mergeTwoLists(l1, l2);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        return merge(lists, 0, lists.length);
    }
}
