package com.yous.learningtwo.host.algorithm.LinkedNode;

import java.util.List;

public class tIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode tailA=headA;
        ListNode tailB=headB;
        while (tailA.next!= null) {
            tailA = tailA.next;
        }

        while (tailB.next!= null) {
            tailB = tailB.next;
        }


        while (headA.next != null && headB.next != null) {
            if (headA.val == headB.val) {
                return headA;
            }

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

}
