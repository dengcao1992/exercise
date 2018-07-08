package com.dcs.exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
合并含有K个元素的有序链表，并且作为一个有序链表的形式返回。分析并描述它的复杂度。
 */
public class HeBinYouXuLianBiao {
    public  ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode r = null;
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < lists.length;i++){
            ListNode a = lists[i];
            if (a == null) continue;
            while (a != null){
                list.add(a.val);
                a = a.next;
            }
        }
        Collections.sort(list);
        if (list.size() == 0) return r;
        r = new ListNode(0);
        ListNode a = r;
        for (int i = 0;i < list.size();i++){
            a.val = list.get(i) ;
           if (i != list.size() - 1) a.next = new ListNode(0);
            a = a.next;
        }
        return r;
    }

    public static void add(ListNode r,ListNode[] lists){

    }

    public static int repalce(int[] ints){
        int i = 0;
        return i;
    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {

    }
}
