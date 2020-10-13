package com.yous.learningtwo.host.algorithm;

import com.yous.learningtwo.host.algorithm.LinkedNode.ListNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {


    @Test
    public void test2() {

        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);

        Node node1 = reLink(node);
        while (node1 != null) {
            System.out.println(node1.val);
        }

    }


    @Test
    public void test() {

        Node node = new Node(1);
        node.next = new Node(2);
        node.next.random = node;

        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.random = node.next.next;


        Node node2 = copyRandomList2(node);

        while (node2 != null) {
            System.out.println(node2.val);
            node2 = node2.next;
        }
    }

    public Node copyRandomList2(Node head) {
        copyNode(head);
        //random 指针指向
        linkRandom(head);
        // 拆分指向
        return reLink(head);
    }


    /**
     * haspMap实现
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        Node temp = head;
        Map<Node, Node> map = new HashMap<>();
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
        }


        return map.get(head);
    }


    /**
     * copy每个节点接入后面
     *
     * @param head
     */
    private void copyNode(Node head) {
        Node temp = null;
        while (head != null) {
            Node cloneNode = new Node(head.val);
            temp = head.next;
            head.next = cloneNode;
            cloneNode.next = temp;
            head = temp;
        }
    }


    /**
     * 随机指针指向
     *
     * @param head
     */
    private void linkRandom(Node head) {
        Node cloneNode = null;
        while (head != null) {
            cloneNode = head.next;
            if (head.random != null) {
                cloneNode.random = head.random.next;
            }
            head = cloneNode.next;
        }
    }


    /**
     * 不修改原始的指针
     *
     * @param head
     */
    private Node reLink(Node head) {
        Node cloneHead = head.next;
        Node cloneNode = cloneHead;
        while (head != null) {
            if (cloneNode != null) {
                head.next = cloneNode.next;
                head = head.next;
            }
            if (head != null) {
                cloneNode.next = head.next;
                cloneNode = cloneNode.next;
            }
        }

        return cloneHead;
    }
}


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
    }
}
