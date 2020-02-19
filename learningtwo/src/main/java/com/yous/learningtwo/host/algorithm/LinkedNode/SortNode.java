package com.yous.learningtwo.host.algorithm.LinkedNode;

import org.junit.Test;

/**
 * @author syou
 * @date 2019/12/2.
 */
public class SortNode {


    @Test
    public void Test() {
        ListNode node1 = new ListNode(3);
        node1.next = new ListNode(1);
        node1.next.next = new ListNode(10);
        node1.next.next.next = new ListNode(5);
        NodeUtils.print(node1);

        node1 = sortNodeList(node1);
        NodeUtils.print(node1);
    }

    /**
     * 链表排序
     *
     * @param head
     * @return
     */
    public ListNode sortNodeList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head.next, slow = head, r, l;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        r = sortNodeList(slow.next);
        slow.next = null;
        l = sortNodeList(head);


        return mergeSortNode(r, l);
    }


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
            tempHead=tempHead.next;
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
