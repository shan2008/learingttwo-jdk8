package com.yous.learningtwo.host;


import java.util.*;

public class App {


    public static void main(String[] args) {



    }


}


class MyQueue {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    private volatile int size;


    public MyQueue(int size) {
        this.size = size;
    }

    public void push(int val) {
        synchronized (this) {
            if (stack2.size() >= size) {
                try {
                    wait();
                } catch (Exception e) {
                    //
                }
            }
            stack1.push(val);
            size++;

            notifyAll();
        }
    }

    public int pop() {
        int result = -1;
        synchronized (this) {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }

            while (stack2.isEmpty()) {
                try {
                    wait();
                } catch (Exception e) {
                    //
                }
            }

            result = stack2.pop();
            size--;
            notifyAll();
        }

        return result;
    }

}
