package com.dcs.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LinkListNumberAdd {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result =  new ListNode(0);
        ListNode r = result;
        while (true){
            int a = l1.val;
            int b = l2.val;
            if (l1.next == null && l2.next == null){
                if (r.val + a + b < 10){
                    r.val = (r.val + a + b)%10;
                    break;
                }
                r.next = new ListNode(r.val + a + b >= 10 ? (r.val + a + b)/10 : 0);
                r.val = (r.val + a + b)%10;
                break;
            }
            r.next = new ListNode(r.val + a + b >= 10 ? (r.val + a + b)/10 : 0);
            r.val = (r.val + a + b)%10;
            r = r.next;
            l1 = l1.next == null ? new ListNode(0):l1.next;
            l2 = l2.next == null ? new ListNode(0):l2.next;
        }
        return result;
    }

}
