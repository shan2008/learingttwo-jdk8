package com.yous.learningtwo.host.algorithm.LinkedNode;

/**
 * @author syou
 * @date 2019/12/2.
 */
public class ReverseKNode {

    /**
     * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数
     *
     * @param head
     * @return
     */
    public ListNode reverseKNode(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode tail = null;
        int len = 0;
        while (p != null) {
            tail=p;
            p = p.next;
            len++;
        }

        // tail是尾部,组成环形的
        int r= k%len;
        if (r== 0) {
            return head;
        }

        tail.next=head;

        for (int i=0;i<len-r-1;i++){
            head=head.next;
        }
        // 断开 tail;

        tail=head.next;
        head.next=null;
        return tail;
    }
}
