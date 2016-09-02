package com.origintech.leetcode.problem21;

/**
 * Created by bcshuai on 8/28/16.
 */
public class Solution2 {
    public Solution.ListNode mergeTwoLists(Solution.ListNode l1, Solution.ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        Solution.ListNode header = new Solution.ListNode(0);
        Solution.ListNode tail = header;
        header.next = null;

        Solution.ListNode begin = null, end = null;
        Solution.ListNode listA = null, listB = null;
        while(l1 != null && l2 != null){

            if(l1.val <= l2.val){
                begin = l1; end = l1;
                for(;end.next != null && end.next.val <= l2.val; end = end.next);
                l1 = end.next;
                end.next = null;
                tail.next = begin;
                tail = end;
            }else{
                begin = l2; end = l2;
                for(;end.next != null && end.next.val <= l1.val; end = end.next);
                l2 = end.next;
                end.next = null;
                tail.next = begin;
                tail = end;
            }
        }
        if(l1 != null)
            tail.next = l1;
        if(l2 != null)
            tail.next = l2;
        return header.next;
    }
}
