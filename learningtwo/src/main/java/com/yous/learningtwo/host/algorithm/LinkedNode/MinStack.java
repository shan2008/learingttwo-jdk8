package com.yous.learningtwo.host.algorithm.LinkedNode;

public class MinStack {
    Node head;

    public MinStack() {

    }

    public void push(int x) {
        if(head==null){
            head=new Node(x,x,null);
        }else {
            head=new Node(x,Math.min(x,head.val),head);
        }
    }

    public void pop() {
        head=head.next;
    }

    public int top() {
        return head!=null?head.val:-1;
    }

    public int min() {
        return head!=null?head.min:-1;
    }
}
