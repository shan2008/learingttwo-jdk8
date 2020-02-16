package com.yous.learningtwo.host.algorithm.LinkedNode;

import javax.xml.soap.Node;

/**
 * @author syou
 * @date 2020/2/16.
 */
public class DeleteNode {


    /**
     * 删除节点
     * 尾部节点无法删除
     *
     * @param node
     * @return
     */
    public boolean deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return false;
        }

        node.val = node.next.val;
        node.next = node.next.next;

        return true;
    }


    public ListNode deleteNode2(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        // 处理第一个是删除的节点
        if (head.val == val) {
            return head.next;
        }

        ListNode temp = head.next;
        ListNode pre = head;
        while (temp != null) {
            if (temp.val == val) {
                pre.next = temp.next;
            } else {
                pre = temp;
            }

            temp = temp.next;
        }

        return head;
    }


}
