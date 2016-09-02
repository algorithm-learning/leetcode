package com.origintech.leetcode.problem18;

/**
 * Created by bcshuai on 8/27/16.
 */
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preTarget = null;
        ListNode target = null;
        ListNode cur = head;
        if(head == null)
            return head;
        int count = 0;
        for(count = 1; count < n && cur.next != null; count++, cur = cur.next);
        if(cur.next == null && count <= n - 1)
            return head;
        target = head;
        while(cur.next != null){
            preTarget = target;
            target = target.next;
            cur = cur.next;
        }
        if(target == null){
            return head;
        }
        if(preTarget == null){
            return head.next;
        }
        preTarget.next = target.next;
        return head;
    }
}
