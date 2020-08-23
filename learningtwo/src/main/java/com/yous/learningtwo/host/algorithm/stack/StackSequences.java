package com.yous.learningtwo.host.algorithm.stack;

import java.util.Stack;
import java.util.concurrent.DelayQueue;

public class StackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (popped == null || pushed == null) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int j = 0; j < pushed.length; j++) {
            stack.push(pushed[j]);
            while (i < popped.length && !stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }

        return i == popped.length;
    }


}
