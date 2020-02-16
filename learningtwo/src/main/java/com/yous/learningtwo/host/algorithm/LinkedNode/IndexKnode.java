package com.yous.learningtwo.host.algorithm.LinkedNode;

/**
 * @author syou
 * @date 2020/2/16.
 */
public class IndexKnode {
    /**
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
     * <p/>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public ListNode indexKnode(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        ListNode nodePre = head;
        ListNode nodeAfter = head;

        for (int i = 0; i < k - 1 && nodePre != null; i++) {
            nodePre = nodePre.next;
        }
        // 非法node
        if (nodePre == null) {
            return nodePre;
        }

        while (nodePre.next != null) {
            nodePre = nodePre.next;
            nodeAfter = nodeAfter.next;
        }

        return nodeAfter;
    }

}
