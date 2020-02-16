package com.yous.learningtwo.host.algorithm.LinkedNode;

import java.util.Stack;

/**
 * @author syou
 * @date 2020/2/16.
 */
public class ReversePrintNode {
    String string = "";


    /**
     * 递归输出
     *
     * @param head
     */
    public void reversePrintNode(ListNode head) {
        if (head != null) {
            reversePrintNode(head.next);
            System.out.println(head.val + ",");
        }
    }


    /**
     * 采用栈输出
     *
     * @param head
     */
    public void reversePrintNode2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }


        while (!stack.isEmpty()) {
            System.out.println(stack.pop().val+",");
        }

    }

}
