package com.yous.learningtwo.host.algorithm;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LRUCache1 {
    public static void main(String[] args) {

        LRUCache1 lruCache1 = new LRUCache1(3);
        lruCache1.put(1, 1);
        lruCache1.put(2, 2);
        System.out.println(lruCache1.get(1));
        lruCache1.put(3, 3);
        lruCache1.put(4, 4);
        lruCache1.get(4);
        lruCache1.get(3);

        System.out.println("done");

    }


    class Node {
        int key, val;
        Node pre;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public Node() {

        }
    }

    Map<Integer, Node> map = new HashMap<>();
    private Node head = null;
    private Node tail = null;
    private int size;
    private int capacity;

    public LRUCache1(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next=tail;
        tail.pre=head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node result = map.get(key);
        remove(result);
        addFirst(result);
        return result.val;
    }


    public void put(int key, int val) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node(key, val);
            map.put(key, node);
            addFirst(node);
            size++;
            if (size > capacity) {
                map.remove(tail.pre.key);
                removeLast();
                size--;
            }
        } else {
            remove(node);
            addFirst(node);
            map.get(key).val = val;
        }
    }

    private void addFirst(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void removeLast() {
        remove(tail.pre);
    }


}
