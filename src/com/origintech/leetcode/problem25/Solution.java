package com.origintech.leetcode.problem25;

import java.util.List;

/**
 * Created by bcshuai on 8/28/16.
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode reverseList(ListNode head, int len){
        ListNode fakeHeader = new ListNode(0);
        ListNode next = null, tmp = null;
        while(head != null && len > 0){
            tmp = fakeHeader.next;
            fakeHeader.next = head;
            next = head.next;
            head.next = tmp;
            head = next;
            --len;
        }
        return fakeHeader.next;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 1)
            return head;
        ListNode fakeHeader = new ListNode(0);
        fakeHeader.next = head;
        ListNode pre = fakeHeader;
        ListNode cur = head;
        int count = 0;
        while(cur != null){
            ++count;
            if(count != k){
                cur = cur.next;
                continue;
            }
            ListNode tmp1 = pre.next;
            ListNode tmp2 = cur.next;
            ListNode tmp3 = reverseList(pre.next, k);
            pre.next = tmp3;
            tmp1.next = tmp2;

            pre = tmp1;
            cur = tmp2;
        }
        return fakeHeader.next;
    }
}