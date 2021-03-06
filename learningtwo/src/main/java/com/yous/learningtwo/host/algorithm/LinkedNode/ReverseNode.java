package com.yous.learningtwo.host.algorithm.LinkedNode;

import org.junit.Test;

import java.util.Random;

/**
 * @author syou
 * @date 2019/6/26.
 */
public class ReverseNode {
    private final static Random random = new Random();


    @Test
    public void Test() {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);

       /* while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }*/

        ListNode node =reverseBetween(node1,1,2);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }


    /**
     * 合并两个有序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode pre = null;
        ListNode temp2 = null;
        // head2插入head1
        while (head1 != null && head2 != null) {
            if (head2.val <= head1.val && pre != null && head2.val >= pre.val) {
                pre.next = head2;
                temp2 = head2.next;
                head2.next = head1;
                head2 = temp2;
                pre = head1;
            } else {
                // 最后一个
                if (head1.next == null && head2 != null) {
                    head1.next = head2;
                }
                pre = head1;
                head1 = head1.next;
            }
        }

        return l1;
    }

    /**
     * java解决性能一般
     * 执行用时 : 2 ms在所有 Java 提交中击败了71.13%的用户
     * 内存消耗 : 39.1 MB在所有 Java 提交中击败了72.63%的用户
     * <p/>
     * 思路：
     * 1.由全部反转链表为基础
     * 2.思考反转k个后面保持不动如何解决
     * 3.在2的基础上,再反转后面的如何解决（递归）
     * 4.想如果递归，如何把每组反转连接在一起
     *
     * @param head
     * @param k
     * @return
     */

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode start = head;
        int size = 0;
        while (start != null) {
            size++;
            start = start.next;
        }

        // 不满个
        if (size < k || k == 1) {
            return head;
        }


        ListNode node1 = head.next;
        ListNode node3 = node1.next;
        ListNode temp = null;
        node1.next = head;
        head.next = null;
        int i = 1;
        while (node3 != null) {
            if (i == (k - 1)) {
                // node3又是头,node3 之后再反转
                head.next = reverseKGroup(node3, k);
                break;
            }
            temp = node3.next;
            node3.next = node1;
            node1 = node3;
            node3 = temp;
            i++;
        }

        return node1;
    }


    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseNode(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nextTemp;
        }

        return pre;
    }


    /**
     * 旋转N个节点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode reverseN(ListNode head, int n) {
        ListNode pre = null;
        ListNode cur = head;

        int index = 0;
        ListNode newTail = null;
        while (cur != null) {
            ListNode tempNext = cur.next;
            cur.next = pre;
            // 记录尾部
            if (pre == null) {
                newTail = cur;
            }
            if (index == n - 1) {
                newTail.next = tempNext;
                return cur;
            }

            pre = cur;
            cur = tempNext;
            index++;
        }

        return head;
    }


    public ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

}


