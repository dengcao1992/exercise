package com.dcs.jian_zhi_offer;
/*
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
import java.util.HashMap;
import java.util.Map;

public class FuZhiLianBiao {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null) return null;
        Map<Integer,RandomListNode> map = new HashMap<>();
        RandomListNode reHead = new RandomListNode(pHead.label);
        RandomListNode res = reHead;
        while (pHead != null){
            if (pHead.next != null){
                if (map.containsKey(pHead.next.label)){
                    reHead.next = map.get(pHead.next.label);
                }else {
                    reHead.next = new RandomListNode(pHead.next.label);
                    map.put(reHead.next.label,reHead.next);
                }
            }
            if (pHead.random != null){
                if (map.containsKey(pHead.random.label)){
                    reHead.random = map.get(pHead.random.label);
                }else {
                    reHead.random = new RandomListNode(pHead.random.label);
                    map.put(reHead.random.label,reHead.random);
                }
            }
            pHead = pHead.next;
            reHead = reHead.next;
        }
        return res;
    }

    public static void main(String[] args) {
    }

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

}
