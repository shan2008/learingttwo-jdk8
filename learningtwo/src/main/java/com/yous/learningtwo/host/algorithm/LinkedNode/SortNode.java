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

        node1 = sortList(node1);
        NodeUtils.print(node1);
    }


    public ListNode sortList(ListNode head) {
        return head == null ? null : sort(head);
    }


    public ListNode sort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next, r, l;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        r = sort(slow.next);
        slow.next = null;
        l = sort(head);

        return merge(l, r);
    }

    public ListNode merge(ListNode l, ListNode r) {
        ListNode tempHead = new ListNode(-1);
        ListNode p = tempHead;
        while (l != null && r != null) {
            if (r.val < l.val) {
                p.next = r;
                r = r.next;
            } else {
                p.next = l;
                l = l.next;
            }
            p = p.next;
        }

        p.next = l == null ? r : l;
        return tempHead.next;
    }

}
