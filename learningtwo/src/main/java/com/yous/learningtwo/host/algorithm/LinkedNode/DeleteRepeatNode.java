package com.yous.learningtwo.host.algorithm.LinkedNode;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author syou
 * @date 2020/2/16.
 */
public class DeleteRepeatNode {

    /**
     * 删除重复元素
     * @param head
     * @return
     */
    public ListNode deleteRepeatNode(ListNode head) {
        if (head == null) {
            return head;
        }

        Set<Integer> set = new HashSet<>();
        ListNode temp = head;
        ListNode pre = null;
        while (temp != null) {
            if (set.add(temp.val)) {
                pre = temp;
            } else {
                pre.next = temp.next;
            }
            temp = temp.next;
        }
        return head;
    }


    /**
     * 删除重复元素
     *
     * @param head
     * @return
     */
    public ListNode deleteRepeatNode2(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode p = head;
        while (p != null) {
            ListNode q = p;
            while (q.next != null) {
                if (p.val == q.next.val) {
                    q.next = q.next.next;
                } else {
                    q = q.next;
                }
            }
            p = p.next;
        }

        return head;
    }


}
