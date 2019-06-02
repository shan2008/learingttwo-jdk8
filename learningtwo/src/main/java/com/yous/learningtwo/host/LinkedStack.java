package com.yous.learningtwo.host;

/**
 * @author syou
 * @date 2018/9/13.
 */
public class LinkedStack<T> {
    private static class Node<T> {
        T item;
        Node<T> top;

        Node() {
            item = null;
            top = null;
        }

        Node(T item, Node<T> top) {
            this.item = item;
            this.top = top;
        }

        boolean end() {
            return item == null && top == null;
        }
    }

    private Node<T> top = new Node<T>();

    public void push(T item) {
        top = new Node<T>(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.end()) {
            top = top.top;
        }
        return result;
    }

}
