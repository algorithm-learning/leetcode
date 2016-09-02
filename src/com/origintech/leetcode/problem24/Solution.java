package com.origintech.leetcode.problem24;

/**
 * Created by bcshuai on 8/28/16.
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode fakeHeader = new ListNode(0);
        fakeHeader.next = head;
        ListNode pre = fakeHeader, cur = head;
        ListNode tmp1 = null, tmp2 = null;
        int count = 0;
        while(cur != null){
            ++count;
            if(count != 2) {
                cur = cur.next;
                continue;
            }
            tmp1 = pre.next;
            tmp2 = cur.next;

            pre.next = cur;
            cur.next = tmp1;
            tmp1.next = tmp2;

            cur = tmp2;
            pre = tmp1;
            count = 0;
        }
        return fakeHeader.next;
    }
}
