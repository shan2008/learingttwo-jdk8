package com.yous.learningtwo.host.algorithm.LinkedNode;

import org.junit.Test;

public class MergeSortNode {
    @Test
    public void test(){

        ListNode l1=new ListNode(1);
        l1.next=new ListNode(3);
        l1.next.next=new ListNode(7);

        ListNode l2=new ListNode(2);
        l2.next=new ListNode(3);
        l2.next.next=new ListNode(8);

        ListNode node = mergeSortNode(l1, l2);
        NodeUtils.print(node);
    }


    public ListNode mergeSortNode(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode tmp = head;
        while (l1 != null && l2!= null) {
            if (l1.val > l2.val) {
                tmp.next = l2;
                l2=l2.next;
            }else {
                tmp.next=l1;
                l1=l1.next;
            }
            tmp = tmp.next;
        }

        if (l1 == null) {
            tmp.next = l2;
        }

        if (l2 == null) {
            tmp.next = l1;
        }

        return head.next;
    }
}
