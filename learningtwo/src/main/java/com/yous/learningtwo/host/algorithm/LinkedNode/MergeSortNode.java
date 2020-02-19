package com.yous.learningtwo.host.algorithm.LinkedNode;

public class MergeSortNode {

    public ListNode mergeSortNode(ListNode l1, ListNode l2) {
        ListNode tempHead = new ListNode(-1);
        ListNode retNextHead = tempHead;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                tempHead.next = l2;
                l2 = l2.next;
            } else {
                tempHead.next = l1;
                l1 = l1.next;
            }
        }
        if (l1 == null) {
            tempHead.next = l2;
        }
        if (l2 == null) {
            tempHead.next = l1;
        }

        return retNextHead.next;
    }
}
