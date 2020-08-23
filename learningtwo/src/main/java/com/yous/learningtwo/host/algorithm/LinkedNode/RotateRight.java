package com.yous.learningtwo.host.algorithm.LinkedNode;

import org.junit.Test;

public class RotateRight {

    @Test
    public void test() {
        ListNode norepeatNode = NodeUtils.generateNoRepeatNode(3);
        NodeUtils.print(norepeatNode);
        ListNode node = rotateRight(norepeatNode, 3);
        NodeUtils.print(node);

      /*  //
        ListNode norepeatNode1 = NodeUtils.generateNoRepeatNode(3);
        NodeUtils.print(norepeatNode1);
        norepeatNode1 = rotateRight2(norepeatNode1, 3);
        NodeUtils.print(norepeatNode1);*/

    }

    /**
     * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        // 成环
        ListNode temp = head;
        ListNode saveHead = head;
        while (temp != null && temp.next != null) {
            temp = temp.next;
        }
        // 尾指向头
        temp.next = head;
        for (int i = 0; i < k; i++) {
            head = head.next;
        }

        if(head==temp){
            ListNode result=temp;
            temp.next.next=null;
            return result;
        }

        ListNode result = head.next;
        head.next = null;
        return result;
    }


    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode tail = null;
        int len = 0;
        while (p != null) {
            tail = p;
            p = p.next;
            len++;
        }

        // tail是尾部,组成环形的
        int r = k % len;
        if (r == 0) {
            return head;
        }
        tail.next = head;

        for (int i = 0; i < len - r - 1; i++) {
            head = head.next;
        }
        // 断开 tail;

        tail = head.next;
        head.next = null;
        return tail;
    }

}
