package com.dcs.exercise;
/*
给定一个链表，删除链表的倒数第 n 个节点并返回头结点。
 */
public class SanChuLianBiao {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int count = n;
        if (n == 0) return head;
        if (head.next == null) return null;
        ListNode a = null;
        ListNode b = head;
        ListNode c = head;
        while (c != null){
            c = c.next;
            if (count == 0){
                a = b;
                b = b.next;
                count = 1;
            }
            count--;
        }
        if (a == null) return b.next;
        a.next = b.next;
        return head;
    }
}
