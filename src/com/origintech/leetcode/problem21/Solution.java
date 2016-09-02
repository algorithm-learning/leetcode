package com.origintech.leetcode.problem21;

import java.util.List;

/**
 * Created by bcshuai on 8/28/16.
 */

/**
 * 失败
 */
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode header = new ListNode(0);
        header.next = l1;
        ListNode preLn1 = header, ln1 = header.next; ListNode ln2 = l2;
        ListNode begin = ln2, end = ln2;
        while(ln1 != null && ln2 != null){
            begin = ln2; end = ln2;
            if(ln1.val > ln2.val){
                for(;end.next != null && end.next.val <= ln1.val; end = end.next);
                preLn1.next = begin;
                ln2 = end.next;
                end.next = ln1;
                preLn1 = end;
            }else{
                for(;end.next != null && ln1.next != null && end.next.val > ln1.next.val; end = end.next);
                ListNode tmp = ln1.next;
                ln2 = end.next;
                ln1.next = begin;
                end.next = tmp;
                preLn1 = end;
            }
        }
        ln1.next = ln2;
        return header.next;
    }
}
