package com.yous.learningtwo.host.algorithm.LinkedNode;

import java.util.List;

public class tIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA=headA,pB=headB;
        while (headA!=headB){
            pA=pA==null?headB:pA.next;
            pB=pB==null?headA:pB.next;
        }

        return headA;
    }

}
